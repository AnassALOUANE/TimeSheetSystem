<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
       
         <li class="active">
            <a href="index.html"><i class="icon-chevron-right"></i> Menu</a>
        </li>
        
        <li>
                <a href="${pageContext.request.contextPath}/comptable/">
                    <i class="icon-chevron-right"></i> 
                    <spring:message code="application.payment" />
                </a>
        </li>
        <li>                
                <a href="${pageContext.request.contextPath}/comptable/paid/" >
                    <i class="icon-chevron-right"></i> 
                    <spring:message code="application.paid" /> 
                </a>
        </li>
        <li>
               <a href="${pageContext.request.contextPath}/employee/" >
                    <i class="icon-chevron-right"></i> 
                   <spring:message code="application.my.timesheet" /> 
              </a>
        </li>
       
    </ul>