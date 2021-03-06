package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Client;

/**
 * Servlet implementation class creationClient
 */
@WebServlet( "/creationClient" )
public class creationClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public creationClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        final String VUE = "/WEB-INF/creerClient.jsp";

        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String adresse = request.getParameter( "adresseClient" );
        String telephone = request.getParameter( "telephoneClient" );
        String email = request.getParameter( "emailClient" );

        String erreur = "";

        if ( request.getParameterMap().isEmpty() ) {
            // pas de parama
            System.out.println( "aucun paramètres" );
        } else {
            if ( ( nom != null && nom.trim().isEmpty() ) || ( adresse != null && adresse.trim().isEmpty() )
                    || ( telephone != null && telephone.trim().isEmpty() ) ) {
                erreur = "Erreur - vous n\'avez pas remplis tous les champs obligatoires</br><a href=\"creaClient\">cliquer ici</a> pour acceder au formulaire de creation client";
            } else {
                erreur = "Client crée avec succes";
            }
        }

        HttpSession session = request.getSession();

        Client client = new Client();

        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        request.setAttribute( "client", client );
        request.setAttribute( "erreur", erreur );

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
