package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Achat;
import com.fstg.budgetsManager.bean.AchatBudgetEntite;

public interface AchatBudgetEntiteService {
	public List<AchatBudgetEntite> findByBudgetEntiteReference(String reference);
	public int save(Achat achat, List<AchatBudgetEntite> achatBudgetEntites);
	public List<AchatBudgetEntite> findByAchatCode(String code);
}
