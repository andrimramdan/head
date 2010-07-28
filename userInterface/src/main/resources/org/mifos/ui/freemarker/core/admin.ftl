[#ftl]
[#import "spring.ftl" as spring]
[#import "blueprintmacros.ftl" as mifos]
[@mifos.header "title" /]
  [@mifos.topNavigationNoSecurity currentTab="Admin" /]
  <!--  Left Sidebar Begins-->
  <div class="sidebar ht600">
  [#include "adminLeftPane.ftl" ]
  </div> 
  <!--  Left Sidebar Ends-->
  
  <!--  Main Content Begins-->  
   <div>
  <div class=" content leftMargin180">
    <div class="orangeheading font14 marginLeft30">[@spring.message "administrativeTasks" /]</div>
    <p class="marginLeft30">[@spring.message "administrativeTasksWelcome" /] </p>
    <div class="marginTop20"></div>
    <div class="span-10 floatLT marginLeft30">
      <p class="orangeheading">[@spring.message "manageOrganization" /]</p>
      <p class="fontBold">[@spring.message "systemusers"/]</p>
      <ul>
        <li type="circle"><a id="admin.link.viewSysUsers" href="viewSystemUsers.ftl">[@spring.message "viewsystemusers"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineNewUsers" href="defineNewSystemUser.ftl">[@spring.message "definenewsystemuser" /]</a></li>       
        <li type="circle"><a id="admin.link.manageRoles" href="manageRolesAndPermissions.ftl">[@spring.message "managerolesandpermissions"/]</a></li>
      </ul>
      <p><span class="fontBold">[@spring.message "offices"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.viewOffices" href="viewOffices.ftl">[@spring.message "viewOffices" /]</a>&nbsp;|&nbsp;<a Id="admin.link.defineNewOffice" href="defineNewOffice.ftl">[@spring.message "defineNewOffice"/]</a></li>
        <li type="circle"><a id="admin.link.viewOfficeHierarchy" href="viewOfficeHierarchy.ftl">[@spring.message "viewofficehierarchy" /]</a></li>        
      </ul>
      </p>
      <p><span class="fontBold">[@spring.message "organizationpreferences"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.defineNewFees" href="feeaction.do?method=load&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}" >[@spring.message "viewfees"/]</a>&nbsp;|&nbsp;<a eId="admin.link.defineNewFees" href="feeaction.do?method=load&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "definenewfees"/]</a></li>
        <li type="circle"><a id="admin.link.viewFunds" href="viewFunds.ftl" >[@spring.message "viewfunds"/]</a>&nbsp;|&nbsp;<a Id="admin.link.defineNewFund"	href="fundAction.do?method=load&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "definenewfund"/]</a></li>
        <li type="circle"><a id="admin.link.viewChecklists" href="viewChecklists.ftl" >[@spring.message "viewchecklists"/]</a>&nbsp;|&nbsp;<a Id="admin.link.defineNewChecklist" href="defineNewChecklist.ftl">[@spring.message "definenewchecklist"/]</a></li>
        <li type="circle"><a id="admin.link.viewHolidays" href="holidayAction.do?method=get" >[@spring.message "viewholidays"/]</a>&nbsp;|&nbsp;<a Id="admin.link.defineNewHoliday" href="defineNewHolidays.ftl">[@spring.message "definenewholidays"/]</a></li>
        <li type="circle"><a id="admin.link.defineAcceptedPaymentType" href="defineAcceptedPaymentTypes.ftl" >[@spring.message "defineacceptedpayments"/]</a></li>
        <li type="circle"><a id="admin.link.viewOrganizationSettings" href="viewOrganizationSettings.ftl" >[@spring.message "viewOrganizationSettings"/]</a></li>
        <li type="circle"><a id="admin.link.viewPPI" href="ppiAction.do?method=get" >[@spring.message "viewPPIsettings" /]</a>&nbsp;|&nbsp;<a Id="admin.link.configurePPI" href="ppiAction.do?method=configure">[@spring.message "ConfigurePPIsettings"/]</a></li>
      </ul>
      </p>
      <p><span class="fontBold">[@spring.message "datadisplayandrules" /] </span>
      <ul>
        <li type="circle"><a id="admin.link.defineLabels" href="defineLabels.ftl">[@spring.message "defineLabels"/]</a></li>
        <li type="circle"><a id="admin.link.defineLookupOption"	href="defineLookupOptions.ftl">[@spring.message "defineLookupOptions"/]</a></li>
        <li type="circle"><a id="admin.link.defineHiddenMandatoryFields" href="defineMandatoryHiddenFields.ftl">[@spring.message "definemandatory/hiddenfields"/]</a></li>
        <li type="circle"><a id="admin.link.viewAdditionalFields" href="viewAdditionalFields.ftl">[@spring.message "viewAdditionalFields"/]</a>&nbsp;|&nbsp;<a Id="admin.link.defineAdditionalFields"	href="defineAdditionalFields.ftl">[@spring.message "defineAdditionalFields"/]</a></li>
      </ul>
      </p>
      <p class="orangeheading">[@spring.message "manageimports"/]</p>
      <ul>
        <li type="circle"><a id="admin.link.manageImports" href="manageImportAction.do?method=load">[@spring.message "importtransactions"/]</a></li>
      </ul>
      <p class="orangeheading">[@spring.message "systemadministration"/]</p>
      <ul>
        <li type="circle"><a id="admin.link.viewSystemInfo" href="systemInformation.ftl">[@spring.message "viewSystemInformation"/]</a></li>
       <li type="circle"> <a id="admin.link.shutdownMifos" href="shutdownAction.do?method=load">[@spring.message "shutDown"/]</a></li>
      </ul>
    </div>
    <div class="span-10 last">
      <p class="orangeheading">[@spring.message "manageProducts"/]</p>
      <p><span class="fontBold">[@spring.message "productrulesattributes"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.viewProductCategories" href="viewProductCategories.ftl">[@spring.message "viewproductcategories"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineNewProductCategory" href="defineNewCategory.ftl">[@spring.message "definenewcategory"/]</a></li>
        <li type="circle"><a id="admin.link.viewLatenessDormancyDefinition" href="editLatenessDormancy.ftl">[@spring.message "viewlatenessdormancydefinition"/]</a></li>
      </ul>
      </p>
      <p><span class="fontBold">[@spring.message "manageproductmix"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.viewProductsMix" href="viewProductMix.ftl">[@spring.message "viewproductsmix"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineProductsMix" href="productMixAction.do?method=load&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "defineproductsmix"/]</a></li>
      </ul>
      </p>
      <p><span class="fontBold">[@spring.message "manageLoanProducts"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.viewLoanProducts" href="viewLoanProducts.ftl">[@spring.message "viewLoanProducts"/]</a>&nbsp;|&nbsp;<a Id="admin.link.defineNewLoanProduct" href="loanproductaction.do?method=load&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "definenewLoanproduct"/]</a></li>
      </ul>
      </p>
      <p><span class="fontBold">[@spring.message "manageSavingsproducts"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.viewSavingsProducts" href="viewSavingsProducts.ftl">[@spring.message "viewSavingsproducts"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineNewSavingsProduct" href="savingsproductaction.do?method=load&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "definenewSavingsproduct"/]</a></li>
      </ul>
      </p>
      <p class="orangeheading">[@spring.message "manageAccounts"/]</p>
      <p><span class="fontBold">[@spring.message "manageLoanaccounts"/]</span>
      <ul>
        <li type="circle"><a id="admin.link.reverseLoanDisbursal" href="reverseloandisbaction.do?method=search&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "reverseLoanDisbursal"/] </a></li>
        <li type="circle"><a id="admin.link.redoLoanDisbursal" href="loanAccountAction.do?method=redoLoanBegin&recordOfficeId=${model.request.getSession().getAttribute("UserContext").branchId}&recordLoanOfficerId=${model.request.getSession().getAttribute("UserContext").id}">[@spring.message "redoLoanDisbursal"/] </a></li>
      </ul>
      </p>
      <p class="orangeheading">[@spring.message "managereports"/]</p>
      <ul>
        <li type="circle"><a id="admin.link.ViewAdminDocuments" href="birtAdminDocumentUploadAction.do?method=getViewBirtAdminDocumentPage">[@spring.message "viewadmindocuments"/]</a>&nbsp;|&nbsp;<a id="admin.link.uploadAdminDocuments"	href="birtAdminDocumentUploadAction.do?method=getBirtAdminDocumentUploadPage&viewPath=administerreports_path">[@spring.message "uploadadmindocuments"/]</a></li>
        <li type="circle"><a id="admin.link.ViewReportsTemplates" href="birtReportsUploadAction.do?method=getViewReportPage">[@spring.message "viewreportstemplates"/]</a>&nbsp;|&nbsp;<a id="admin.link.uploadReportTemplate" href="birtReportsUploadAction.do?method=getBirtReportsUploadPage&viewPath=administerreports_path">[@spring.message "uploadreporttemplate"/]</a></li>
        <li type="circle"><a id="admin.link.ViewReportsCategory" href="reportsCategoryAction.do?method=viewReportsCategory">[@spring.message "viewreportscategory"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineNewCategory" href="reportsCategoryAction.do?method=loadDefineNewCategoryPage">[@spring.message "definenewreportcategory"/]</a></li>
      </ul>
      <p class="orangeheading">[@spring.message "managesurveys"/]</p>
      <ul>
        <li type="circle"><a id="admin.link.surveys" href="surveysAction.do?method=mainpage">[@spring.message "viewsurveys"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineNewSurvey" href="surveysAction.do?method=create_entry">[@spring.message "definenewsurvey"/]</a></li>
        <li type="circle"><a id="admin.link.viewQuestions" href="questionsAction.do?method=viewQuestions">[@spring.message "viewquestionbank"/]</a>&nbsp;|&nbsp;<a id="admin.link.defineQuestions" href="questionsAction.do?method=defineQuestions">[@spring.message "definequestions"/]</a></li>
      </ul>
      <p class="orangeheading">[@spring.message "managequestions" /]</p>
      <ul>
        <li type="circle"><a id="admin.link.questions" href="viewQuestions.ftl">[@spring.message "viewquestions" /]</a> | <a id="admin.link.defineNewQuestion" href="createQuestion.ftl">[@spring.message "definenewquestion" /]</a></li>
        <li type="circle"><a id="admin.link.questiongroups" href="viewQuestionGroups.ftl">[@spring.message "viewquestiongroups" /]</a> | <a id="admin.link.defineNewQuestionGroup" href="createQuestionGroup.ftl">[@spring.message "definenewquestiongroup" /]</a></li>
      </ul>          
    </div>
  </div>
</div><!--Main Content Ends "-->
[@mifos.footer/]