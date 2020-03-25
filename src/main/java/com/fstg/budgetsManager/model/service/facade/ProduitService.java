package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Produit;


public interface ProduitService {
	int createProduct(Produit p);
	List<Produit> findByCategory(String libelle);
	Produit findByCodeScanbar(String codeScanBar);

}
