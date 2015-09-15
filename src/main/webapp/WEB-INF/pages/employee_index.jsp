<%-- 
    Document   : employee_index
    Created on : Jun 3, 2015, 12:45:48 AM
    Author     : karim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 
<tiles:insertDefinition name="EmployeeTemplate">
    <tiles:putAttribute name="body"> 
        
        
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"><spring:message code="application.timesheet.list"/> </div>
                            </div>
                            <div class="block-content collapse in" >
                                <div class="span12">
                                    <div class="table-toolbar" style="margin:12px;">
                                        <div class="btn-group">
                                            <a href="${pageContext.request.contextPath}/timesheet/add"><button class="btn btn-success"> <i class="icon-plus icon-white"></i>  <spring:message code="application.timesheet.new"/>  </button></a>
                                        </div>
                                     </div>
                                    <c:choose>
                                         <c:when test="${not empty timesheets}">
                                       
  						    <table class="table table-bordered tablesorter">
                                                                            
						              <thead>
						                <tr>
                                                                  <th> <spring:message code="application.timesheet.periodEndingDate"/></th>
                                                                  <th> <spring:message code="application.timesheet.status"/></th>
                                                                  <th> <spring:message code="application.timesheet.id"/></th>
						                  <th><spring:message code="application.timesheet.hours"/></th>
                                                                  <th> <spring:message code="application.departement"/></th>
                                                                  
                                                                  <th> <label class="pick"></label></th>
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
                                                                       <td>${t.id_timesheet}</td>
                                                                      <td><span class="badge badge-warning">${t.totalHours}</span></td>
                                                                      <td>${t.department.name}</td>
                                                                      <td>
                                                                            
                                                                          <button class="btn btn-default" 
                                                                                onclick="location.href = '${pageContext.request.contextPath}/print/EmpTimesheetPDF/${t.id_timesheet}';">
                                                                                <i class="icon-print "></i>
                                                                          </button>
                                                                            
                                                                           <button class="btn btn-success" 
                                                                                onclick="location.href = '${pageContext.request.contextPath}/timesheet/update/${t.id_timesheet}';">
                                                                                <i class="icon-pencil icon-white"></i>
                                                                            </button>
                                                                        
                                                                          
                                                                          <a href="#myAlert" data-toggle="modal"> <button class="btn btn-danger"> <i class="icon-trash icon-white"></i> </button></a>
                                                                          
                                                                              <div id="myAlert" class="modal hide">
                                                                                  <div class="modal-header">
                                                                                      <button data-dismiss="modal" class="close" type="button">&times;</button>
                                                                                      <h4 style='color:#303B52; font-family: "Times New Roman", Georgia, Serif;'>Confirmation</h3>
                                                                                  </div>
                                                                                  <div class="modal-body">
                                                                                      <p><spring:message code="application.crud.delete"/></p>
                                                                                  </div>
                                                                                  <div class="modal-footer">
                                                                                      <a class="btn btn-primary" href="${pageContext.request.contextPath}/timesheet/delete/${t.id_timesheet}"><spring:message code="application.crud.yes"/></a>
                                                                                      <a data-dismiss="modal" class="btn" href="#"><spring:message code="application.crud.no"/></a>
                                                                                  </div>
                                                                              </div>

                                                                        </td>
                                                                    </tr>
						                 </c:forEach>
						              </tbody>
						    </table>
                                        </c:when>
                                         <c:otherwise>
                                             <div class="alert alert-error alert-block">
                                                <a class="close" href="#" data-dismiss="alert">×</a>
                                                <h4 class="alert-heading">Thinks !</h4>
                                                  Any timesheet exist for this week .
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
