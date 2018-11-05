package com.paloit.kata.model;

public class LigneFacture {

	private Produit produit;
	private Integer quantite;
	private Float prixHT;
	private Float prixTTC;
	

	public LigneFacture(Produit produit, int quantite) {
		this.produit = produit;
		this.quantite = quantite;

	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	

	public Float getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(float prixHT) {
		this.prixHT = prixHT;
	}

	public Float getPrixTTC() {
		return prixTTC;
	}

	public void setPrixTTC(float prixTTC) {
		this.prixTTC = prixTTC;
	}

}
