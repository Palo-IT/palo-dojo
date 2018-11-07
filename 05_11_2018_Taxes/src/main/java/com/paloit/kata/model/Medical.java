package com.paloit.kata.model;

public class Medical extends Produit {
    public Medical(String codeProduit, String libelle, boolean importe, float prixUT) {
        super(codeProduit, libelle, importe, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 0f;
    }
}
