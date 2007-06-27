package org.mifos.application.surveys.struts.action;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.NotImplementedException;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.mifos.application.accounts.business.AccountBO;
import org.mifos.application.accounts.loan.business.LoanBO;
import org.mifos.application.accounts.loan.business.service.LoanBusinessService;
import org.mifos.application.customer.business.service.CustomerBusinessService;
import org.mifos.application.customer.business.CustomerBO;
import org.mifos.application.customer.center.business.CenterBO;
import org.mifos.application.customer.client.business.ClientBO;
import org.mifos.application.customer.util.helpers.CustomerLevel;
import org.mifos.application.personnel.business.PersonnelBO;
import org.mifos.application.personnel.persistence.PersonnelPersistence;
import org.mifos.application.surveys.SurveysConstants;
import org.mifos.application.surveys.business.Survey;
import org.mifos.application.surveys.business.SurveyInstance;
import org.mifos.application.surveys.business.SurveyQuestion;
import org.mifos.application.surveys.business.SurveyResponse;
import org.mifos.application.surveys.helpers.AnswerType;
import org.mifos.application.surveys.helpers.SurveyType;
import org.mifos.application.surveys.helpers.InstanceStatus;
import org.mifos.application.surveys.persistence.SurveysPersistence;
import org.mifos.application.util.helpers.ActionForwards;
import org.mifos.framework.business.BusinessObject;
import org.mifos.framework.business.service.BusinessService;
import org.mifos.framework.exceptions.PersistenceException;
import org.mifos.framework.exceptions.ServiceException;
import org.mifos.framework.formulaic.BaseValidator;
import org.mifos.framework.formulaic.EnumValidator;
import org.mifos.framework.formulaic.ErrorType;
import org.mifos.framework.formulaic.IntValidator;
import org.mifos.framework.formulaic.IsInstanceValidator;
import org.mifos.framework.formulaic.DateComponentValidator;
import org.mifos.framework.formulaic.PersonnelValidator;
import org.mifos.framework.formulaic.Schema;
import org.mifos.framework.formulaic.SchemaValidationError;
import org.mifos.framework.formulaic.ValidationError;
import org.mifos.framework.formulaic.Validator;
import org.mifos.framework.security.util.ActionSecurity;
import org.mifos.framework.security.util.UserContext;
import org.mifos.framework.security.util.resources.SecurityConstants;
import org.mifos.framework.struts.action.BaseAction;
import org.mifos.framework.struts.actionforms.GenericActionForm;
import org.mifos.framework.util.helpers.Constants;
import org.mifos.framework.util.helpers.DateUtils;
import org.mifos.framework.util.helpers.StringUtils;

public class SurveyInstanceAction extends BaseAction {


	private static Schema chooseSurveyValidator;
	private static Schema createEntryValidator;
	private static Schema previewValidator;
	private static Schema sessionValidator;

	private class SurveyValidator extends Schema {

		private Survey survey;

		public SurveyValidator(Survey survey) {
			this.survey = survey;
			DateComponentValidator dateSurveyedValidator = new DateComponentValidator();
			dateSurveyedValidator.setErrorPrefix("errors.dateSurveyed");
			setMapValidator("dateSurveyed", dateSurveyedValidator);
		}

		@Override
		public Map<String, Object> validate(Object objectData)
				throws ValidationError {
			Map<String, Object> data;
			data = super.validate(objectData);
			Map<String, Object> results = new HashMap<String, Object>();
			results.put("dateSurveyed", data.get("dateSurveyed"));

			Map fieldErrors = new HashMap<String, ValidationError>();
			for (SurveyQuestion question : survey.getQuestions()) {
				String formName = "response_"
						+ Integer.toString(question.getQuestion()
								.getQuestionId());
				String input = (String) data.get(formName);

				String formInput;
				if (question.getQuestion().getAnswerTypeAsEnum() == AnswerType.DATE) {
					String dayValue = (String) data.get(formName + "DD");
					String monthValue = (String) data.get(formName + "MM");
					String yearValue = (String) data.get(formName + "YY");
					formInput = dayValue + "/" + monthValue + "/" + yearValue;
				}
				else {
					formInput = (String) data.get(formName);
				}

				if (question.getMandatory() == 1
						&& StringUtils.isNullOrEmpty(formInput)) {
					int questionNum = survey.getQuestions().indexOf(question) + 1;
					ActionMessage newMessage = new ActionMessage(getKey(ErrorType.MISSING.toString()), Integer.toString(questionNum));
					fieldErrors.put(formName, new ValidationError(formInput, newMessage));
				}

				try {
					question.getQuestion().validate(formInput);
					results.put(formName, formInput);
				}
				catch (ValidationError e) {
					// find the number of the question in the survey, so we can
					// give a helpful error message
					int questionNum = survey.getQuestions().indexOf(question) + 1;
					ActionMessage newMessage = new ActionMessage(e.getMsg(),
							Integer.toString(questionNum));
					fieldErrors.put(formName, new ValidationError(formInput, newMessage));
				}
			}

			if (fieldErrors.size() > 0) {
				throw new SchemaValidationError(data, fieldErrors);
			}

			return results;
		}
	}

	static {

		chooseSurveyValidator = new Schema();
		chooseSurveyValidator.setSimpleValidator("globalNum",
				new IsInstanceValidator(String.class));
		chooseSurveyValidator.setSimpleValidator("surveyType",
				new EnumValidator(SurveyType.class));

		createEntryValidator = new Schema();
		createEntryValidator.setSimpleValidator("value(surveyId)",
				new IntValidator());

		previewValidator = new Schema();
		previewValidator.setComplexValidator("dateSurveyed",
				new DateComponentValidator());

		sessionValidator = new Schema();
		sessionValidator.setSimpleValidator(SurveysConstants.KEY_SURVEY,
				new IsInstanceValidator(Survey.class));
		sessionValidator.setSimpleValidator(Constants.BUSINESS_KEY,
				new IsInstanceValidator(BusinessObject.class));

	}

	public static ActionSecurity getSecurity() {
		ActionSecurity security = new ActionSecurity("surveyInstanceAction");
		security.allow("create_entry", SecurityConstants.VIEW);
		security.allow("create", SecurityConstants.VIEW);
		security.allow("choosesurvey", SecurityConstants.VIEW);
		security.allow("preview", SecurityConstants.VIEW);
		security.allow("get", SecurityConstants.VIEW);
		return security;
	}

	@Override
	protected BusinessService getService() throws ServiceException {
		throw new RuntimeException("not implemented");
		//		return new SurveysBusinessService();
	}
	

	// set the business key to the business object for the header link
	// set the survey instance
	// set the business object name, type and global id
	public ActionForward get(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SurveysPersistence persistence = new SurveysPersistence();
		GenericActionForm actionForm = (GenericActionForm) form;
		
		int instanceId = Integer.parseInt(actionForm.getValue("instanceId"));
		SurveyInstance instance = persistence.getInstance(instanceId);
		SurveyType surveyType = instance.getSurvey().getAppliesToAsEnum();
		BusinessObject businessObject;
		String businessObjectName;
		String businessObjectType;
		
		if (surveyType == SurveyType.CLIENT) {
			String globalNum = instance.getCustomer().getGlobalCustNum();
			businessObject = getBusinessObject(surveyType, globalNum);
			businessObjectName = getBusinessObjectName(surveyType, globalNum);
			businessObjectType = surveyType.toString(); 
		}
		else {
			throw new NotImplementedException();
		}
		
		request.setAttribute(SurveysConstants.KEY_INSTANCE, instance);
		request.setAttribute(SurveysConstants.KEY_BUSINESS_OBJECT_NAME, businessObjectName);
		request.getSession().setAttribute(Constants.BUSINESS_KEY, businessObject);
		request.setAttribute(SurveysConstants.KEY_BUSINESS_TYPE, businessObjectType);
		
		return mapping.findForward(ActionForwards.get_success
				.toString());
	}

	public ActionForward create_entry(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> results;
		try {
			results = createEntryValidator.validate(request);
		}
		catch (SchemaValidationError e) {
			// is this the right page to show?
			saveErrors(request, Schema.makeActionMessages(e));
			return mapping.findForward(ActionForwards.choose_survey.toString());
		}

		SurveysPersistence persistence = new SurveysPersistence();
		int surveyId = (Integer) results.get("value(surveyId)");
		Survey survey = persistence.getSurvey(surveyId);
		request.getSession().setAttribute(SurveysConstants.KEY_SURVEY, survey);

		BusinessObject businessObject = (BusinessObject) request.getSession()
				.getAttribute(Constants.BUSINESS_KEY);
		String displayName = getBusinessObjectName(businessObject);
		request.getSession().setAttribute(
				SurveysConstants.KEY_BUSINESS_OBJECT_NAME, displayName);

		return mapping.findForward(ActionForwards.create_entry_success
				.toString());
	}

	public static String getBusinessObjectName(BusinessObject businessObject)
			throws Exception {
		if (CustomerBO.class.isInstance(businessObject)) {
			return ((CustomerBO) businessObject).getDisplayName();
		}
		
		else if (LoanBO.class.isInstance(businessObject)) {
			LoanBO loanBO = (LoanBO) businessObject;
			return loanBO.getLoanOffering().getPrdOfferingName() + "# "
					+ loanBO.getGlobalAccountNum();
		}
		else {
			throw new NotImplementedException();
		}
	}

	/*
	 * Use a combination of {@link #getBusinessObject(SurveyType surveyType, String globalNum)} and
	 * {@link #getBusinessObjectName(BusinessObject customer)} instead of this method.
	 */
	public static String getBusinessObjectName(SurveyType surveyType,
			String globalNum) throws Exception {
		if (surveyType == SurveyType.CLIENT) {
			ClientBO client = (ClientBO) CustomerBusinessService.getInstance()
					.findBySystemId(globalNum, CustomerLevel.CLIENT.getValue());
			return client.getDisplayName();
		}
		else if (surveyType == SurveyType.LOAN) {
			LoanBusinessService service = new LoanBusinessService();
			LoanBO loanBO = service.findBySystemId(globalNum);
			return loanBO.getLoanOffering().getPrdOfferingName() + "# "
					+ globalNum;
		}
		else {
			throw new NotImplementedException();
		}
	}

	public static BusinessObject getBusinessObject(SurveyType surveyType,
			String globalNum) throws Exception {
		if (surveyType == SurveyType.CLIENT) {
			ClientBO client = (ClientBO) CustomerBusinessService.getInstance()
					.findBySystemId(globalNum, CustomerLevel.CLIENT.getValue());
			return client;
		}
		else if (surveyType == SurveyType.LOAN) {
			LoanBusinessService service = new LoanBusinessService();
			LoanBO loanBO = service.findBySystemId(globalNum);
			return loanBO;
		}
		else {
			throw new NotImplementedException();
		}
	}

	public ActionForward choosesurvey(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> results;
		GenericActionForm actionForm = (GenericActionForm) form;
		try {
			results = chooseSurveyValidator.validate(request);
		}
		catch (SchemaValidationError e) {
			saveErrors(request, Schema.makeActionMessages(e));
			// errors should never happen here... user enters no data.  so what page should we show?
			// this is mostly for clean testing
			return mapping.findForward(ActionForwards.choose_survey.toString());
		}
		
		UserContext userContext = getUserContext(request);
		actionForm.setValue("officerName", userContext.getName());

		SurveysPersistence persistence = new SurveysPersistence();
		String globalNum = (String) results.get("globalNum");
		SurveyType surveyType = SurveyType.fromString(request
				.getParameter("surveyType"));

		BusinessObject businessObject = getBusinessObject(surveyType, globalNum);
		request.getSession().setAttribute(Constants.BUSINESS_KEY,
				businessObject);
		String displayName = getBusinessObjectName(businessObject);
		request.getSession().setAttribute(
				SurveysConstants.KEY_BUSINESS_OBJECT_NAME, displayName);

		List<Survey> surveys = persistence.retrieveSurveysByType(surveyType);
		request.setAttribute(SurveysConstants.KEY_SURVEYS_LIST, surveys);
		return mapping.findForward(ActionForwards.choose_survey.toString());
	}

	public ActionForward preview(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> results = null;
		ActionMessages errors = new ActionMessages();
		GenericActionForm actionForm = (GenericActionForm) form;
		try {
			sessionValidator.validate(request.getSession());
			Survey survey = (Survey) request.getSession().getAttribute(
					SurveysConstants.KEY_SURVEY);
			results = new SurveyValidator(survey).validate(actionForm);
		}
		catch (SchemaValidationError e) {
			errors.add(e.makeActionMessages());
		}
		
		// verify that a real officer username is provided
		String officerName = actionForm.getValue("officerName");
		PersonnelPersistence personnelPersistence = new PersonnelPersistence();
		PersonnelBO officer = personnelPersistence.getPersonnel(officerName);
		if (officer == null) {
			errors.add("value(officerName)", new ActionMessage(SurveysConstants.INVALID_OFFICER));
		}

		if (errors.size() > 0) {
			saveErrors(request, errors);
			return mapping.findForward(ActionForwards.create_entry_success
					.toString());
		}

		InstanceStatus status = InstanceStatus.COMPLETED;
		for (String key : results.keySet()) {
			Object value = results.get(key);
			if (value.equals("") || value == null) {
				status = InstanceStatus.INCOMPLETE;
				break;
			}
		}

		actionForm.setValue("instanceStatus", Integer.toString(status
				.getValue()));

		BusinessObject businessObject = (BusinessObject) request.getSession()
				.getAttribute(Constants.BUSINESS_KEY);
		String displayName = getBusinessObjectName(businessObject);
		request.setAttribute(
				SurveysConstants.KEY_BUSINESS_OBJECT_NAME, displayName);
		request.setAttribute("dateSurveyed", actionForm
				.getDateValue("dateSurveyed"));
		request.setAttribute("officerName", actionForm.getValue("officerName"));

		return mapping.findForward(ActionForwards.preview_success.toString());
	}

	/*
	 * This page is the page where we actually create a new survey instance, after
	 * optionally filling in responses
	 */
	public ActionForward create(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> results;
		Map<String, Object> formInputs;
		Survey survey;
		GenericActionForm actionForm;
		try {
			results = sessionValidator.validate(request.getSession());
			survey = (Survey) results.get(SurveysConstants.KEY_SURVEY);
			actionForm = (GenericActionForm) form;
			formInputs = new SurveyValidator(survey).validate(actionForm);
		}
		catch (SchemaValidationError e) {
			return mapping.findForward(ActionForwards.create_entry_success
					.toString());
		}

		SurveysPersistence persistence = new SurveysPersistence();
		org.mifos.application.personnel.persistence.PersonnelPersistence personnelPersistence = new org.mifos.application.personnel.persistence.PersonnelPersistence();

		BusinessObject businessObject = (BusinessObject) results
				.get(Constants.BUSINESS_KEY);

		/*
		InstanceStatus status = InstanceStatus.fromInt(Integer
				.parseInt(actionForm.getValue("instanceStatus")));
		*/
		// partially completed instances not supported yet
		InstanceStatus status = InstanceStatus.COMPLETED; 
		String officerName = actionForm.getValue("officerName");
		Date dateConducted = DateUtils.getDateAsSentFromBrowser(actionForm
				.getDateValue("dateSurveyed"));

		PersonnelBO officer = personnelPersistence.getPersonnel(officerName);

		SurveyInstance instance = new SurveyInstance();

		instance.setSurvey(survey);
		instance.setDateConducted(dateConducted);
		instance.setCompletedStatus(status);
		instance.setOfficer(officer);
		if (CustomerBO.class.isInstance(businessObject)) {
			instance.setCustomer((CustomerBO) businessObject);
		}
		else { // Account
			instance.setAccount((AccountBO) businessObject);
		}

		List<SurveyResponse> surveyResponses = new ArrayList<SurveyResponse>();
		List<String> responseKeys = new LinkedList<String>();
		String prefix = "response_";
		for (String key : formInputs.keySet()) {
			if (key.startsWith(prefix)) {
				responseKeys.add(key);
			}
		}
		Collections.sort(responseKeys);
		for (String key : responseKeys) {
			SurveyResponse surveyResponse = new SurveyResponse();
			surveyResponse.setQuestion(survey.getQuestionById(Integer
					.parseInt(key.substring(prefix.length()))));
			String stringValue = (String) formInputs.get(key);
			surveyResponse.setStringValue(stringValue);
			surveyResponse.setInstance(instance);
			surveyResponses.add(surveyResponse);
			persistence.createOrUpdate(surveyResponse);
		}
		
		persistence.createOrUpdate(instance);

		String redirectUrl;
		if (survey.getAppliesToAsEnum() == SurveyType.CLIENT) {
			redirectUrl = "clientCustAction.do?method=get&globalCustNum=" + instance.getCustomer().getGlobalCustNum();
		}
		else if (survey.getAppliesToAsEnum() == SurveyType.GROUP) {
			redirectUrl = "groupCustAction.do?method=get&globalCustNum=" + instance.getCustomer().getGlobalCustNum();
		}
		else if (survey.getAppliesToAsEnum() == SurveyType.CENTER) {
			redirectUrl = "centerCustAction.do?method=get&globalCustNum=" + instance.getCustomer().getGlobalCustNum();
		}
		else { // account instances not implemented yet
			throw new NotImplementedException();
		}
		response.sendRedirect(redirectUrl);
		return null;
	}

	@Override
	protected boolean skipActionFormToBusinessObjectConversion(String method) {
		return true;
	}

}
