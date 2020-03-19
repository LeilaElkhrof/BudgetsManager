package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.ExpressionBesoin;
import com.fstg.budgetsManager.bean.ExpressionBesoinProduit;

public interface ExpressionBesoinProduitService {
	public int createExpBsproduit(List<ExpressionBesoinProduit> ebpS);
	public void valideAndsaveEBP(List<ExpressionBesoinProduit> ebpS,ExpressionBesoin eb);
}
