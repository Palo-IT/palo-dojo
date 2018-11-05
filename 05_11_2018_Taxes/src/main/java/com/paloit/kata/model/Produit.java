package com.paloit.kata.model;

public class Produit {

	private String codeProduit;
	private String libelle;
	private TypeProduitEnum typeProduit;
	private Boolean importe;
	private Float prixUT;

	
	public Produit(String codeProduit,String libelle, TypeProduitEnum typeProduit, boolean importe, float prixUT) {
		this.codeProduit=codeProduit;
		this.libelle = libelle;
		this.typeProduit = typeProduit;
		this.importe = importe;
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

	public TypeProduitEnum getTypeProduit() {
		return typeProduit;
	}

	public void setTypeProduit(TypeProduitEnum typeProduit) {
		this.typeProduit = typeProduit;
	}

	public Boolean isImporte() {
		return importe;
	}

	public void setImporte(boolean importe) {
		this.importe = importe;
	}

	public Float getPrixUT() {
		return prixUT;
	}

	public void setPrixUT(float prixUT) {
		this.prixUT = prixUT;
	}
}
