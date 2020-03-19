package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.ExpressionBesoin;

@Repository
public interface ExpressionBesoinDao extends JpaRepository<ExpressionBesoin, Long> {
	ExpressionBesoin findByTitle(String title);
	List<ExpressionBesoin> findByEntiteAdministrativeLibelle(String libelle);
}
