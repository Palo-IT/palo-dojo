package com.paloit.kata.model;

public class Food extends Produit {
    public Food(String codeProduit, String libelle, float prixUT) {
        super(codeProduit, libelle, prixUT);
    }

    @Override
    public Float getTaxe() {
        return 0f;
    }
}
