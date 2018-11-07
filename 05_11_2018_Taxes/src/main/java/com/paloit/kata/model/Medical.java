package com.paloit.kata.model;

public class Medical extends Produit {
    public Medical(String codeProduit, String libelle, float prixUT) {
        super(codeProduit, libelle, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 0f;
    }
}
