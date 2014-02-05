<!doctype html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<!--HEADER=======================================-->
	<div class="container">	
		<!--<div class="container">-->
		<div class="row">				
			<div class="span2">
				<br>
				<img src="img/Logo/logo.jpg" height="200" width="200" alt="Logo CORPOBOYACÁ">
			</div>
			<div class="span8">
				<div class="hero-unit">
					<h1 align="center">CORPOBOYACÁ</h1>
					<h2 align="center"><stron>Upss!!</stron>
						<%Object error = session.getAttribute("errorPagina");
							out.print(error);
							session.removeAttribute("errorPagina");
						%> 
					</h2>
					<h1 align="center"><a href="index.jsp" ><img src="img/glyphicons/glyphicons_380_message_forward.png" height="100" width="100" alt="">Inicio</a></h1>
				</div>
			</div>
			<div class="span2">
				<br>
				<img src="img/Logo/LogoSAGI.png" height="165" width="165" alt="logo SAGI">
			</div>				
		</div>	  
	 </div>
	 
	 <script type="text/javascript" src="js/jquery.js"></script>
	 <script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
