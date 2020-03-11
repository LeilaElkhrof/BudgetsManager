package com.fstg.budgetsManager.model.service.facade;

import java.util.List;
import com.fstg.budgetsManager.bean.ExpressionBesoin;


public interface ExpressionBesoinService {

	public int createExpB(ExpressionBesoin expb);
	public List<ExpressionBesoin> getAllExpB();
	public List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle);
	
}
