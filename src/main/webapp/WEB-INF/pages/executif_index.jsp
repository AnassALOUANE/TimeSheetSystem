<%-- 
    Document   : employee_index
    Created on : Jun 3, 2015, 12:45:48 AM
    Author     : karim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 
<tiles:insertDefinition name="ExecutifTemplate">
    <tiles:putAttribute name="body"> 
        
        
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"><spring:message code="application.executif.staff.hours"/> </div>
                            </div>
                            <div class="block-content collapse in" >
                                <div class="span12">
                                    
                                    <c:choose>
                                         <c:when test="${not empty timesheets}">
                                 
                                                 <form method="post"  action="${pageContext.request.contextPath}/comptable/payment">
  						    <table class="table table-bordered tablesorter">
                                                                            
						              <thead>
						                <tr>
                                                                  <th> <spring:message code="application.employee"/></th>
                                                                  <th> Type </th>   
                                                                  <th><center><spring:message code="application.timesheet.hoursWeek"/></center></th>
						                </tr>
						              </thead>
						               <tbody>
                                                                <c:forEach items="${timesheets}" var="t" >  
                                                                    <tr>
                                                                      
                                                                      <td>${t.employee.name}</td>
                                                                      <td>
                                                                          <c:if test="${t.employee.profil.id_profil == 1}" >
                                                                              <span class="badge brown">${t.employee.profil.titre}</span>
                                                                              
                                                                          </c:if>
                                                                          <c:if test="${t.employee.profil.id_profil == 2}" >
                                                                              <span class="badge blue">${t.employee.profil.titre}</span>
                                                                              
                                                                          </c:if>
                                                                          <c:if test="${t.employee.profil.id_profil == 3}" >
                                                                              <span class="badge green">${t.employee.profil.titre}</span>
                                                                              
                                                                          </c:if>
                                                                      </td>
                                                                      <td>
                                                                          <center>
                                                                            <span class="badge red">${t.totalHours}</span>
                                                                          </center>
                                                                      </td>
                                                                    </tr>
						                 </c:forEach>
                                                                    <tr style="background: #555; color:#fff; font-weight: bold;">
                                                                        <td colspan="2" style="text-align: right;"> <spring:message code="application.executif.average.hours"/> </td>
                                                                        <td> ${average} </td>
                                                                    </tr>
                                                                     <tr style="background: #555; color: #fff; font-weight: bold;">
                                                                         <td colspan="2" style="text-align: right;"> <spring:message code="application.executif.total"/> </td>
                                                                         <td>  ${total} </td>
                                                                    </tr>
						              </tbody>
						    </table>
                                                 </form>  
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
