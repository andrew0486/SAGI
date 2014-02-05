
<%@page import="com.sagi.controller.EmployeeController"%>
<%@page import="com.sagi.controller.SubdirectorateController"%>
<%@page import="com.sagi.logic.Subdirectorates"%>
<%@page import="java.util.List"%>
<%@page import="com.sagi.database.SessionDB"%>
<%@page import="com.sagi.logic.Employees"%>
<% Employees employee = (Employees)session.getAttribute("employeeLogin"); 
	SessionDB.init();
	List<Subdirectorates> listSubdirectorates = SubdirectorateController.listOrder();
	
%>
<!DOCTYPE html>
<html lang="ES">
<head>
	<meta charset="utf-8">
	<title>CORPOBOYACA - SAGI</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<script language="javascript">
		function Combos(x) {
		  ItDepend=document.getElementById('CombDependiente');
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
<body onload="Combos(this)">
	<form action="">
		<label for="or">Subdirección</label>
		<select name="or" id="or" onchange="Combos(this)">
			<%for(int i=0; i<listSubdirectorates.size(); i++){ %>
				<option value="<%= listSubdirectorates.get(i).getSubdirectorateId()%>" 
			>
				<%= listSubdirectorates.get(i).getSubdirectorateName()%>
			</option>
			<% } /*end for*/ %>
		</select>
		<label for="CombDependiente">Empleados subdirección:</label>
		<select name="CombDependiente" id="CombDependiente"></select>
		<input type="submit" value="Ir" />
	</form>
</body>
</html>