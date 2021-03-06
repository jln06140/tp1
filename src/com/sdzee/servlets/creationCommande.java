package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Client;
import com.sdzee.beans.Commande;

/**
 * Servlet implementation class creationCommande
 */
@WebServlet( "/creationCommande" )
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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String erreur = "";
        // final String ATT_NOM = "nom";
        // final String ATT_PRENOM = "prenom";
        // final String ATT_ADRESSE = "adresse";
        // final String ATT_TELEPHONE = "telephone";
        // final String ATT_EMAIL = "email";
        final String ATT_CLIENT = "client";
        final String ATT_COMMANDE = "commande";
        final String ATT_ERREUR = "erreur";

        /*
         * Partie recuperation infos client
         * 
         */
        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String adresse = request.getParameter( "adresseClient" );
        String telephone = request.getParameter( "telephoneClient" );
        String email = request.getParameter( "emailClient" );

        Client client = new Client();

        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        /*
         * Partie recuperation Commande
         * 
         */

        // recuperation Date
        String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        String dateString = date.toString();

        // recuperation valeur montant commande

        String mont = request.getParameter( "montantCommande" );

        Double montant = 0.0;

        if ( mont != null ) {
            try {
                montant = Double.parseDouble( mont );
            } catch ( NumberFormatException e ) {
                /*
                 * Initialisation à -1 si le montant n'est pas un nombre correct
                 */
                montant = -1.0;
            }
        }

        String modePaiement = request.getParameter( "modePaiementCommande" );
        String statusPaiement = request.getParameter( "statutPaiementCommande" );
        String modeLivraison = request.getParameter( "modeLivraisonCommande" );
        String statusLivraison = request.getParameter( "statutLivraisonCommande" );

        Commande commande = new Commande();

        commande.setClient( client );
        commande.setDate( dateString );
        commande.setMontant( montant );
        commande.setModePaiement( modePaiement );
        commande.setStatutCommande( statusPaiement );
        commande.setModeLivraison( modeLivraison );
        commande.setStatusLivraison( statusLivraison );

        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_COMMANDE, commande );
        request.setAttribute( ATT_ERREUR, erreur );

        if ( request.getParameterMap().isEmpty() ) {
            // pas de parama
            System.out.println( "aucun paramètres" );
        } else {
            if ( ( nom != null && nom.trim().isEmpty() ) || ( adresse != null && adresse.trim().isEmpty() )
                    || ( telephone != null && telephone.trim().isEmpty() ) ) {
                erreur = "Erreur - vous n\'avez pas remplis tous les champs obligatoires</br><a href=\"creaCcommande\">cliquer ici</a> pour acceder au formulaire de creation commande";
            } else {
                erreur = "Ccommande créee avec succes";
            }
        }
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( "/WEB-INF/creerCommande.jsp" ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
