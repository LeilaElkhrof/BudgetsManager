package com.fstg.budgetsManager.model.service.facade;

import java.util.Date;
import java.util.List;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.AchatBudgetEntite;
import com.fstg.budgetsManager.bean.BudgetEntite;
import com.fstg.budgetsManager.bean.ProduitAchat;

public interface AchatService {
	public Achat findByCode(String code);

	public List<Achat> findByDateAchat(Date dateAchat);

	public int deleteByCode(String code);

	public void calculerMontantTotal(Achat achat, List<ProduitAchat> produitAchats, List<AchatBudgetEntite> achatBudgetEntites);

	public List<Achat> findAll();

	int save(Achat achat, List<ProduitAchat> produitAchats, List<AchatBudgetEntite> achatBudgetEntites);

	int updateAchat(Achat achat, List<ProduitAchat> produitAchats, List<AchatBudgetEntite> achatBudgetEntites);
}
