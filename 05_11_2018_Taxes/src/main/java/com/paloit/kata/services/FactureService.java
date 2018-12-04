package com.paloit.kata.services;

import com.paloit.kata.model.Facture;
import com.paloit.kata.model.LigneFacture;
import com.paloit.kata.model.Produit;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class FactureService {

	private static final FactureService INSTANCE = new FactureService();

	private FactureService() {
	}

	public static FactureService getInstance() {
		return INSTANCE;
	}

	Locale locale = new Locale("fr", "FR");
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

	public Facture initFacture(Map<Produit, Integer> panier) {
		Facture facture = new Facture();

		for(Entry<Produit, Integer> entry : panier.entrySet()) {
			LigneFacture ligneFacture = new LigneFacture(entry.getKey(), entry.getValue());
			facture = facture.addLigneFacture(ligneFacture);
		}

		return facture;
	}



	public void calculerFacture(Facture facture) {

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
		builder.append("Montant des taxes : ");
		builder.append(currencyFormatter.format(facture.getMontantTaxe()));
		builder.append("\n");
		builder.append("Total : ");
		builder.append(currencyFormatter.format(facture.getPttc()));
		builder.append("\n");

		return builder.toString();
	}

}
