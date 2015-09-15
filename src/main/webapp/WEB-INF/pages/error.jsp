
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="shortcut icon" href="images/favicon/favicon.ico">
		<title><spring:message code="application.title"/></title>
		
		  <style>
  body {
    background-color: #EFEFEF;
    color: #2E2F30;
    text-align: center;
    font-family: arial, sans-serif;
    margin: 0;
  }

  div.dialog {
    width: 95%;
    max-width: 33em;
    margin: 4em auto 0;
  }

  div.dialog > div {
    border: 1px solid #CCC;
    border-right-color: #999;
    border-left-color: #999;
    border-bottom-color: #BBB;
    border-top: #B00100 solid 4px;
    border-top-left-radius: 9px;
    border-top-right-radius: 9px;
    background-color: white;
    padding: 7px 12% 0;
    box-shadow: 0 3px 8px rgba(50, 50, 50, 0.17);
  }

 h1 {
    color: #404040;
    font-size: 140px;
    margin: 80px 0;
    padding-left: 10px;
    position: relative;
}
  div.dialog > p {
    margin: 0 0 1em;
    padding: 1em;
    background-color: #F7F7F7;
    border: 1px solid #CCC;
    border-right-color: #999;
    border-left-color: #999;
    border-bottom-color: #999;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
    border-top-color: #DADADA;
    color: #666;
    box-shadow: 0 3px 8px rgba(50, 50, 50, 0.17);
  }
  
  .bubbles {
    background: rgba(0, 0, 0, 0) url("images/error/error.png") no-repeat scroll 0 0;
    height: 133px;
    left: 225px;
    position: absolute;
    top: -10px;
    width: 138px;
}

  </style>
  
	</head>
	<body>
	
			<div class="dialog">
			    <div>
			     <p style="text-align: justify;"> </p>
			      <p>  an error occurred, please contact admin.twinsyourlife@gmail.com </p>
			        <h1>404</h1>
				<span class="bubbles"></span>
			      
			    </div>
			    <p><spring:message code="application.error.footer"/></p>
			  
		   </div>
		   
		   
		
			
</body>
</html>