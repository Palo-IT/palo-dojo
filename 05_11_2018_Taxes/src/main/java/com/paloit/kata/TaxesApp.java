package com.paloit.kata;
import java.util.HashMap;
import java.util.Map;

import com.paloit.kata.model.Facture;
import com.paloit.kata.model.Produit;
import com.paloit.kata.model.TypeProduitEnum;
import com.paloit.kata.services.FactureService;

@SuppressWarnings("ALL")
public class TaxesApp {

	private static final Produit LIVRE= new Produit("LIVRE","livre", TypeProduitEnum.BOOK, false, 12.49F);
	private static final Produit CD_MUSICAL= new Produit("CDM","CD musical", TypeProduitEnum.OTHERS, false, 14.99F);
	private static final Produit BARRE_CHOCOLAT= new Produit("BCH","barres de chocolat", TypeProduitEnum.FOOD, false, 0.85F);
	private static final Produit BOITE_CHOCO_IMP= new Produit("BCHI","bo�tes de chocolats import�s", TypeProduitEnum.FOOD, true, 10F);
	private static final Produit FLACON_PARFUM_IMP= new Produit("FPI","flacons de parfum import�", TypeProduitEnum.OTHERS, true, 47.99F);
	private static final Produit FLACON_PARFUM= new Produit("FP","flacon de parfum", TypeProduitEnum.OTHERS, false,18.99F);
	private static final Produit BOITE_PILLULE_MIG= new Produit("BPM","bo�tes de pilules contre la migraine", TypeProduitEnum.MEDICAL, false, 9.75F);
	private static final Produit BOITE_CHOCO_IMP_BIS= new Produit("BCHI2","bo�tes de chocolats import�s", TypeProduitEnum.FOOD, true, 11.25F);

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
