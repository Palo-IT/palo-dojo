package com.paloit.kata;
import java.util.HashMap;
import java.util.Map;

import com.paloit.kata.model.*;
import com.paloit.kata.services.FactureService;

public class TaxesApp {

	private static final Produit LIVRE= new Book("LIVRE","livre",  false, 12.49F);
	private static final Produit CD_MUSICAL= new Others("CDM","CD musical", false, 14.99F);
	private static final Produit BARRE_CHOCOLAT= new Food("BCH","barres de chocolat",  false, 0.85F);
	private static final Produit BOITE_CHOCO_IMP= new Food("BCHI","bo�tes de chocolats import�s",  true, 10F);
	private static final Produit FLACON_PARFUM_IMP= new Others("FPI","flacons de parfum import�", true, 47.99F);
	private static final Produit FLACON_PARFUM= new Others("FP","flacon de parfum", false,18.99F);
	private static final Produit BOITE_PILLULE_MIG= new Medical("BPM","bo�tes de pilules contre la migraine", false, 9.75F);
	private static final Produit BOITE_CHOCO_IMP_BIS= new Food("BCHI2","bo�tes de chocolats import�s",  true, 11.25F);

	public static void main(String[] args) {
		
		FactureService factureService = FactureService.getInstance();

		Map<Produit, Integer> panier1= new HashMap<>();
		panier1.put(LIVRE, 2);
		panier1.put(CD_MUSICAL,1);
		panier1.put(BARRE_CHOCOLAT, 3);
		
		genererFacture(factureService, panier1);
		
		Map<Produit, Integer> panier2= new HashMap<>();
		panier2.put(BOITE_CHOCO_IMP, 2);
		panier2.put(FLACON_PARFUM_IMP,3);
		genererFacture(factureService, panier2);
		
		Map<Produit, Integer> panier3= new HashMap<>();
		panier3.put(FLACON_PARFUM_IMP,2);
		panier3.put(FLACON_PARFUM, 1);
		panier3.put(BOITE_PILLULE_MIG,3);
		panier3.put(BOITE_CHOCO_IMP_BIS,2);
		genererFacture(factureService, panier3);

		
		
		

		
		
	}

	private static void genererFacture(FactureService factureService, Map<Produit, Integer> panier1) {
		Facture facture1 = factureService.initFacture(panier1);
		factureService.calculerFacture(facture1);
		System.out.println(factureService.afficherfacture(facture1));
	}

}
