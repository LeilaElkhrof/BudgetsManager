package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.ExpressionBesoin;
import com.fstg.budgetsManager.bean.ExpressionBesoinProduit;

public interface ExpressionBesoinProduitService {
	void valideAndsaveEBP(List<ExpressionBesoinProduit> ebpS,ExpressionBesoin eb);
	List<ExpressionBesoinProduit> findByEbId(Long ebID);
	int deleteByEbId(Long id);

}
