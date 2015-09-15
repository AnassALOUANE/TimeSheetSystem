<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="active">
            <a href="index.html"><i class="icon-chevron-right"></i> Menu</a>
        </li>
        <li>
             <a href="${pageContext.request.contextPath}/manager/">
                 <i class="icon-chevron-right"></i>
                 <spring:message code="application.timesheet" />
             </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/employee/" >
                <i class="icon-chevron-right"></i>
                <spring:message code="application.my.timesheet" /> 
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/manager/approve">
                <i class="icon-chevron-right"></i>
                <spring:message code="application.timesheet.approve" /> 
            </a>
        </li>
        
    </ul>