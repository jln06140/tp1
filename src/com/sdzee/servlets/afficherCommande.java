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
 * Servlet implementation class afficherCommande
 */
@WebServlet( "/afficherCommande" )
public class afficherCommande extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficherCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        final String VUE = "/WEB-INF/afficheCommande.jsp";

        final String CHAMP_NOM = "nomClient";
        final String CHAMP_PRENOM = "prenomClient";
        final String CHAMP_ADRESSE = "adresseClient";
        final String CHAMP_TELEPHONE = "telephoneClient";
        final String CHAMP_EMAIL = "emailClient";

        final String CHAMPS_MONTANT = "montantCommande";
        final String CHAMPS_MODEPAIEMENT = "modePaiementCommande";
        final String CHAMPS_STATUSPAIEMENT = "statutPaiementCommande";
        final String CHAMPS_MODELIVRAISON = "modeLivraisonCommande";
        final String CHAMPS_LIVRAISONCOMMANDE = "statutLivraisonCommande";

        final String FORMAT = "dd/MM/yy H:mm:ss";
        boolean erreur = false;

        final String ATT_CLIENT = "client";
        final String ATT_COMMANDE = "commande";
        final String ATT_ERREUR = "erreur";

        /*
         * Partie recuperation infos client
         * 
         */
        String nom = request.getParameter( CHAMP_NOM );
        String prenom = request.getParameter( CHAMP_PRENOM );
        String adresse = request.getParameter( CHAMP_ADRESSE );
        String telephone = request.getParameter( CHAMP_TELEPHONE );
        String email = request.getParameter( CHAMP_EMAIL );

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

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( FORMAT );
        java.util.Date date = new java.util.Date();
        String dateString = date.toString();

        // recuperation valeur montant commande

        String mont = request.getParameter( CHAMPS_MONTANT );

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

        String modePaiement = request.getParameter( CHAMPS_MODEPAIEMENT );
        String statusPaiement = request.getParameter( CHAMPS_STATUSPAIEMENT );
        String modeLivraison = request.getParameter( CHAMPS_MODELIVRAISON );
        String statusLivraison = request.getParameter( CHAMPS_LIVRAISONCOMMANDE );

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
            erreur = true;
            System.out.println( "aucun paramètres" );
        } else {
            if ( ( nom != null && nom.trim().isEmpty() ) || ( adresse != null && adresse.trim().isEmpty() )
                    || ( telephone != null && telephone.trim().isEmpty() )
                    || ( modePaiement != null && modePaiement.trim().isEmpty() )
                    || ( modeLivraison != null && modeLivraison.trim().isEmpty() )
                    || ( montant == -1.0 ) ) {
                erreur = true;
            } else {
                erreur = false;
            }
        }
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
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
