package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Echelon;
import com.fstg.budgetsManager.bean.Responsabilite;

@Repository
public interface ResponsabiliteDao extends JpaRepository<Responsabilite, Long> {
	
	public Responsabilite findByLibelle(String libelle);

	;

}
