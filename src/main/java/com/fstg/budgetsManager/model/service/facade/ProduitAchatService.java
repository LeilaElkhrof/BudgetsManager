package com.fstg.budgetsManager.model.service.facade;

import java.util.Date;
import java.util.List;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.ProduitAchat;


public interface ProduitAchatService {
	public List<ProduitAchat> findByAchatDateAchat(Date dateAchat);

	public List<ProduitAchat> findByProduitCodeScanbar(String codeScanbar);

	public int save(Achat achat, List<ProduitAchat> produitAchats);

	boolean ValidateProduit(Achat achat, List<ProduitAchat> produitAchats);

	int updateAchat(double quantite, List<ProduitAchat> produitAchats);
}
