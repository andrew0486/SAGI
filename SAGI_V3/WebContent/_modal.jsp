<!DOCTYPE html>
<html lang="ESP">
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>	
			<!-- MODAL OF USER LOGIN======================================== -->
	<div class="container" style="display:none;" id="formulario_modal">
		<div class="row">
			<!-- Modal -->
			<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Iniciar Sesión</h4>
						</div>
						<div class="modal-body">
							<form action="login.jsp"  class="modal-form" method="post">
					        	<input type="text" class="input-block-level" placeholder="Nombre de Usuario" name="userName" autofocus="autofocus" autocomplete="off" required>
					        	<input type="password" class="input-block-level" placeholder="Contraseña" name="password" required>
					        	<label class="checkbox">
					          	<input type="checkbox" value="remember-me"> Recuerdame
					        	</label>
					        	<br>
					        	<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
									<button type="submit" class="btn btn-primary ">Iniciar</button>
									<br>
									<div class="container-fluid">
										<div class="row-fluid">
											<h5>
												<div class="span5" style="text-align: left">
													<a href="#">Olvide mi Contraseña</a>	
												</div>
												<div class="span3 offset4" style="text-align: rigth">
													<a href="#">Registrate ya!!!</a>
												</div>
											</h5>
										</div>
									</div>
								</div>
					      	</form>
						</div>						
					</div><!-- /.modal-content -->
				</div><!-- /.modal-dialog -->
			</div><!-- /.modal -->
			<!--ACORDEONES, GENERE DE AMBOS ESTILOS PARA OCULTAR TEXTO Y PARA OCULATAR O MOSTRAR MENUS-->
		</div>
	</div>

</body>
</html>