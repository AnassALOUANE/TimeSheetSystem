<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
        <li class="active">
            <a href="index.html"><i class="icon-chevron-right"></i> Menu</a>
        </li>
        <li>
                 <a href="${pageContext.request.contextPath}/executif/">
                     <i class="icon-chevron-right"></i> 
                     <spring:message code="application.executif.staff.hours" />
                 </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/executif/overallSummary/" >
                <i class="icon-chevron-right"></i> 
                <spring:message code="application.executif.overall.summary" /> 
            </a>
        </li>
    </ul>