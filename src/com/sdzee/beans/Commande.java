package com.sdzee.beans;

public class Commande {
	
	private Client client;
	private String date;
	private Double montant;
	private String modePaiement;
	private String statutCommande;
	private String modeLivraison;
	private String statusLivraison;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public String getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	public String getStatusLivraison() {
		return statusLivraison;
	}
	public void setStatusLivraison(String statusLivraison) {
		this.statusLivraison = statusLivraison;
	}
	
	
	
	

}
