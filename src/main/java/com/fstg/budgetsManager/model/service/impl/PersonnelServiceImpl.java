package com.fstg.budgetsManager.model.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fstg.budgetsManager.bean.Echelon;
import com.fstg.budgetsManager.bean.EntiteAdministrative;
import com.fstg.budgetsManager.bean.Personnel;
import com.fstg.budgetsManager.model.dao.PersonnelDao;
import com.fstg.budgetsManager.model.service.facade.EchelonService;
import com.fstg.budgetsManager.model.service.facade.EntiteAdmService;
import com.fstg.budgetsManager.model.service.facade.PersonnelService;
import com.fstg.budgetsManager.model.util.DateUtill;




@Service
public class PersonnelServiceImpl implements PersonnelService {

	@Autowired
	PersonnelDao personnelRepository;
	
	@Autowired
	EchelonService echelonService;
	
	@Autowired
	EntiteAdmService entiteAdmService;
	

	@Override
	public Personnel findByCin(String cin) {

		return personnelRepository.findByCin(cin);
	}

	@Override
	public List<Personnel> findAll() {

		return personnelRepository.findAll();
	}

	@Override
	public int save(Personnel personnel) {
		Personnel foundedPersonnel = findByCin(personnel.getCin());
		Echelon foundedEchelon = echelonService.findByLibelle(personnel.getEchelon().getLibelle());
		//Echelon foundedEchelonPrevious = echelonService.findByLibelle(personne.getEchelon().get);
		EntiteAdministrative foundedEntite = entiteAdmService.findByLibelle(personnel.getEntiteAdm().getLibelle());
		if (foundedPersonnel != null) {
			return -1;
		}
		else if(foundedEchelon == null){
			return -2;
		}
		if(foundedEntite == null) {
			return -3;
		}
			
		else
		{
			personnel.setEchelon(foundedEchelon);
				personnelRepository.save(personnel);
		return 1;
		}
		
	}
	
	
	@Override
	public List<Personnel> findByEntiteAdmLibelle(String libelle) {
		return personnelRepository.findByEntiteAdmLibelle(libelle);
	}

	
	@Override
	public List<Personnel> findByEchelonLibelle(String libelle) {

		return personnelRepository.findByEchelonLibelle(libelle);
	}



	@Override
	public List<Personnel> findGrandSalaire(double valeur) {
	
		return personnelRepository.findGrandSalaire(valeur) ;
	}

	@Override
	public List<Personnel> findPetitSalaire(double valeur) {
	
		return personnelRepository.findPetitSalaire(valeur);
	}
	@Override
	public int transfert(String cin) {

		Personnel foundedPersonne = findByCin(cin);
		
		if(foundedPersonne == null)
		{
			return -1;
		}
		else {
				int mois = DateUtill.getMounthsDifference(new Date(), foundedPersonne.getDateAffectation());
		System.out.println(mois);
		if (mois < foundedPersonne.getEchelon().getEchelonNext().getMinMois()) {
			return -2;
		}

		else {
			
			foundedPersonne.setEchelon(foundedPersonne.getEchelon().getEchelonNext());

			personnelRepository.save(foundedPersonne);

			return 1;
		}
	
		}

	}

	

	 

	 
}

