package com.fstg.budgetsManager.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.ExpressionBesoinProduit;


@Repository
public interface ExpressionBesoinProduitDao extends JpaRepository<ExpressionBesoinProduit, Long> {

}
