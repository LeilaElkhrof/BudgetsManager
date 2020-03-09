package com.fstg.budgetsManager.model.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.EntiteAdministrative;

@Repository
public interface EntiteAdministrativeDao extends JpaRepository<EntiteAdministrative, Long> {
	
	public EntiteAdministrative findByLibelle(String libelle);

}
