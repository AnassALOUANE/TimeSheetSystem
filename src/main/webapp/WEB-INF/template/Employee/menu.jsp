<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="active">
            <a href="index.html"><i class="icon-chevron-right"></i> Menu</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/employee/">
                <i class="icon-chevron-right"></i> 
                <spring:message code="application.timesheet" />
            </a>
        </li>
        <security:authorize ifAllGranted="ROLE_MANAGER">
            <li >
                <a href="${pageContext.request.contextPath}/manager/">
                     <i class="icon-chevron-right"></i> 
                    <spring:message code="application.timesheet.manager" />
                </a>
            </li>
        </security:authorize>
        <!--end-->
        <!--IF USER CONNECTED IS THE  ACCOUNTING --> 
        <security:authorize ifAllGranted="ROLE_COMPTABLE">
            <li>
                <a href="${pageContext.request.contextPath}/comptable/">
                     <i class="icon-chevron-right"></i> 
                    <spring:message code="application.timesheet.payment" />
                </a>
            </li>
        </security:authorize>
        
        
    </ul>