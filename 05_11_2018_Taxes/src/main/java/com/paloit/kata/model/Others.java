package com.paloit.kata.model;

public class Others extends Produit {
    public Others(String codeProduit, String libelle, boolean importe, float prixUT) {
        super(codeProduit, libelle, importe, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 20f;
    }
}
