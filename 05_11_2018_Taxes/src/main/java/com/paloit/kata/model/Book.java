package com.paloit.kata.model;

public class Book extends Produit {

    public Book(String codeProduit, String libelle, float prixUT) {
        super(codeProduit, libelle, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 10f;
    }

}
