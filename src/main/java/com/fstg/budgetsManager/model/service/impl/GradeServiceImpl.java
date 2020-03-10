package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Grade;
import com.fstg.budgetsManager.model.dao.GradeDao;
import com.fstg.budgetsManager.model.service.facade.GradeService;



@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	GradeDao gradeRepository;

	@Override
	public Grade findByLibelle(String libelle) {

		return gradeRepository.findByLibelle(libelle);
	}



	@Override
	public List<Grade> findAll() {
		return gradeRepository.findAll();
	}

	@Override
	public int save(Grade grade) {
		Grade foundedGrade = findByLibelle(grade.getLibelle());
		
		if (foundedGrade != null) {
			return -1;
		} else
			gradeRepository.save(grade);
		return 1;
	}

}