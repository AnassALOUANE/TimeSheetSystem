<%-- 
    Document   : employee_index
    Created on : Jun 3, 2015, 12:45:48 AM
    Author     : karim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
 




   

<tiles:insertDefinition name="EmployeeTemplate">
    <tiles:putAttribute name="body"> 
        
        
                    <div class="row-fluid">
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">  <spring:message code="application.timesheet.update"/> </div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
        
                                    <form:form  modelAttribute="timesheet" method="post" action="${pageContext.request.contextPath}/timesheet/update/${idT}" class="form-horizontal">

                                      <fieldset>
                                        <legend> 
                                            <span class="badge badge-info">
                                               <spring:message code="application.timesheet.periodEndingDate"/> :  <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${periodEndingDate}" /></legend>
                                            </span>
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursMon"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursMon"  />
                                            <p class="help-block"> <form:errors path="hoursMon" cssClass="label label-important" /> </p>
                                          </div>
                                        </div>
                                          
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursTue"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursTue" />
                                            <p class="help-block"> <form:errors path="hoursTue" cssClass="label label-important" /> </p>
                                          </div>
                                        </div>
                                          
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursWed"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursWed" />
                                            <p class="help-block"> <form:errors path="hoursWed" cssClass="label label-important" /> </p>
                                          </div>
                                        </div>
                                          
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursThu"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursThu" />
                                            <p class="help-block"> <form:errors path="hoursThu" cssClass="label label-important" /> </p>
                                          </div>
                                        </div> 
                                         
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursFri"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursFri" />
                                            <p class="help-block"> <form:errors path="hoursFri" cssClass="label label-important" /> </p>
                                          </div>
                                        </div>
                                         
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursSat"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursSat" />
                                            <p class="help-block"> <form:errors path="hoursSat" cssClass="label label-important" /> </p>
                                          </div>
                                        </div> 
                                          
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursSun"/> </label>
                                          <div class="controls">
                                               <form:input class="span6" path="hoursSun" />
                                            <p class="help-block"> <form:errors path="hoursSun" cssClass="label label-important" /> </p>
                                          </div>
                                        </div> 
                                        
                                        <div class="control-group">
                                          <label class="control-label" for="typeahead"> <spring:message code="application.timesheet.hoursTotal"/> </label>
                                          <div class="controls">
                                                  <!--<input type="text" id="total_price" value="0" />-->
                                                  <!--<label id="total_price" class="control-label" for="typeahead" > 0</label>-->
                                                  <span id="total_price" class="badge badge-warning"> ${timesheet.totalHours} </span>
                                                  <p class="help-block"> 
                                                      <c:if test="${not empty errorTotalHours}">
                                                        <span class="label label-important"> ${errorTotalHours} </span>
                                                    </c:if>
                                                  </p>
                                          </div>
                                        </div>
                                         
                                        
                                        <div class="control-group">
                                          <label class="control-label" for="select01"><spring:message code="application.departement"/></label>
                                          <div class="controls">                                              
                                       
                                              
                                                    <select class="custom-select" name="id_dept">
				                    		<c:forEach var="crt" items="${departments}">
												<option value="${crt.id_dept}"> <c:out value="${crt.name}" /> </option>
											</c:forEach>																
							</select>
                                          </div>
                                        </div>
                                      
                                        <div class="form-actions">
                                          <button type="submit" class="btn btn-primary"><spring:message code="application.crud.update"/> </button>
                                          <button type="reset" class="btn"><spring:message code="application.crud.reset"/></button>
                                        </div>
                                      </fieldset>
                                    </form:form>
                                     <button id="btn1"><spring:message code="application.timesheet.hoursTotal"/></button>

                                </div>
                            </div>
                        </div>
                    </div>




</tiles:putAttribute>
</tiles:insertDefinition>

