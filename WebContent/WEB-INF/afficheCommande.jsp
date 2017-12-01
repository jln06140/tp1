<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>affichage d'une commande</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${erreur }">
				<span class='erreur'>Erreur - vous n'avez pas remplis tous
					les champs obligatoires</br> <a href="creaCommande">cliquer ici</a> pour
					acceder au formulaire de creation commande
				</span>
			</c:when>
			<c:otherwise>
				<c:out
					value="<span class ='erreur'>Commande créee avec succés</span>"
					escapeXml="false" />
				

				<fieldset>
					<legend>Client</legend>
					<p>
						Nom :
						<c:out value="${client.nom }" />
					</p>
					<p>
						Prenom :
						<c:out value="${client.prenom }" />
					</p>
					<p>
						Adresse :
						<c:out value="${client.adresse }" />
					</p>
					<p>
						Telephone :
						<c:out value="${client.telephone }" />
					</p>
					<p>
						Email :
						<c:out value="${client.email }" />
					</p>
				</fieldset>

				<fieldset>
					<legend>Commande</legend>
					<p>
						Date :
						<c:out value="${commande.date }" />
					</p>
					<p>
						Montant :
						<c:out value="${commande.montant }" />
					</p>
					<p>
						Mode de paiement :
						<c:out value="${commande.modePaiement }" />
					</p>
					<p>
						Status du paiement :
						<c:out value="${commande.statutCommande }" />
					</p>
					<p>
						Mode de livraison :
						<c:out value="${commande.modeLivraison }" />
					</p>
					<p>
						Status de livraison :
						<c:out value="${commande.statusLivraison }" />
					</p>
				</fieldset>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>