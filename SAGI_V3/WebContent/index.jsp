<%
	Object userId = session.getAttribute("userId");
	Object error = session.getAttribute("error");
	Object exito = session.getAttribute("exito");
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
	
	<div class="container-fluid">
		<% if(userId != null && exito == null){%>
			<div class="alert alert-success">
				<a class="close" data-dismiss="alert">&times;</a>
				<strong>Exito!</strong> Has iniciado sesión correctamente.
				<%session.setAttribute("exito", "Ya se ha mostrado este mensaje"); %>
			</div>
		<%}else{ %>
				<% if (error != null){%>
				<div class="alert alert-error">
					<a class="close" data-dismiss="alert">&times;</a>
					<strong>Error!</strong> <%= error.toString()%>.
				</div>
			<%} session.removeAttribute("error");%>
		<%}%>
		<jsp:include page="_heroUnit.jsp"></jsp:include>
		<jsp:include page="_banner.jsp"></jsp:include>
		<jsp:include page="_modal.jsp"></jsp:include>
	</div>

	<!--CONTENIDO=======================================-->
	<div class="container">
		<div class="row">
			<div class="nav4">
				 <div class="accordion" id="accordion">
				 	<div class="accordion-group">
				 		<div class="accordion-heading">
				 			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
				 				<h3>Nuevas Noticias</h3>
				 			</a>
				 		</div>
				 		<div id="collapseOne" class="accordion-body collapse in">
				 			<div class="accordion-inner">
				 				Hola como estanm Estación Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				 			</div>
				 		</div>
				 	</div>
				 	<div class="accordion-group">
				 		<div class="accordion-heading">
				 			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
				 				Collapsible Group Item #2
				 			</a>
				 		</div>
				 		<div id="collapseTwo" class="accordion-body collapse">
				 			<div class="accordion-inner">
				 				Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				 			</div>
				 		</div>
				 	</div>
				 	<div class="accordion-group">
				 		<div class="accordion-heading">
				 			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
				 				Collapsible Group Item #3
				 			</a>
				 		</div>
				 		<div id="collapseThree" class="accordion-body collapse">
				 			<div class="accordion-inner">
				 				<ul class="nav-list">
				 					<li class="nav-header">
				 						Lista de menu
				 					</li>
				 					<li>
				 						<div class="accordion-group">
									 		<div class="accordion-heading">
									 			<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour">
									 				Este es el acordeon #4
									 			</a>
									 		</div>
									 		<div id="collapseFour" class="accordion-body collapse">
									 			<div class="accordion-inner">
									 				Este es el acordeon Numero 4 y este lo hizo andres solito sin necesidad de ningun tipo de complemento ... solo hechando codigo pelado.... :)
									 			</div>
									 		</div>
									 	</div>
				 					</li>
				 					<li id="itemLista2"><a href="#itemLista2">texto2</a></li>
				 					<li id="itemLista3"><a href="#itemLista3">texto3</a></li>
				 				</ul>
				 			</div>
				 		</div>
				 	</div>
				 </div>
			</div>
		</div>
	</div>
	
		

	<script type="text/javascript">
      function visualiza_formulario() {
         document.getElementById('formulario_modal').style.visibility='visible';
         document.getElementById('formulario_modal').style.display='inline';
      };
   	</script>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/../js/vanadium.js"></script>
</body>
</html>