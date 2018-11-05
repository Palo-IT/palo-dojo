package com.paloit.kata.model;

public class Book extends Produit {

    public Book(String codeProduit, String libelle, TypeProduitEnum typeProduit, boolean importe, float prixUT) {
        super(codeProduit, libelle, typeProduit, importe, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 10f;
    }
}
