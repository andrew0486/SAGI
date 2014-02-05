<%@page import="com.sagi.controller.FunctionController"%>
<%@page import="com.sun.org.apache.xpath.internal.functions.FuncId"%>
<%@page import="com.sagi.logic.Functions"%>
<%Object userId = session.getAttribute("userId");
Object administrator = session.getAttribute("administrator");
if (userId !=null && administrator!=null){ %>
<%@page import="sun.org.mozilla.javascript.internal.ast.ForInLoop"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.sagi.logic.Jobs"%>
<%@page import="com.sagi.controller.JobController"%>
<%@page import="com.sagi.controller.EmployeeController"%>
<%@page import="com.sagi.logic.Subdirectorates"%>
<%@page import="com.sagi.database.SessionDB"%>
<%@page import="com.sagi.controller.SubdirectorateController"%>
<%@page import="com.sagi.logic.Employees"%>
<%@page import="java.util.List"%>
<%@page session="true"%>

<script type="text/javascript">
<!--

function eliminarEmployeeUpdate() {
    <%session.removeAttribute("employeeUpdate1");%>
};
//-->
</script>
<% 
	
	
	SessionDB.init();
	Employees employee = new Employees();
	Functions function = null;
	employee.setEmployeeId(-1);
	if (request.getParameter("id") != null){
		int idEmployee = Integer.parseInt(request.getParameter("id"));
		employee = EmployeeController.get(idEmployee);
		function = FunctionController.get(employee.getFunctions().getFunctionId());
		session.setAttribute("employeeUpdate1", idEmployee);
	}
	List<Subdirectorates> listSubdirectorates = SubdirectorateController.listOrder();
	List<Employees> listEmployees = EmployeeController.listOrder();
	List<Jobs> listJob=JobController.listOrder();
	//SessionDB.close();
	int identi = employee.getEmployeeId();
%>

<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>SAGI Edición Funcionarios</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript">
		function Validar(documentNumber){
			documentNumber=document.getElementById(documentNumber);
			<%for (int i = 0; i< listEmployees.size() ; i++){%>
				if(documentNumber.value== <%=listEmployees.get(i).getDocumentNumber()%>){
		     		alert("El número de cedula que esta intentando ingresar ya se encuentra en la base de datos");
		     		documentNumber.focus();
		     		return false;
		    	}else{
		       		return true;
		  		}
			<%}%>
		}
	</script>
	<script language="javascript">
		function Combos(x) {
		  ItDepend=document.getElementById('manager');
		  if(!ItDepend){return;}                 
		  var mitems=new Array();
		  mitems['Elige']=[''];
		  
		  <%
		    
		  	for (int i = 0 ; i < listSubdirectorates.size() ; i++ ){
		  		System.out.println(listSubdirectorates.get(i).getSubdirectorateName());
		  		List<Employees> listEmployeesSubdir = EmployeeController.listBySubdirectorate(listSubdirectorates.get(i).getSubdirectorateId());
		  		String empleados = "";
		  		for (int j = 0 ; j < listEmployeesSubdir.size() ; j++ ){
		  			empleados += "'" + listEmployeesSubdir.get(j).getLastName() + " " + listEmployeesSubdir.get(j).getFirstName() + "'";
		  			if (j == listEmployeesSubdir.size()-1){
		  				
		  			}else{
		  				empleados += ",";
		  			}
		  		}
		  		out.print("mitems['"+ listSubdirectorates.get(i).getSubdirectorateId() +"'] = [" + empleados + "];");
		  	}
		  %>
		  ItDepend.options.length=0;
		  ItActual=mitems[x.options[x.selectedIndex].value];
		  if(!ItActual){return;}
		  ItDepend.options.length=ItActual.length;
		  for(var i=0;i<ItActual.length;i++) {
		    ItDepend.options[i].text=ItActual[i];
		    ItDepend.options[i].value=ItActual[i];
		  }
		}		 
	</script>
</head>
<body>
<jsp:include page="_top.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row-fluid">
			
				<!--============columna izquierda==================-->
				<div class="container span2"></div>
				<!--============columna Formulario==================-->
				<div class="container span8">
					<form class="form-horizontal" action="EmployeeSave.jsp" onSubmit="<%
						if (employee.getEmployeeId() == -1 ){
							out.print("return Validar('documentNumber')");
						}
					%>
					" method="post">
						<legend>
							<div class="row">
								<div class="span4 offset1">Registrar Datos</div>
							</div>
						</legend>
						<div class="row">
							<div class="span5 offset1">
								Nombre:<br>
								<input type="text" class="input-block-level" autocomplete="off" id="firstName" placeholder="Nombre(s)" maxlength="45" name="firstName" required
								value="<% if (identi!=-1){out.print(employee.getFirstName());}%>"
								/>
							</div>
							<div class="span5">
								Apellido:<br>
								<input type="text" class="input-block-level" autocomplete="off" id="lastName" placeholder="Apellido(s)" maxlength="45" name="lastName" required
								value="<% if (identi!=-1){out.print(employee.getLastName());}%>"
								/>
							</div>
							<div class="span1"></div>
						</div>

						<div class="row">
							<div class="span5 offset1">
								Dirección:<br>
								<input type="text" class="input-block-level" autocomplete="off" id="streetAddress" placeholder="tipo numero1 - numero 2 barrio" maxlength="45" name="streetAddress" required
								value="<% if (identi!=-1){out.print(employee.getStreetAddress());}%>"
								/>
							</div>
							<div class="span5">
								Ciudad de Residencia:<br>
								<input type="text" class="input-block-level" id="cityResident" placeholder="Ciudad" maxlength="45" name="cityResident" required
								value="<% if (identi!=-1){out.print(employee.getCity());}%>"
								/>
							</div>
							<div class="span1"></div>
						</div>

						<div class="row">
							<div class="span5 offset1">
								Teléfono:<br>
								<input type="text" class="input-block-level" autocomplete="off" id="phoneNumber" placeholder="09874540.. o 31241401.." maxlength="10"  
								name="phoneNumber"  pattern="[0-9]{10}" required
								value="<% if (identi!=-1){out.print(employee.getPhoneNumber());}%>"
								/>
							</div>
							<div class="span5">
								Correo Electrónico:<br>
								<input type="email" class="input-block-level" autocomplete="off" id="email" placeholder="ejemplo@ejemplo.com" maxlength="45" name="email" required
								value="<% if (identi!=-1){out.print(employee.getEmail());}%>"
								/>
							</div>
							<div class="span1"></div>
						</div>

						<div class="row">
							<div class="span3 offset1">
								Tipo de Documento:<br>
								<select name="documentType" class="input-block-level">
									<% for(int i=0; i<Employees.DOCUMENT_TYPES.length; i++){ %>
									<option value="<%= Employees.DOCUMENT_TYPES[i]%>"
										<%
										if (identi != -1){
											if (employee.getDocumentType().equals(Employees.DOCUMENT_TYPES[i])){out.print("selected");
											}
										}	
										%>
									>
										<%= Employees.DOCUMENT_TYPES[i]%>
									</option>
									<% } /*end for*/ %>
								</select>
							</div>
							<div class="span4">
								Ciudad de Expedición:<br>
								<input type="text" class="input-block-level" id="documentCity" placeholder="Ciudad(Departamento)" maxlength="45" name="documentCity" required
								value="<% if (identi!=-1){out.print(employee.getDocumentCity());}%>"/>
							</div>
							<div class="span3">
								Número de Documento:<br>
								<input type="text" class="input-block-level" autocomplete="off" id="documentNumber" placeholder="N° documento de identidad" maxlength="25" name="documentNumber" required
								value="<% if (identi!=-1){out.print(employee.getDocumentNumber());}%>"/>
							</div>
							<div class="span1"></div>
						</div>
						<br>
						<div class="row">
							<div class="span10 offset1">
								Funciones:<br>
								<div class="container">
									<div class="span3">
										<h4>Usuarios</h4>
										<label for="createUser" class="checkbox"><input type="checkbox" name="createUser" id="createUser" value="createUser" disabled="disabled"
										<% if (identi != -1 && function != null){
											if (function.isCreateUser()==true){
												out.print("checked");
											}
										}%>
										>Crear Usuarios</label>
										<label for="uploadUser" class="checkbox"><input type="checkbox" name="uploadUser" id="uploadUser" value="uploadUser" disabled="disabled"
										<% if (identi != -1 && function != null){
											if (function.isUploadUser()==true){
												out.print("checked");
											}
										}%>
										>uploadUser</label>
										<label for="deleteUser" class="checkbox"><input type="checkbox" name="deleteUser" id="deleteUser" value="deleteUser" disabled="disabled"
										<% if (identi != -1 && function != null){
											if (function.isDeleteUser()==true){
												out.print("checked");
											}
										}%>
										>deleteUser</label>
										<h4>Expedientes</h4>
										<label for="createFile" class="checkbox"><input type="checkbox" name="createFile" id="createFile" value="createFile"
										<% if (identi != -1 && function != null){
											if (function.isCreateFile()==true){
												out.print("checked");
											}
										}%>
										>createFile</label>
										<label for="uploadFile" class="checkbox"><input type="checkbox" name="uploadFile" id="uploadFile" value="uploadFile"
										<% if (identi != -1 && function != null){
											if (function.isUploadFile()==true){
												out.print("checked");
											}
										}%>
										>uploadFile</label>
										<label for="deleteFile" class="checkbox"><input type="checkbox" name="deleteFile" id="deleteFile" value="deleteFile"
										<% if (identi != -1 && function != null){
											if (function.isDeleteFile()==true){
												out.print("checked");
											}
										}%>
										>deleteFile</label>
										<h4>Procesos</h4>
										<label for="createProcess" class="checkbox"><input type="checkbox" name="createProcess" id="createProcess" value="createProcess"
										<% if (identi != -1 && function != null){
											if (function.isCreateProcess()==true){
												out.print("checked");
											}
										}%>
										>createProcess</label>
										<label for="uploadProcess" class="checkbox"><input type="checkbox" name="uploadProcess" id="uploadProcess" value="uploadProcess"
										<% if (identi != -1 && function != null){
											if (function.isUploadProcess()==true){
												out.print("checked");
											}
										}%>
										>uploadProcess</label>
										<label for="deleteProcess" class="checkbox"><input type="checkbox" name="deleteProcess" id="deleteProcess" value="deleteProcess"
										<% if (identi != -1 && function != null){
											if (function.isDeleteProcess()==true){
												out.print("checked");
											}
										}%>
										>deleteProcess</label>
									</div>
									<div class="span3">
										<h4>Autos de Inicio</h4>
										<label for="createAutoStart" class="checkbox"><input type="checkbox" name="createAutoStart" id="createAutoStart" value="createAutoStart"
										<% if (identi != -1 && function != null){
											if (function.isCreateAutoStart()==true){
												out.print("checked");
											}
										}%>
										>createAutoStart</label>
										<label for="uploadAutoStart" class="checkbox"><input type="checkbox" name="uploadAutoStart" id="uploadAutoStart" value="uploadAutoStart"
										<% if (identi != -1 && function != null){
											if (function.isUploadAutoStart()==true){
												out.print("checked");
											}
										}%>
										>uploadAutoStart</label>
										<label for="deleteAutoStart" class="checkbox"><input type="checkbox" name="deleteAutoStart" id="deleteAutoStart" value="deleteAutoStart"
										<% if (identi != -1 && function != null){
											if (function.isDeleteAutoStart()==true){
												out.print("checked");
											}
										}%>
										>deleteAutoStart</label>
										<h4>Autos de Requerimiento</h4>
										<label for="createAutoRequeriment" class="checkbox"><input type="checkbox" name="createAutoRequeriment" id="createAutoRequeriment" value="createAutoRequeriment"
										<% if (identi != -1 && function != null){
											if (function.isCreateAutoRequeriment()==true){
												out.print("checked");
											}
										}%>
										>createAutoRequeriment</label>
										<label for="uploadAutorequeriment" class="checkbox"><input type="checkbox" name="uploadAutorequeriment" id="uploadAutorequeriment" value="uploadAutorequeriment"
										<% if (identi != -1 && function != null){
											if (function.isUploadAutoRequeriment()==true){
												out.print("checked");
											}
										}%>
										>uploadAutorequeriment</label>
										<label for="deleteAutoRequeriment" class="checkbox"><input type="checkbox" name="deleteAutoRequeriment" id="deleteAutoRequeriment" value="deleteAutoRequeriment"
										<% if (identi != -1 && function != null){
											if (function.isDeleteAutoRequeriment()==true){
												out.print("checked");
											}
										}%>
										>deleteAutoRequeriment</label>
										<h4>Avisos</h4>
										<label for="createNotice" class="checkbox"><input type="checkbox" name="createNotice" id="createNotice" value="createNotice"
										<% if (identi != -1 && function != null){
											if (function.isCreateNotice()==true){
												out.print("checked");
											}
										}%>
										>createNotice</label>
										<label for="uploadNotice" class="checkbox"><input type="checkbox" name="uploadNotice" id="uploadNotice" value="uploadNotice"
										<% if (identi != -1 && function != null){
											if (function.isUploadNotice()==true){
												out.print("checked");
											}
										}%>
										>uploadNotice</label>
										<label for="deleteNotice" class="checkbox"><input type="checkbox" name="deleteNotice" id="deleteNotice" value="deleteNotice"
										<% if (identi != -1 && function != null){
											if (function.isDeleteNotice()==true){
												out.print("checked");
											}
										}%>
										>deleteNotice</label>
									</div>
									<div class="span3">
										<h4>Conceptor Técnicos</h4>
										<label for="createTechnicalConcept" class="checkbox"><input type="checkbox" name="createTechnicalConcept" id="createTechnicalConcept" value="createTechnicalConcept"
										<% if (identi != -1 && function != null){
											if (function.isCreateTechnicalConcept()==true){
												out.print("checked");
											}
										}%>
										>createTechnicalConcept</label>
										<label for="uploadTechnicalConcept" class="checkbox"><input type="checkbox" name="uploadTechnicalConcept" id="uploadTechnicalConcept" value="uploadTechnicalConcept"
										<% if (identi != -1 && function != null){
											if (function.isUploadTechnicalConcept()==true){
												out.print("checked");
											}
										}%>
										>uploadTechnicalConcept</label>
										<label for="deleteTechnicalConcept" class="checkbox"><input type="checkbox" name="deleteTechnicalConcept" id="deleteTechnicalConcept" value="deleteTechnicalConcept"
										<% if (identi != -1 && function != null){
											if (function.isDeleteTechnicalConcept()==true){
												out.print("checked");
											}
										}%>
										>deleteTechnicalConcept</label>
										<h4>Resoluciones</h4>
										<label for="createResolution" class="checkbox"><input type="checkbox" name="createResolution" id="createResolution" value="createResolution"
										<% if (identi != -1 && function != null){
											if (function.isCreateResolution()==true){
												out.print("checked");
											}
										}%>
										>createResolution</label>
										<label for="uploadResolution" class="checkbox"><input type="checkbox" name="uploadResolution" id="uploadResolution" value="uploadResolution"
										<% if (identi != -1 && function != null){
											if (function.isUploadResolution()==true){
												out.print("checked");
											}
										}%>
										>uploadReolution</label>
										<label for="deleteResolution" class="checkbox"><input type="checkbox" name="deleteResolution" id="deleteResolution" value="deleteResolution"
										<% if (identi != -1 && function != null){
											if (function.isDeleteResolution()==true){
												out.print("checked");
											}
										}%>
										>deleteResolution</label>
									</div>
								
								</div>
							</div>
							<div class="span1"></div>
						</div>
						<br>
						<div class="row">
							<div class="span5 offset1">
								Subdirección:<br>
								<select id="subdirectorate" name="subdirectorate" class="input-block-level" required onchange="Combos(this)">
									<option></option> 
									<%for(int i=0; i<listSubdirectorates.size(); i++){ %>
									<option value="<%= listSubdirectorates.get(i).getSubdirectorateId()%>" 
										<% 
										if (identi != -1){
											if (employee.getSubdirectorates().getSubdirectorateId() == listSubdirectorates.get(i).getSubdirectorateId()){out.print("selected");
											}
										}
										%>
									>
										<%= listSubdirectorates.get(i).getSubdirectorateName()%>
									</option>
									<% } /*end for*/ %>
								</select>
							</div>
							<div class="span5">
								Jefe Inmediato o Supervisor:<br>
								<select id="manager" name="manager" class="input-block-level">
									<option value="vacio"
									<% if (employee.getEmployees()== null){out.print("selected");}%>
									></option>
									<%for(int i=0; i<listEmployees.size(); i++){ %>
									<option value="<%= listEmployees.get(i).getEmployeeId()%>"
										<% if (employee.getEmployees()!=null){
											if( employee.getEmployees().getEmployeeId()== listEmployees.get(i).getEmployeeId()){out.print("selected");}
										}
										%>
									>
										<!-- %= listEmployees.get(i).getLastName()+" "+listEmployees.get(i).getFirstName()%-->
									</option>
									<% } /*end for*/ %>
								</select>
							</div>
							<div class="span1"></div>
						</div>

						<div class="row">
							<div class="span5 offset1">
								Fecha de Incio de Contrato:<br>
								<input type="date" class="input-block-level" id="hireDate" placeholder="Tunja(Bayacá)" maxlength="45" name="hireDate" required
								value="<% if (identi!=-1){out.print(employee.getHireDate().toString());}%>"/>
								
							</div>
							<div class="span5">
								Fecha de Finalizacion de Contrato:<br>
								<input type="date" class="input-block-level" id="endDate" placeholder="Tunja(Bayacá)" maxlength="45" name="endDate"
								value="<% if (identi!=-1){
									if (employee.getEndDate()!=null){
										out.print(employee.getEndDate().toString());
									}
								}%>"/>
							</div>
							<div class="span1"></div>
						</div>

						<div class="row">
							<div class="span5 offset1 form-inline">
								Cargo:<br>
								<select  name="job"">
									<%for (int i = 0; i<listJob.size(); i++){%>
									<option value="<%= listJob.get(i).getJobId()%>"
										<% 
										if (identi != -1){
											if (employee.getJobs().getJobId() == listJob.get(i).getJobId()){out.print("selected");
											}
										}
										%>
									>
										<%= listJob.get(i).getJobTitle()%>
									</option>
									<%} %>
								</select>
								<a data-toggle="modal" href="#newJob" class="btn btn-default" onclick="sendListJob()">Nuevo !</a>
							</div>
							<div class="span5">
								Estado Funcionario:<br>
								<select class="input-block-level" name="activeState">
									<% for (int i = 0; i < employee.ACTIVE_STATES.length; i++){ %>
									<option value="<%= employee.ACTIVE_STATES[i]%>"
										<% 
										if (identi != -1){
											if (employee.getActiveState() == employee.ACTIVE_STATES[i]){out.print("selected");
											}
										}
										%>
										>
										<%= employee.ACTIVE_STATES[i] %>
										
									</option>
									<%} %>
								</select>
							</div>
							<div class="span1"></div>
						</div>
						<br>
						<div class="row">
							<div class="span8 offset2">
								<a href="employeeList.jsp" class="btn btn-default input-xlarge" onclick="eliminarEmployeeUpdate">Cancelar</a>
								<button type="submit" class="btn btn-primary input-xlarge">Aceptar</button>
							</div>
							<div class="span2"></div>
						</div>
					</form>
				</div>
				<!--============columna derecha==================-->
				<div class="container span2"></div>

			</form>
		</div>
	</div>

	<script type="text/javascript">
      function sendListJob() {
         <%session.setAttribute("listJob", listJob);%>
      };
   	</script>
   	<jsp:include page="_modal_jobs.jsp"></jsp:include>
	<jsp:include page="_down.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
<%}else { session.setAttribute("errorPagina", "A esta función solo puede acceder el ADMINISTRADOR del sistema.");%>
	<jsp:include page="error.jsp"></jsp:include>
<%}%>