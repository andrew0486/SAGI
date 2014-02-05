<%Object userId = session.getAttribute("userId");
Object administrator = session.getAttribute("administrator");
if (userId !=null){ %>
<%@page import="com.sagi.database.SessionDB"%>
<%@page import="com.sagi.controller.EmployeeController"%>
<%@page import="com.sagi.logic.Employees"%>
<%@page import="java.util.List"%>
<%@page session="true"%>
<%
	SessionDB.init();
	List<Employees> list = EmployeeController.listOrder();
	//SessionDB.close();
%>
<!DOCTYPE html>
<html lang="ESP">
<head>
<meta charset="utf-8">
<title>SAGI - FUNCIONARIOS</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_top.jsp"></jsp:include>
	<jsp:include page="_heroUnit.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<table class="table table-striped table-hover-green">
				<thead>
					<tr>
						<td><h4>C�digo</h4></td>
						<td><h4>Apellido(s)</h4></td>
						<td><h4>Nombre(s)</h4></td>
						<% if (administrator != null){ %>
						<td><h4>Tipo de Documento</h4></td>
						<td><h4>N�mero de documento</h4></td>
						<td><h4>Ciudad de Expedici�n</h4></td>
						<td><h4>Direcci�n</h4></td>
						<% }%>
						<td><h4>Tel�fono</h4></td>
						<td><h4>email</h4></td>
						<td><h4>Subdirecci�n</h4></td>
						<td><h4>Profesi�n</h4></td>
						<% if (administrator != null){ %>
						<td><h4>Estado</h4></td>
						<td><h4>Editar</h4></td>
						<% }%>
					</tr>
				</thead>
				<tbody>
					<%
						for (Employees employee : list) {
					%>
					<tr>
						<%if (employee.getEmployeeId()!=1){ %>
							<td><%=employee.getEmployeeId()%></td>
							<td><%=employee.getLastName()%></td>
							<td><%=employee.getFirstName()%></td>
							<% if (administrator != null){ %>
							<td><%=employee.getDocumentType()%></td>
							<td><%=employee.getDocumentNumber()%></td>
							<td><%=employee.getDocumentCity()%></td>
							<td><%=employee.getStreetAddress() + " "
							+ employee.getCity()%></td>
							<% }%>
							<td><%=employee.getPhoneNumber()%></td>
							<td><%=employee.getEmail()%></td>
							<td><%=employee.getSubdirectorates().getSubdirectorateName()%></td>
							<td><%=employee.getJobs().getJobTitle()%></td>
							<% if (administrator != null){ %>
							<td<%String state = employee.getActiveState();%> style ="color: <%if (state.equals("INACTIVO")){out.print("red");}%>">
								<%= state %>
							</td>
							<td>
								<a href="employees_edit.jsp?id=<%=employee.getEmployeeId()%>" class="btn btn-primary btn-small">Editar</a>
							</td>
							<% }%>
						<%} %>
					</tr>
					<%
						} //end for 
						SessionDB.close();
					%>
				</tbody>
			</table>
		</div>
		<% if (administrator != null){ %>
		<div class="row-fluid">
			<a href="employees_edit.jsp" class="btn btn-primary "><img alt="Prev" src="img/glyphicons/glyphicons_006_user_add.png" height="30" width="30"> <strong>Nuevo !</strong></a>
		</div>
		<% }%>
	</div>


	<jsp:include page="_down.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
<%}else { session.setAttribute("errorPagina", "Para poder ver este recurso necesita iniciar sesi�n");%>
	
	<jsp:include page="error.jsp"></jsp:include>
<%}%>