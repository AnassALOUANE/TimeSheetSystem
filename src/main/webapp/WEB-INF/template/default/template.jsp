<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html class="no-js">
    
    <head>
        <title><spring:message code="application.title" /></title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" type="text/css" media="screen" title="default" />
        <link rel="stylesheet" href="<c:url value="/bootstrap/css/bootstrap-responsive.min.css"/>" type="text/css" media="screen" title="default" />

        <link rel="stylesheet" href="<c:url value="/vendors/easypiechart/jquery.easy-pie-chart.css"/>" type="text/css" media="screen" title="default" />

        <link rel="stylesheet" href="<c:url value="/assets/styles.css"/>" type="text/css" media="screen" title="default" />
        
        <link rel="stylesheet" href="<c:url value="/css/button_span.css"/>" type="text/css" media="screen" title="default" />


        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="<c:url value="/vendors/modernizr-2.6.2-respond-1.1.0.min.js"/>" type="text/javascript"></script>

    </head>
    
    <body>
        <div class="navbar navbar-fixed-top">
           <tiles:insertAttribute name="header" />
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <tiles:insertAttribute name="menu" />
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">

                        <c:if test="${not empty succesMessage}">
                            <div class="alert alert-info">
                                           <button class="close" data-dismiss="alert">×</button>
                                            <strong>Success!</strong>
                                            ${succesMessage}.  
                            </div>
                        </c:if>
                        
                        <c:if test="${not empty msgError}">
                            <div class="alert alert-error">
                                         <button class="close" data-dismiss="alert">×</button>
                                            <strong>Error!</strong>
                                            ${msgError}
                            </div>
                        </c:if> 
                        
                       

                       
                        
                        	<%--<tiles:insertAttribute name="headingBar" />--%>
                        
                                <tiles:insertAttribute name="body" />
                    	</div>
                    
                </div>
            </div>
            <hr>
            <footer>
                  <tiles:insertAttribute name="footer" />
            </footer>
        </div>
        <!--/.fluid-container-->
        <script src="<c:url value="/vendors/jquery-1.9.1.min.js"/>" type="text/javascript"></script>

        <script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>" type="text/javascript"></script>

        <script src="<c:url value="/vendors/easypiechart/jquery.easy-pie-chart.js"/>" type="text/javascript"></script>

        <script src="<c:url value="/assets/scripts.js"/>" type="text/javascript"></script>

        <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        </script>
        
         <script>
        $(document).ready ( function () {
            $("#btn1").click ( function () {
              var resultVal = 0.0;
               $(".span6").each ( function() {
                   resultVal += parseFloat ( $(this).val().replace(/\s/g,'').replace(',','.'));
//                   document.getElementById('total_price').value= resultVal;
                   document.getElementById('total_price').innerHTML = resultVal;
                });
//                alert ( resultVal );  
              
            });
        });
    </script>
    </body>

</html>