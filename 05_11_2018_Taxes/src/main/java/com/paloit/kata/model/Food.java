package com.paloit.kata.model;

public class Food extends Produit {
    public Food(String codeProduit, String libelle,  boolean importe, float prixUT) {
        super(codeProduit, libelle, importe, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 0f;
    }
}
