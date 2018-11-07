package com.paloit.kata.model;

public class Others extends Produit {
    public Others(String codeProduit, String libelle, float prixUT) {
        super(codeProduit, libelle, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 20f;
    }
}
