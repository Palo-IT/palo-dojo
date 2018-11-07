package com.paloit.kata.model;

public abstract class Produit implements Taxable {

	private String codeProduit;
	private String libelle;
	private Float prixUT;

	
	public Produit(String codeProduit,String libelle, float prixUT) {
		this.codeProduit=codeProduit;
		this.libelle = libelle;
		this.prixUT = prixUT;
	}
	
	public String getCodeProduit() {
		return codeProduit;
	}
	
	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Float getPrixUT() {
		return prixUT;
	}

	public void setPrixUT(float prixUT) {
		this.prixUT = prixUT;
	}
}
