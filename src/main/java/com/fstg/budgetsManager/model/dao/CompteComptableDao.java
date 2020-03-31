package com.fstg.budgetsManager.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.CompteComptable;



@Repository
public interface CompteComptableDao extends JpaRepository<CompteComptable, Long>{
	public CompteComptable findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
