<%@page import="com.sagi.logic.Employees"%>
<%
	Object userId = session.getAttribute("userId");
	Object administrator = session.getAttribute("administrator");
	if (userId != null) {
%>
<%
	Object employee = session.getAttribute("employeeLogin");
		Employees employeeLogin = (Employees) employee;
	Object errorContrasena = session.getAttribute("errorContrasena");
	Object successContrasena = session.getAttribute("successContrasena");
%>
<!DOCTYPE html>
<html lang="ES">
<head>
<meta charset="utf-8">
<title>CORPOBOYACA - SAGI</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_top.jsp"></jsp:include>
	<% if (errorContrasena != null){%>
		<div class="alert alert-error">
			<a class="close" data-dismiss="alert">&times;</a>
			<strong>Error!</strong> <%=errorContrasena.toString() %>
			<%session.removeAttribute("errorContrasena"); %>
		</div>
	<%}
	if(successContrasena != null){%>
		<div class="alert alert-success">
		<a class="close" data-dismiss="alert">&times;</a>
		<strong>Success!</strong> <% out.print(successContrasena.toString());
		session.removeAttribute("successContrasena");%>
	</div>
	<%} %>
	<jsp:include page="_heroUnit.jsp"></jsp:include>
	<div class="container">
		<div class="row-fluid">
			<div class="span10 offset1">
				<div class="well">
					<div class="row-fluid">
						<div class="span3">
							<div class="well">
								<div class="row-fluid">
									<ul class="thumbnails">
										<li class="span"><img alt="user"
											src="img/glyphicons/user_icon.png" height="200" width="200">
										</li>
									</ul>
								</div>
							</div>
						</div>

						<div class="span9">
							<form class="form">

								<div class=" control-group form-inline">
									<label class="control-label">Nombre(s)</label> <input
										type="text" disabled
										value="<%=employeeLogin.getFirstName()%>"> <label
										class="control-label">Apellido(s)</label> <input type="text"
										disabled value="<%=employeeLogin.getLastName()%>">
								</div>

								<div class="control-group form-inline">
									<label class="control-label"><%=employeeLogin.getDocumentType()%></label>
									<input type="text" disabled
										value="<%=employeeLogin.getDocumentNumber()%>"> <label
										class="control-label"> de </label> <input type="text"
										disabled value="<%=employeeLogin.getDocumentCity()%>">
								</div>

								<div class="control-group form-inline">
									<label class="control-label">Dirección</label> <input
										type="text" disabled
										value="<%=employeeLogin.getStreetAddress() + " - "
						+ employeeLogin.getCity()%>">
									<label class="control-label"> Teléfono </label> <input
										type="text" disabled
										value="<%=employeeLogin.getPhoneNumber()%>">
								</div>

								<div class="control-group form-inline">
									<label class="control-label">email</label> <input type="text"
										disabled value="<%=employeeLogin.getEmail()%>">
								</div>

								<div class="control-group form-inline">
									<label class="control-label" for="lblHireDate">Desde</label> <input
										type="text" disabled
										value="<%=employeeLogin.getHireDate().toString()%>">
									<label class="control-label" for="lblHireDate"> hasta </label>
									<input type="text" disabled
										value="<%if (employeeLogin.getEndDate() != null) {
					out.print(employeeLogin.getEndDate().toString());
				} else {
					out.print("INDEFINIDO");
				}%>">
								</div>

								<div class="control-group form-inline">
									<a data-toggle="modal" href="#passwordChange"
										class="btn btn-default input-xlarge" height="30" width="30"><strong>Cambiar
											Contraseña</strong></a>
								</div>

							</form>
							<!--form-->
						</div>
						<!--span, well-->
					</div>
					<!--row-fluid-->
				</div>
				<!--well-->

			</div>
			<!--span9-->
			<div class="span1"></div>
		</div>
		<!--row-fluid-->
	</div>
	<!--container-->
	<jsp:include page="_modal_password_change.jsp"></jsp:include>
	<jsp:include page="_down.jsp"></jsp:include>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/../js/vanadium.js"></script>
</body>
</html>
<%}else { session.setAttribute("errorPagina", "Para acceder a esta funciÃ³n necesita iniciar sesiÃ³n.");%>
<jsp:include page="error.jsp"></jsp:include>
<%}%>