package com.paloit.kata.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

import com.paloit.kata.model.Facture;
import com.paloit.kata.model.LigneFacture;
import com.paloit.kata.model.Produit;

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
		panier.entrySet().forEach(entry -> {
			LigneFacture ligneFacture = new LigneFacture(entry.getKey(), entry.getValue());
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
			float montantTaxe = new BigDecimal(
					getTaxe(ligneFacture.getProduit()) * prixHT / 100)
							.round(new MathContext(3, RoundingMode.HALF_UP)).floatValue();
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
		builder.append("Montant des taxes : ");
		builder.append(currencyFormatter.format(facture.getMontantTaxe()));
		builder.append("\n");
		builder.append("Total : ");
		builder.append(currencyFormatter.format(facture.getPttc()));
		builder.append("\n");

		return builder.toString();
	}

}
