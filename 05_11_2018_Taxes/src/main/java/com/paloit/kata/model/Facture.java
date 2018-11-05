package com.paloit.kata.model;

import java.util.ArrayList;
import java.util.List;

public class Facture {

	private List<LigneFacture> ligneFactures;
	private Float pttc;
	private Float montantTaxe;

	public List<LigneFacture> getLigneFactures() {
		return ligneFactures;
	}

	public void setLigneFactures(List<LigneFacture> ligneFactures) {
		this.ligneFactures = ligneFactures;
	}

	public Float getPttc() {
		return pttc;
	}

	public void setPttc(float pttc) {
		this.pttc = pttc;
	}

	public Float getMontantTaxe() {
		return montantTaxe;
	}

	public void setMontantTaxe(float montantTaxe) {
		this.montantTaxe = montantTaxe;
	}

}
