package com.fstg.budgetsManager.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.Echelon;
import com.fstg.budgetsManager.bean.Grade;
import com.fstg.budgetsManager.model.dao.EchelonDao;
import com.fstg.budgetsManager.model.service.facade.EchelonService;
import com.fstg.budgetsManager.model.service.facade.GradeService;



@Service
public class EchelonServiceImpl implements EchelonService {

	@Autowired
	EchelonDao echelonRepository;
	
	@Autowired
	GradeService gradeService;

	@Override
	public Echelon findByLibelle(String libelle) {

		return echelonRepository.findByLibelle(libelle);
	}


	@Override
	public List<Echelon> findAll() {

		return echelonRepository.findAll();
	}
	
	
	@Override
	public List<Echelon> findByGradeLibelle(String libelle) {
	
		return echelonRepository.findByGradeLibelle(libelle);
	}

	
	
	
	@Override
	public int save(Echelon echelon) {
		Echelon foundedEchelon = findByLibelle(echelon.getLibelle());
		Echelon foundedEchelonPrev = findByLibelle(echelon.getEchelonPrevious().getLibelle());
		Echelon foundedEchelonNext = findByLibelle(echelon.getEchelonNext().getLibelle());
		Grade foundedGrade = gradeService.findByLibelle(echelon.getGrade().getLibelle());

		if (foundedEchelon != null) {
			return -1;
		}

		else if (foundedEchelonNext == null) {
			return -2;
		}
		else if (foundedEchelonPrev == null) {
			return -3;
		}
		else if (foundedGrade == null) {
			return -4;
		}
		else {
			echelon.setEchelonNext(echelon.getEchelonNext());
			echelon.setEchelonPrevious(echelon.getEchelonPrevious());
			echelon.setGrade(foundedGrade);
			echelonRepository.save(echelon);
			return 0;
		}
	}


	@Override
	public Echelon findByNumero(int numero) {
		
		return echelonRepository.findByNumero(numero);
	}
	
	


}

