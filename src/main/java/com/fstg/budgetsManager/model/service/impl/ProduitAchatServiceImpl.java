package com.fstg.budgetsManager.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.Produit;
import com.fstg.budgetsManager.bean.ProduitAchat;
import com.fstg.budgetsManager.model.dao.ProduitAchatDao;
import com.fstg.budgetsManager.model.service.facade.AchatService;
import com.fstg.budgetsManager.model.service.facade.ProduitAchatService;
import com.fstg.budgetsManager.model.service.facade.ProduitService;


@Service
public class ProduitAchatServiceImpl implements ProduitAchatService {
	@Autowired
	private ProduitAchatDao produitAchatDao;
	@Autowired
	private ProduitService produitService;
	@Autowired
	private AchatService achatService;

	@Override
	public List<ProduitAchat> findByAchatDateAchat(Date dateAchat) {
		return produitAchatDao.findByAchatDateAchat(dateAchat);
	}

	@Override
	public List<ProduitAchat> findByAchatCode(String code) {
		return produitAchatDao.findByAchatCode(code);
	}

	@Override
	public int save(Achat achat, List<ProduitAchat> produitAchats) {
			for (ProduitAchat produitAchat : produitAchats) {
				Produit produit = produitService.findByCodeScanbar(produitAchat.getProduit().getCodeScanbar());
				produitAchat.setProduit(produit);
				produitAchat.setAchat(achat);
				produitAchatDao.save(produitAchat);
				
			}
			return 1;

	}

//	@Override
//	public boolean ValidateProduit(Achat achat, List<ProduitAchat> produitAchats) {
//		List<ProduitAchat> produitValider = new ArrayList<ProduitAchat>();
//		for (ProduitAchat produitAchat : produitAchats) {
//			if (produitService.findByCodeScanbar(produitAchat.getProduit().getCodeScanbar()) != null) {
//				produitValider.add(produitAchat);
//			}
//		}
//		return produitValider.size() == produitAchats.size();
//	}


	@Override
	@Transactional
	public int deleteByProduitCodeScanbar(String codeScanbar) {
		int delProduit = produitAchatDao.deleteByProduitCodeScanbar(codeScanbar);
		return delProduit;
	}

	@Override
	public List<ProduitAchat> findByProduitCodeScanbar(String codeScanbar) {
		return produitAchatDao.findByProduitCodeScanbar(codeScanbar);
	}
	
		
}
