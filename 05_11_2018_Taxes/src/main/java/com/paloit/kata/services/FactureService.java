package com.paloit.kata.services;

import com.paloit.kata.model.Facture;
import com.paloit.kata.model.LigneFacture;
import com.paloit.kata.model.Produit;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("ALL")
public class FactureService {

    private static final FactureService INSTANCE = new FactureService();
    Locale locale = new Locale("fr", "FR");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    public FactureService() {
    }

    public static FactureService getInstance() {
        return INSTANCE;
    }

    public Facture initFacture(Map<Produit, Integer> panier) {
        Facture facture = new Facture();
        panier.keySet().stream().forEach(key -> {
            LigneFacture ligneFacture = new LigneFacture(key, panier.get(key));
            facture.getLigneFactures().add(ligneFacture);
        });
        return facture;
    }

    public int getTaxe(Produit produit) {
        int taxe = 0;
        switch (produit.getTypeProduit()) {
            case BOOK:
                taxe = 10;
                break;

            case MEDICAL:
                taxe = 0;
                break;
            case FOOD:
                taxe = 0;
                break;
            case OTHERS:
                taxe = 20;
                break;
            default:
                throw new UnsupportedOperationException("Type de produit est inconnu");
        }

        if (produit.isImporte()) {
            taxe += 5;
        }
        return taxe;
    }

    public void calculerFacture(Facture facture) {
        facture.getLigneFactures().stream().forEach(ligneFacture -> {

            float prixHT = ligneFacture.getQuantite() * ligneFacture.getProduit().getPrixUT();
            float montantTaxe = Math.round(getTaxe(ligneFacture.getProduit()) * prixHT / 100);
            float prixTTC = prixHT + montantTaxe;
            ligneFacture.setPrixHT(prixHT);
            ligneFacture.setPrixTTC(prixTTC);

            facture.setMontantTaxe(facture.getMontantTaxe() + montantTaxe);
            facture.setPttc(facture.getPttc() + prixTTC);

        });

    }

    public String afficherfacture(Facture facture) {
        StringBuilder builder = new StringBuilder();

        facture.getLigneFactures().stream().forEach(ligne -> {
            builder.append("* ");
            builder.append(ligne.getQuantite());
            builder.append(" ");
            builder.append(ligne.getProduit().getLibelle());
            builder.append(" � ");
            builder.append(currencyFormatter.format(ligne.getProduit().getPrixUT()));
            builder.append(" : ");
            builder.append(currencyFormatter.format(ligne.getPrixTTC()));
            builder.append(" TTC");
            builder.append("\n");
        });

        builder.append("\n");
        builder.append("Montant des taxes : " + currencyFormatter.format(facture.getMontantTaxe()));
        builder.append("\n");
        builder.append("Total : " + currencyFormatter.format(facture.getPttc()));
        builder.append("\n");

        return builder.toString();
    }

}
