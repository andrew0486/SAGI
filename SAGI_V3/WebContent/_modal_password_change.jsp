<!DOCTYPE html>
<html lang="ESP">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript">
		function ValidarPassword(password1, password2){
			pass1=document.getElementById(password1);
			pass2=document.getElementById(password2);
			if(pass1.value == pass2 ){
	     		alert("Error en la confirmacion de la contraseña");
	     		password2.focus();
	     		return false;
	    	}else{
	       		return true;
	  		}
		}
	</script>
</head>
<body>
	<div id="passwordChange" class="modal hide fade in" style="display: none;">
		<!--Modal crear concepto-->
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>Cambiar Contraseña</h3>
		</div>
		<div class="modal-body">
			<!--Cuerpo del modal-->
			<form class="form" role="form" action="PasswordChange.jsp" method="post" >
				<input type="password" class="input-block-level :min_length;6" placeholder="Contraseña Actual *" name="passwordNow" required>
				<div class="control-group">
					<input class="input-block-level :wait;0000 :min_length;6" id="inputContraseña" type="password" name="passwordNew" placeholder="Nueva Contraseña *" required/>
					<input class="input-block-level :wait;0000 :min_length;6 :same_as;inputContraseña" id="inputConfirmar" type="password" name="passwordConfirm" placeholder="Confirmar Contraseña *" required/>
                </div>
				<!--  
				<input type="password" class="input-block-level" id="passwordNew1" name="passwordNew" placeholder="Nueva Contraseña" required>
				<input type="password" class="input-block-level :same_as; passwordNew2 password2" id ="passwordNew2" name="passwordNew2" placeholder="Confirmar Contraseña" required>
				-->
			<div class="modal-footer">
				<!-- Pie de modal-->
				<button type="submit" class="btn btn-primary ">Cambiar</button>
				<a href="#" data-dismiss="modal" class="btn">Cerrar</a>
			</div>
			</form>
		</div>
		
	</div>

</body>
</html>