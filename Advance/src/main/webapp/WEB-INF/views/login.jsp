<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" href="resources/css/main.css" />
</head>
<body>
<%
    String context = request.getContextPath();
%>
<form id="loginFrm" name="loginFrm" method="post" action="<%=context%>/login">
	<div class="container-fluid">
		<div id="page-login" class="row">
			<div class="col-xs-12 col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
				<div class="box">
					<div class="box-content">
						<div class="form-group">
							<div class="bos-left">
								<img src="resources/images/logo.png"/>
							</div>
						</div>
						<div class="text-right">
							${greeting}
						</div>
						<div class="form-group">
							<label class="control-label">Username</label>
							<input type="text" class="form-control" name="id" value="${inputId}"/>
						</div>
						<div class="form-group">
							<label class="control-label">Password</label>
							<input type="password" class="form-control" name="pw" value="${inputId}"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<input type="submit" class="btn btn-danger"  value="Sign in" />
							</div>
						</div>
						
						<div class="form-group">
								<i class="fa fa-question-circle"></i><font size="1">&nbsp;로그인 및 관련 문의: admin</font>
						</div>
											
				     </div>
				</div>
			</div>
		</div>
	</div>
</form> 
</body>
</html>
