package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Personnel;



@Repository
public interface PersonnelDao extends JpaRepository<Personnel, Long> {

	Personnel findByCin(String cin);
	
	List<Personnel> findByEchelonLibelle (String libelle);
     List<Personnel> findByEntiteAdmLibelle(String libelle);

	
	@Query( "SELECT p FROM Personnel p WHERE p.salaire >:valeur ")
	 List<Personnel> findGrandSalaire(@Param(value = "valeur") double valeur);

	@Query("SELECT p FROM Personnel p WHERE p.salaire <:valeur ")
      List<Personnel> findPetitSalaire(@Param(value = "valeur") double valeur);

}

