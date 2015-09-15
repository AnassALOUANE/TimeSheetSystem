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
                                    
                                  <div class="table-toolbar" style="margin:12px; padding-bottom: 34px;">
                                     
                                      <div class="btn-group pull-right">
                                         <button onclick="location.href = '${pageContext.request.contextPath}/print/EmpTimesheetPDF/${timesheet.id_timesheet}';" data-toggle="dropdown" class="btn "><spring:message code="application.timesheet.savePdf"/>  </button>
                                      </div>
                                   </div>
                                        <c:choose>
                                            <c:when test="${not empty timesheet}">
                                                
  						    <table class="table table-bordered">
                                                                            
						              <thead>
						                <tr>
                                                                  <th> <spring:message code="application.user.name"/></th>
                                                                  <th> <spring:message code="application.timesheet.hoursMon"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursTue"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursWed"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursThu"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursFri"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursSat"/></th>
                                                                  <th><spring:message code="application.timesheet.hoursSun"/></th>
                                                                  
						                  <th><spring:message code="application.timesheet.hours"/></th>
						                </tr>
						              </thead>
						              <tbody>
                                                                    <tr>
                                                                      <td>
                                                                          <span class="badge badge-info">${timesheet.employee.name}</span>
                                                                      </td>
                                                                      <td>
                                                                             ${timesheet.hoursMon}
                                                                      </td>
                                                                      <td>${timesheet.hoursTue}</td>
                                                                      <td>${timesheet.hoursWed}</td>
                                                                      <td>${timesheet.hoursThu}</td>
                                                                      <td>${timesheet.hoursFri}</td>
                                                                      <td>${timesheet.hoursSat}</td>
                                                                      <td>${timesheet.hoursSun}</td>
                                                                      <td><span class="badge badge-warning">${timesheet.totalHours}</span></td>
                                                                    </tr>
						              </tbody>
						    </table>
                                        </c:when>
                                         <c:otherwise>
                                             <div class="alert alert-error alert-block">
                                                <a class="close" href="#" data-dismiss="alert">×</a>
                                                <h4 class="alert-heading">Thinks!</h4>
                                                 timesheet not found .
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
