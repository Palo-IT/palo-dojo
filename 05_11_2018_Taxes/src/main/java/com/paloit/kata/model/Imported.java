package com.paloit.kata.model;

public class Imported extends Produit {
    private final Taxable delegate;

    public Imported(Produit delegate) {
        super(delegate.getCodeProduit(), delegate.getLibelle(), delegate.getPrixUT());
        this.delegate = delegate;
    }

    @Override
    public Float getTaxe() {
        return delegate.getTaxe() + 5f;
    }
}
