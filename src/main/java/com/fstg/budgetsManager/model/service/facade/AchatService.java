package com.fstg.budgetsManager.model.service.facade;

import java.util.Date;
import java.util.List;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.ProduitAchat;


public interface AchatService {
	public Achat findByCode(String code);

	public List<Achat> findByDateAchat(Date dateAchat);

	public int deleteByCode(String code);

	public int save(Achat achat, List<ProduitAchat> produitAchats);

	void calculerMontantTotal(Achat achat, List<ProduitAchat> produitAchats);

	public List<Achat> findAll();
}
