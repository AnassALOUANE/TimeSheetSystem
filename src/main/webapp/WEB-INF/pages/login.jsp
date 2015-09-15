<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en"><!--HEAD - ONLOAD--><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!--Define our base-->
<!-- base href="http://localhost/crm/application/themes/default/common/" -->

<link rel="stylesheet" href="<c:url value="/css/login.css"/>" type="text/css" media="screen" title="default" />

<body class="bg_black">
		<div class="body body-s">
		
                                <form action="<c:url value="/auth" />" class="sky-form" method="post">

                                    <header> Timesheet System</header>
				
				<fieldset>	
                                        <div class="login-title" style="color:red;"> ${message} </div>
					<section>
						<div class="row">
							<label class="label col col-4">Employee Code</label>
							<div class="col col-8">
								<label class="input">
									<i class="icon-append"></i>
                                                                        <input class="form-control" id="email" name="j_username" autocomplete="off" data-placeholder="email address" type="text">
								</label>
							</div>
						</div>
					</section>
					
					<section>
						<div class="row">
							<label class="label col col-4">Password</label>
							<div class="col col-8">
								<label class="input">
									<i class="icon-prepend"></i>
									 <input class="form-control" id="password" name="j_password" autocomplete="off" data-placeholder="password" type="password">
								</label>
							</div>
						</div>
					</section>
					
					<section>
						 
					</section>
				</fieldset>
				<footer>
					<button type="submit" class="button">Log in</button>
                                        <button type="reset" class="button button-secondary"> Reset</button>
				</footer>
			</form>
			
		</div>
	
</body>

</html>