package com.fstg.budgetsManager.model.service.facade;

import java.util.List;

import com.fstg.budgetsManager.bean.Grade;



public interface GradeService {
	public Grade findByLibelle(String libelle);

	public int save(Grade grade);

	public List<Grade> findAll();

}