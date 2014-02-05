<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<title>SAGI</title>
</head>
<body>
	<header>
		<jsp:include page="_top.jsp"></jsp:include>
	</header>
	<br>

	<div class="container-fluid" margin="100px">
		<!--contenedor principal-->
		<div class="row-fluid">
			<!--<div class="span1"> <img src="img/logo.jpg"></div> <!--panel izquierdo-->
			<div class="span12">
				<!--panel central-->
				<div class="container-fluid">
					<!--Contenedor de panel interno-->
					<div class="row-fluid">
						<div class="span3">
							<!--Columna de menu interno-->
							<div class="well sidebar-nav">
								<ul class="nav nav-list">
									<li class="nav-header">Indice</li>
									<li class="active"><a href="#">1.Información General</a></li>
									<li><a href="#">2.Antecedentes</a></li>
									<li data-toggle="collapse" data-target="#colpAspectos"><a
										href="#">3.Aspectos</a></li>
									<ul id="colpAspectos" class="collapse">
										<li><a href="#">3.1.Técnicos</a></li>
										<li><a href="#">3.2. Ambientales</a></li>
										<li><a href="#">3.3. Análisis de la Información</a></li>
									</ul>
									<li><a href="#">4.Conclusiones y Recomendaciones</a></li>
									<li><a href="#">5.Observaciones</a></li>
									<li><a href="#">6.Concepto Técnico</a></li>
									<li><a href="#">7.Revisión</a></li>
								</ul>
							</div>

						</div>
						<div class="span9 well">
							<!--Contenedor de formulario -->
							<form role="form" id="formularioExpediente">
								<!--formulario Creación Expediente -->
								<h4>1.Solicitante</h4>
								<div class="form-group form-inline well">
									<label><h5>Persona</h5> </label> <select required
										id="tipoPersona" name="pjuridica">
										<option value="Natural">Natural</option>
										<option value="Juridica" checked>Juridica</option>
									</select> <input type="radio" value="Pública" name="pjuridica"
										id="rpublica"> Pública <input type="radio"
										value="Privada" name="pjuridica" id="rprivada">
									Privada
								</div>
								<h4>2. Nombre o Razón Social</h4>
								<div class="form-group form-inline well">
									<input type="text" class="span8"
										placeholder="Nombre o Razón Social"><span
										class="help-block"></span> <br> <label>Tipo
										Documento</label> <select class="select span2"> uemtno
										<option value="Cedula">C.C</option>
										<option value="Nit">Nit</option>
									</select> <label>No</label> <input type="text" class="text text-medium"
										placeholder="Ingrese número">


								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
			<!--<div class="span1"> <img src="img/sagi.png"></div> <!--panel derecho-->

		</div>

	</div>

	<jsp:include page="_down.jsp"></jsp:include>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>



<!--javascript-->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

</body>

</html>