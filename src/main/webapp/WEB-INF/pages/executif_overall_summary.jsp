<%-- 
    Document   : employee_index
    Created on : Jun 3, 2015, 12:45:48 AM
    Author     : karim
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="<c:url value="/js/chart.js"/>" type="text/javascript"></script>
		<script type="text/javascript">

$(function () {
    $('#pie_chart').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '<spring:message code="application.executif.overall.summary" /> '
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.y:.1f}</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Overall summary',
            data: [
                    <c:forEach items="${list_overall_summary}" var="r" varStatus="loop">
                   {
                	   name: '<c:out value="${r.name}" /> ', 
                	   y:  ${r.totalHours}, 
                   }<c:if test="${!loop.last}">,</c:if>
                   
                   </c:forEach>
            ],
             showInLegend: {
                   enabled: true,
               }
        }],
        credits: {
            enabled: false
        }
    });
});

$(function () {
    $('#bar_chart').highcharts({
        chart: {
            type: 'column',
            margin: 75,
            options3d: {
                enabled: true,
                alpha: 10,
                beta: 25,
                depth: 70
            }
        },
        title: {
            text: '<spring:message code="application.executif.overall.summary" /> '
        },
        subtitle: {
            text: ''
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        xAxis: {
            categories:
            [
				'<spring:message code="application.executif.average.hours"/>',
				'<spring:message code="application.executif.total"/> '
				
             ]
        },
        yAxis: {
            title: {
                text: null
            }
        },
        series: [{
            name: '<spring:message code="application.executif.percentage"/>',
            data: [
                   ${average} , 
                   ${total}
                 ]
        }],
        credits: {
            enabled: false
        }
    });
});


</script>
                
<tiles:insertDefinition name="ExecutifTemplate">
    <tiles:putAttribute name="body"> 
        
        
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"> <spring:message code="application.executif.overall.summary" />  </div>
                                <div class="pull-right">
                                    <span class="badge blue">Total : ${total}  </span>
                                </div>
                                <div class="pull-right">
                                    <span class="badge brown">Averege : ${average}  </span>
                                </div>
                            </div>
                            <div class="block-content collapse in" >
                                <div class="span12">
                                    
                                    <c:choose>
                                         <c:when test="${not empty list_overall_summary}">
                                 
                                                 <form method="post"  action="${pageContext.request.contextPath}/comptable/payment">
  						    <table class="table table-bordered tablesorter">
                                                                            
						              <thead>
						                <tr>
                                                                  <th> <center> <spring:message code="application.employee"/> </center> </th>
                                                                  <th><center><spring:message code="application.timesheet.hoursWeek"/></center></th>
                                                                  <th><center><spring:message code="application.executif.status"/></center></th>                                                    
						                </tr>
						              </thead>
						               <tbody>
                                                                <c:forEach items="${list_overall_summary}" var="r" >  
                                                                    <tr>
                                                                      
                                                                      <td>${r.name}</td>
                                                                      <td>
                                                                          
                                                                              <span class="badge green">${r.totalHours}</span>
                                                                              
                                                                      </td>
                                                                        <td>
                                                                                <span class="badge red" style="margin-left:200px;" >${r.paid}</span> paid <br/>
                                                                                <span class="badge red" style="margin-left:200px;">${r.unpaid}</span> unpaid <br/>
                                                                                <span class="badge red" style="margin-left:200px;">${r.approved}</span> approved<br/>
                                                                                <span class="badge red" style="margin-left:200px;">${r.disapproved}</span> disapproved<br/> 
                                                                                
                                                                        </td>
                                                                    </tr>
						                 </c:forEach>
                                                                    
                                                                    <tr style="font-weight: bold; font-size:1.4em;">
                                                                        <td colspan="2" style="text-align: right;" > <spring:message code="application.executif.average.hours"/> </td>
                                                                        <td> ${average}  </td>
                                                                        
                                                                    </tr>
                                                                     <tr style="font-weight: bold; font-size:1.4em;">
                                                                         <td colspan="2" style="text-align: right;"> <spring:message code="application.executif.total"/> </td>
                                                                         <td> ${total}  </td>
                                                                    </tr>
                                                                    
						              </tbody>
						    </table>
                                                 </form>  
                                        </c:when>
                                         <c:otherwise>
                                             <div class="alert alert-error alert-block">
                                                <a class="close" href="#" data-dismiss="alert">×</a>
                                                <h4 class="alert-heading">Thinks !</h4>
                                                  Any Overall report at the time.
                                            </div>
                                         </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                                
                      <div class="row-fluid">
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left"> <spring:message code="application.executif.overall.summary" />  </div>
                                    <div class="pull-right"><span class="badge badge-info">${list_overall_summary.size()}</span>

                                    </div>
                                </div>
                                <div class="block-content collapse in" id="pie_chart">
                                    
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                                    
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left"> <spring:message code="application.executif.overall.summary" />  </div>

                                        <div class="pull-right">
                                            <span class="badge blue">Total : ${total}  </span>
                                        </div>
                                        <div class="pull-right">
                                            <span class="badge brown">Averege : ${average}  </span>
                                        </div>
                                        
                                 </div>
                                <div class="block-content collapse in" id="bar_chart">
                                    
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                         
                            <!-- /block -->
                        </div>
                    </div>
                          
                          



</tiles:putAttribute>
</tiles:insertDefinition>

<!-- HIGH CHART START  -->
<script src="<c:url value="/js/highcharts.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/exporting.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/highcharts-3d.js"/>" type="text/javascript"></script>
<!-- HIGH CHART END -->
