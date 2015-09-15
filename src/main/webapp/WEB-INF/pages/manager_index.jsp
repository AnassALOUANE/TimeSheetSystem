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
                                <div class="muted pull-left"> <spring:message code="application.timesheet.list"/> </div>
                            </div>
                            <div class="block-content collapse in" >
                                <div class="span12">
                                    
                                  <div class="table-toolbar" style="margin:12px;  padding-bottom: 34px;">
                                     
                                      <div class="btn-group pull-right">
                                         <button onclick="location.href = '${pageContext.request.contextPath}/print/MangerAllTimesheetPDF/<c:out value='${sessionScope["user_logged_in"].id_u}' />';" class="btn "><spring:message code="application.timesheet.savePdf"/>  </button>
                                      </div>
                                   </div>
                                        <c:choose>
                                            <c:when test="${not empty timesheets}">
                                                
  						    <table class="table table-bordered">
                                                                            
						              <thead>
						                <tr>
                                                                  <th> <spring:message code="application.timesheet.periodEndingDate"/></th>
                                                                  <th> <spring:message code="application.timesheet.id"/></th>
                                                                  <th><spring:message code="application.timesheet.status"/></th>
						                  <th> <spring:message code="application.user.name"/></th>
						                  <th><spring:message code="application.user.email"/></th>
						                  <th><spring:message code="application.timesheet.hours"/></th>
                                                                  <th> <spring:message code="application.departement"/></th>
						                </tr>
						              </thead>
						              <tbody>
                                                                <c:forEach items="${timesheets}" var="t" >  
                                                                    <tr>
                                                                      <td>
                                                                            <span class="badge badge-info">
                                                                              <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${t.periodEndingDate}" />
                                                                            </span>
                                                                      </td>
                                                                      <td>${t.id_timesheet}</td>
                                                                      <td>
                                                                          
                                                                          <c:if test="${t.statusCode == 'N'}" >
                                                                              <span class="badge badge-warning">Pending</span>
                                                                              
                                                                          </c:if>
                                                                          <c:if test="${t.statusCode == 'A'}" >
                                                                              <span class="badge badge-success">Approved</span>
                                                                              
                                                                          </c:if>
                                                                          <c:if test="${t.statusCode == 'D'}" >
                                                                              <span class="badge badge-important">Disapproved</span>
                                                                              
                                                                          </c:if>
                                                                          <c:if test="${t.statusCode == 'P'}" >
                                                                              <span class="badge badge-info">Approved</span>
                                                                              
                                                                          </c:if>
                                                                      </td>
                                                                      <td>
                                                                           <a href="${pageContext.request.contextPath}/timesheet/detail/${t.id_timesheet}">  
                                                                              ${t.employee.name}     
                                                                           </a>
                                                                      </td>
                                                                      <td>${t.employee.email}</td>
                                                                      <td><span class="badge badge-warning">${t.totalHours}</span></td>
                                                                      <td>${t.department.name}</td>
                                                                    </tr>
						                 </c:forEach>
						              </tbody>
						    </table>
                                        </c:when>
                                         <c:otherwise>
                                             <div class="alert alert-error alert-block">
                                                <a class="close" href="#" data-dismiss="alert">×</a>
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
        
</tiles:putAttribute>
</tiles:insertDefinition>
