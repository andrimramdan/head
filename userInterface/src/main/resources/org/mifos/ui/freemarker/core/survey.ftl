[#ftl]
[#--
* Copyright (c) 2005-2010 Grameen Foundation USA
*  All rights reserved.
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
*  implied. See the License for the specific language governing
*  permissions and limitations under the License.
*
*  See also http://www.apache.org/licenses/LICENSE-2.0.html for an
*  explanation of the license and how it is applied.
--]
[#import "spring.ftl" as spring]
[#import "blueprintmacros.ftl" as mifos]
[#import "macros.ftl" as mifosMacros]
[@mifos.header "title" /]
[@mifos.topNavigationNoSecurity currentTab="Admin" /]
<STYLE TYPE="text/css"><!-- @import url(pages/questionnaire/css/datepicker.css); --></STYLE>
<STYLE TYPE="text/css"><!-- @import url(pages/questionnaire/css/questionnaire.css); --></STYLE>
<script type="text/javascript" src="pages/questionnaire/js/jquery.datePicker.min-2.1.2.js"></script>
<script type="text/javascript" src="pages/questionnaire/js/date.js"></script>
<!--[if IE]><script type="text/javascript" src="scripts/jquery.bgiframe.js"></script><![endif]-->
<script src="pages/questionnaire/js/survey.js" type="text/javascript"></script>
<div class="sidebar ht950">
    [#include "adminLeftPane.ftl" /]
</div>
<div class="content leftMargin180">
    <span id="page.id" title="selectSurvey"></span>
    [#assign breadcrumb = Session.urlMap/]
    [@mifos.crumbpairs breadcrumb "false"/]
    <div class="marginLeft30">
        <div class="orangeheading marginTop15">
            ${Session.surveyFor} - [@spring.message "questionnaire.survey.enterdata"/]
        </div>
        <div class="allErrorsDiv">
            [@mifosMacros.showAllErrors "questionGroupDetails.*"/]
        </div>
        <div class="marginTop15">
            [@spring.message "questionnaire.survey.instructions"/]
        </div>
        <form name="survey" action="selectSurvey.ftl?execution=${flowExecutionKey}" method="POST">
            [#list questionGroupDetails.details[selectedSurveyIndex].sectionDetails as sectionDetail]
            <div class="marginTop15">
                <b>${sectionDetail.name}</b>
            </div>
            <fieldset>
                <ol>
                    [#list sectionDetail.questions as question]
                    <li class="marginTop15">
                        <label for="details[${selectedSurveyIndex}].sectionDetails[${sectionDetail_index}].questions[${question_index}].value">
                            [#if question.mandatory]<span class="red">*</span>[/#if]
                            ${question.title}
                            [#if question.questionType=="DATE"](DD/MM/YYYY)[/#if]:
                        </label>
                        [#switch question.questionType]
                          [#case "FREETEXT"]
                            [@spring.formTextarea "questionGroupDetails.details[${selectedSurveyIndex}].sectionDetails[${sectionDetail_index}].questions[${question_index}].value", 'rows="4" cols="50"' /]
                          [#break]
                          [#case "NUMERIC"]
                            [@spring.formInput "questionGroupDetails.details[${selectedSurveyIndex}].sectionDetails[${sectionDetail_index}].questions[${question_index}].value", 'maxlength="30"' /]
                          [#break]
                          [#case "DATE"]
                            [@spring.formInput "questionGroupDetails.details[${selectedSurveyIndex}].sectionDetails[${sectionDetail_index}].questions[${question_index}].value", 'maxlength="10" class="date-pick"' /]
                          [#break]
                          [#case "MULTI_SELECT"]
                          <fieldset style="width:70%">
                            <ol class="noPadding">
                              <li class="noPadding">
                                [@mifosMacros.formCheckboxes "questionGroupDetails.details[${selectedSurveyIndex}].sectionDetails[${sectionDetail_index}].questions[${question_index}].value", question.answerChoices ,'</li><li class="noPadding">', ''/]
                              </li>
                            </ol>
                          </fieldset>
                          [#break]
                          [#case "SINGLE_SELECT"]
                          <fieldset style="width:70%">
                            <ol  class="noPadding">
                              <li class="noPadding">
                                [@mifosMacros.formRadioButtons "questionGroupDetails.details[${selectedSurveyIndex}].sectionDetails[${sectionDetail_index}].questions[${question_index}].value", question.answerChoices ,'</li><li class="noPadding">', ''/]
                              </li>
                            </ol>
                          </fieldset>
                          [#break]
                          [#default]
                             Unknown question type ${question.questionType}
                        [/#switch]
                    </li>
                    [/#list]
                </ol>
            </fieldset>
            [/#list]
            <fieldset>
                <ol>
                    <li class="buttonWidth">
                        <input type="submit" id="_eventId_saveSurvey" name="_eventId_saveSurvey"
                               value="[@spring.message "questionnaire.submit"/]" class="buttn"/>
                        &nbsp;
                        <input type="submit" id="_eventId_cancel" name="_eventId_cancel"
                               value="[@spring.message "questionnaire.canecl"/]" class="cancelbuttn"/>
                    </li>
                </ol>
            </fieldset>
        </form>
    </div>
</div>
[@mifos.footer/]