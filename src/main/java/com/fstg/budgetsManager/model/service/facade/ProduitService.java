package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Produit;


public interface ProduitService {
	int createProduct(Produit p);
	Produit getProductByCodeScanBar(String codeScanBar);
	List<Produit> getProductesByCategory(String libelle);
	Produit findByCodeScanbar(String codeScanBar);
}
