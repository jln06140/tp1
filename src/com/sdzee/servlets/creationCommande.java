package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.sdzee.beans.Client;
import com.sdzee.beans.Commande;

/**
 * Servlet implementation class creationCommande
 */
@WebServlet("/creationCommande")
public class creationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creationCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Partie recuperation infos client
		 * 
		 */
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String adresse = request.getParameter("adresseClient");
		String telephone = request.getParameter("telephoneClient");
		String email = request.getParameter("emailClient");
		
		boolean erreur = false;
		
//		if(nom.equals("") || prenom.equals("") || adresse.equals("") || telephone.equals("") || email.equals("")){
//			erreur = true;
//		}
		
		Client client = new Client();
		
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setTelephone(telephone);
		client.setEmail(email);
		
		
		/*Partie recuperation Commande
		 * 
		 */
		DateTime dt = new DateTime();
		String dateDuJour = dt.now()+"";
		
		String mont = request.getParameter("montantCommande");
		Double montant = Double.parseDouble(mont);
		String modePaiement = request.getParameter("modePaiementCommande");
		String statusPaiement = request.getParameter("statutPaiementCommande");
		String modeLivraison = request.getParameter("modeLivraisonCommande");
		String statusLivraison = request.getParameter("statutLivraisonCommande");
		
		Commande commande = new Commande();
		
		commande.setClient(client);
		commande.setDate(dateDuJour);
		commande.setMontant(montant);
		commande.setModePaiement(modePaiement);
		commande.setStatutCommande(statusPaiement);
		commande.setModeLivraison(modeLivraison);
		commande.setStatusLivraison(statusLivraison);
		
		
		
		request.setAttribute("client", client);
		request.setAttribute("commande", commande);
		request.setAttribute("erreur", erreur);
		
		
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( "/WEB-INF/creerCommande.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
