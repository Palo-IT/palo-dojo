package com.paloit.kata.model;

public class Produit {

    private String codeProduit;
    private String libelle;
    private Boolean importe;
    private Float prixUT;
    private TypeProduitEnum typeProduit;


    public Produit(String codeProduit, String libelle, TypeProduitEnum typeProduit,  boolean importe, float prixUT) {
        this.codeProduit = codeProduit;
        this.libelle = libelle;
        this.importe = importe;
        this.prixUT = prixUT;
        this.typeProduit = typeProduit;
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

    public TypeProduitEnum getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(TypeProduitEnum typeProduit) {
        this.typeProduit = typeProduit;
    }
}
