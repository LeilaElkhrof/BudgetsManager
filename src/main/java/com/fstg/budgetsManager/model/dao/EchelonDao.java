package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Echelon;



@Repository
public interface EchelonDao extends JpaRepository<Echelon, Long> {

	 Echelon findByLibelle(String libelle);
	
	 List<Echelon> findByGradeLibelle(String libelle);
	 
	 Echelon findByNumero(int numero);
	
 
}
