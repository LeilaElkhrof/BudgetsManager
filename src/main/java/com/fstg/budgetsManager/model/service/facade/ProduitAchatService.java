package com.fstg.budgetsManager.model.service.facade;

import java.util.Date;
import java.util.List;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.ProduitAchat;

public interface ProduitAchatService {
	public List<ProduitAchat> findByAchatDateAchat(Date dateAchat);

	public List<ProduitAchat> findByAchatCode(String code);
	public List<ProduitAchat> findByProduitCodeScanbar(String codeScanbar);

	public int save(Achat achat, List<ProduitAchat> produitAchats);

//	boolean ValidateProduit(Achat achat, List<ProduitAchat> produitAchats);



	public int deleteByProduitCodeScanbar(String codeScanbar);

}
