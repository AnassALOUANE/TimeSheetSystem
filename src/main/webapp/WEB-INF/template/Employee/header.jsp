<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#"><spring:message code="application.title" /></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> 
                                    <span class="badge badge-important"> <c:out value='${sessionScope["user_logged_in"].profil.titre}' /> </span>
                                    <i class="icon-user"></i> 
                                    <c:out value='${sessionScope["user_logged_in"].name}' /> </h3> <i class="caret"></i>
                                </a>
                                <ul class="dropdown-menu">
                                    
                                    <li class="divider"></li>
                                    <li>
                                         <a class="" href="<c:url value="/logout" />" > 
                                            <i class="icon-off"></i> <span><span><spring:message code="application.header.logout" /></span>
                                        </a>
                                    </li>
                                    
                                </ul>
                                        
                            </li>
                        </ul>
                                        
                        <ul class="nav pull-right">
                                    <li>
                                           <c:if test="${pageContext.response.locale =='en'}">
                                                  <a href="?lang=fr"> 
                                                      <img src="<c:url value="/images/languages/fr.gif"/>"   alt="Fr"  />
                                                  </a>
                                           </c:if>
                                            <c:if test="${pageContext.response.locale =='fr'}">
                                                  <a href="?lang=en"> 
                                                      <img src="<c:url value="/images/languages/en.gif"/>"   alt="En"  />
                                                  </a>  
                                           </c:if>
						     
                                    </li>
                                    
                        </ul>
                                        
                                        
                        <ul class="nav">
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/employee/"><spring:message code="application.timesheet" /></a>
                            </li>
                            
                           <!--IF USER CONNECTED IS THE  MANAGER--> 
                          <security:authorize ifAllGranted="ROLE_MANAGER">
                                    <li class="dropdown">
                                        <a href="${pageContext.request.contextPath}/manager/"><spring:message code="application.timesheet.manager" /></a>
                                    </li>
                           </security:authorize>
                            <!--end-->
                            <!--IF USER CONNECTED IS THE  ACCOUNTING --> 
                          <security:authorize ifAllGranted="ROLE_COMPTABLE">
                                    <li class="dropdown">
                                        <a href="${pageContext.request.contextPath}/comptable/"><spring:message code="application.timesheet.payment" /></a>
                                    </li>
                           </security:authorize>
                            <!--end-->
                            
<!--                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Content </a>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Users </a>
                            </li>-->
                            
                            
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
                            
                            
                            