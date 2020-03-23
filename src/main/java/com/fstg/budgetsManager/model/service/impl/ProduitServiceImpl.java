package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Category;
import com.fstg.budgetsManager.bean.Produit;
import com.fstg.budgetsManager.model.dao.ProduitDao;
import com.fstg.budgetsManager.model.service.facade.CategoryService;
import com.fstg.budgetsManager.model.service.facade.ProduitService;


@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao pDao;
	
	@Autowired
	private CategoryService cs;

	@Override
	public int createProduct(Produit p) {
		Produit produit = getProductByCodeScanBar(p.getCodeScanbar());
		//System.out.println(p.getCat());
		Category catDB=cs.findByLibelle(p.getCat().getLibelle());

		
		if (produit != null || catDB==null) {
			return -1;
		} else {
			p.setCat(catDB);
			pDao.save(p);
			return 1;
		}
	}

	@Override
	public Produit getProductByCodeScanBar(String codeScanBar) {
		return pDao.findByCodeScanbar(codeScanBar);
	}

	@Override
	public List<Produit> getProductesByCategory(String libelle) {
		
		return pDao.findByCatLibelle(libelle);
	}

}
