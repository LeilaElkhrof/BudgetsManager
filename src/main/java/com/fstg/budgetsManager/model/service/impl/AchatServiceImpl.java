package com.fstg.budgetsManager.model.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.AchatBudgetEntite;
import com.fstg.budgetsManager.bean.BudgetEntite;
import com.fstg.budgetsManager.bean.Produit;
import com.fstg.budgetsManager.bean.ProduitAchat;
import com.fstg.budgetsManager.model.dao.AchatDao;
import com.fstg.budgetsManager.model.service.facade.AchatBudgetEntiteService;
import com.fstg.budgetsManager.model.service.facade.AchatService;
import com.fstg.budgetsManager.model.service.facade.BudgetEntiteService;
import com.fstg.budgetsManager.model.service.facade.ProduitAchatService;
import com.fstg.budgetsManager.model.service.facade.ProduitService;


@Service
public class AchatServiceImpl implements AchatService {
	@Autowired
	private AchatDao achatDao;
	@Autowired
	private ProduitAchatService produitAchatService;
	@Autowired
	private AchatBudgetEntiteService achatBudgetEntiteService;

	@Override
	public Achat findByCode(String code) {
		return achatDao.findByCode(code);
	}

	@Override
	public List<Achat> findByDateAchat(Date dateAchat) {
		return achatDao.findByDateAchat(dateAchat);
	}

	@Override
	@Transactional
	public int deleteByCode(String code) {
		int del1 = achatDao.deleteByCode(code);
		return del1;
	}

	@Override
	public int save(Achat achat, List<ProduitAchat> produitAchats, List<AchatBudgetEntite> achatBudgetEntites) {
		Achat achatFound = findByCode(achat.getCode());
		if (achatFound != null) {
			return -1;
//		} else if (!produitAchatService.ValidateProduit(achat, produitAchats)) {
//			return -2;
		} else {
			achat.setDateAchat(new Date());
			calculerMontantTotal( achat, produitAchats,achatBudgetEntites);
			achatDao.save(achat);
			achatBudgetEntiteService.save(achat, achatBudgetEntites);
			produitAchatService.save(achat, produitAchats);
			return 1;
		}

	}

	public void calculerMontantTotal(Achat achat, List<ProduitAchat> produitAchats, List<AchatBudgetEntite> achatBudgetEntites) {
		double montantTotal=0;
		for (ProduitAchat produitAchat : produitAchats) {
			montantTotal+=produitAchat.getQuantite()*produitAchat.getProduit().getPrice();
			
		/*for (AchatBudgetEntite achatBudgetEntite : achatBudgetEntites) {
			double montantInv=achatBudgetEntite.getBudgetEntite().getMontantInv();
			if(montantInv>montantTotal) {
				montantInv-=montantTotal;
			}
		}*/
		}
		
		achat.setMontantTotal(montantTotal);
	}

	@Override
	public List<Achat> findAll() {
		return achatDao.findAll();
	}
	@Override
	public int updateAchat(Achat achat, List<ProduitAchat> produitAchats, List<AchatBudgetEntite> achatBudgetEntites) {
			achat.setDateAchat(new Date());
			calculerMontantTotal( achat, produitAchats,achatBudgetEntites);
			achatDao.save(achat);
			achatBudgetEntiteService.save(achat, achatBudgetEntites);
			produitAchatService.save(achat, produitAchats);
			return 1;
		

	}


 
}
