<%-- 
    Document   : employee_index
    Created on : Jun 3, 2015, 12:45:48 AM
    Author     : karim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 
<tiles:insertDefinition name="ManagerTemplate">
    <tiles:putAttribute name="body"> 
        
        
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"> <spring:message code="application.timesheet.approve"/> </div>
                            </div>
                            <div class="block-content collapse in" >
                                <div class="span12">
                                  <c:choose>
                                          <c:when test="${not empty timesheets}">  
                                              <form method="post"  action="${pageContext.request.contextPath}/manager/approve">
  						    <table class="table table-bordered">
                                                                            
						              <thead>
						                <tr>
						                  <th> <spring:message code="application.user.name"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursWeek"/></th>
                                                                  <th> <spring:message code="application.departement"/></th>
                                                                  <th><spring:message code="application.timesheet.approve"/></th>
                                                                  
						                </tr>
						              </thead>
						              <tbody>
                                                                <c:forEach items="${timesheets}" var="t" >  
                                                                    <tr>
                                                                      
                                                                      <td>${t.employee.name}</td>
                                                                      <td><span class="badge badge-warning">${t.totalHours}</span></td>
                                                                      <td>${t.department.name}</td>
                                                                      <td>
                                                                           <div align="center">
                                                                                 <input type="checkbox" name="checkBox_approve_timesshet" value="${t.id_timesheet}">
<!--                                                                               <span style="margin:3px; vertical-align: middle;"> <input type="radio" name="ap" value="Yes ${t.id_timesheet}" /> Yes </span>
                                                                               <sapn style="margin:3px; vertical-align: middle;">  <input type="radio" name="ap" value="No ${t.id_timesheet}"/> No  </sapn>-->
                                                                           </div> 
                                                                      </td>
                                                                    </tr>
						                 </c:forEach>
						              </tbody>
						    </table>
                                                    <div class="form-actions">
                                                      <button type="submit" class="btn btn-primary"><spring:message code="application.timesheet.approve.valide"/> </button>
                                                      <button type="reset" class="btn"><spring:message code="application.crud.reset"/></button>
                                                     </div>
                                                </form>                  
                                        </c:when>
                                         <c:otherwise>
                                             <div class="alert alert-warning alert-block">
                                                <a class="close" href="#" data-dismiss="alert">�</a>
                                                <h4 class="alert-heading">Thinks!</h4>
                                                 timesheet not exist for this week .
                                            </div>
                                         </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                            
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"> <spring:message code="application.timesheet.approve.ok"/> </div>
                            </div>
                            <div class="block-content collapse in" >
                                <div class="span12">
                                  <c:choose>
                                          <c:when test="${not empty timesheets_aprroved}">  
                                              <form method="post"  action="${pageContext.request.contextPath}/manager/disapprove">
  						    
                                                       <table class="table table-bordered">
                                                                            
						              <thead>
						                <tr>
						                  <th> <spring:message code="application.user.name"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursWeek"/></th>
                                                                  <th> <spring:message code="application.departement"/></th>
                                                                  <th><spring:message code="application.timesheet.disapprove"/></th>
                                                                  
						                </tr>
						              </thead>
						              <tbody>
                                                                <c:forEach items="${timesheets_aprroved}" var="t" >  
                                                                    <tr>
                                                                      
                                                                      <td>${t.employee.name}</td>
                                                                      <td><span class="badge badge-warning">${t.totalHours}</span></td>
                                                                      <td>${t.department.name}</td>
                                                                      <td>
                                                                           <div align="center">
                                                                                 <input type="checkbox" name="checkBox_approve_timesshet" value="${t.id_timesheet}">
<!--                                                                               <span style="margin:3px; vertical-align: middle;"> <input type="radio" name="ap" value="Yes ${t.id_timesheet}" /> Yes </span>
                                                                               <sapn style="margin:3px; vertical-align: middle;">  <input type="radio" name="ap" value="No ${t.id_timesheet}"/> No  </sapn>-->
                                                                           </div> 
                                                                      </td>
                                                                    </tr>
						                 </c:forEach>
						              </tbody>
						    </table>
                                                    <div class="form-actions">
                                                      <button type="submit" class="btn btn-primary"><spring:message code="application.timesheet.disapprove"/> </button>
                                                      <button type="reset" class="btn"><spring:message code="application.crud.reset"/></button>
                                                     </div>
                                                </form>  
                                                </form>                  
                                        </c:when>
                                         <c:otherwise>
                                             <div class="alert alert-warning alert-block">
                                                <a class="close" href="#" data-dismiss="alert">�</a>
                                                <h4 class="alert-heading">Thinks!</h4>
                                                 No timesheet approved yet for this week .
                                            </div>
                                         </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
 



</tiles:putAttribute>
</tiles:insertDefinition>
