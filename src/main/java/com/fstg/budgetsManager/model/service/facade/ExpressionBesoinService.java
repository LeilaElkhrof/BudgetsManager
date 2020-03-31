package com.fstg.budgetsManager.model.service.facade;

import java.util.Date;
import java.util.List;
import com.fstg.budgetsManager.bean.ExpressionBesoin;


public interface ExpressionBesoinService {

	int saveEb(ExpressionBesoin expb);
	int updateEb(ExpressionBesoin expb);
	int deleteById(Long id);
	
	List<ExpressionBesoin> getAllExpB();
	List<ExpressionBesoin> getByEntiteAdministrativeLibelle(String libelle);
	List<ExpressionBesoin> getByPersonnelCin(String cin);
	List<ExpressionBesoin> getBySaveDate(Date saveDate);
	
}
