<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'un client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<c:import url="menu.jsp"></c:import>
	<div>
		<form method="POST" action='<c:url value="afficherClient"/>'>
			<c:import url="/inc/inc_client_form.jsp"></c:import>
			<input type="submit" value="Valider" />
			<input type="reset"	value="Remettre à zéro" /> <br />
		</form>
	</div>
</body>
</html>