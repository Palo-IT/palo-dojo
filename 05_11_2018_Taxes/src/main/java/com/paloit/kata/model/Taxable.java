package com.paloit.kata.model;

public interface Taxable {

    Float getTaxe();
    Boolean isImporte();
    default Float getTotalTaxe() {
        return getTaxe() +(isImporte()? 5f  : 0f);
    }
}
