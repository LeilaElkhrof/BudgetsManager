package com.fstg.budgetsManager.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.Produit;


@Repository
public interface ProduitDao extends JpaRepository<Produit, Long>{
	Produit findByCodeScanbar(String codeScanBar);
	List<Produit> findByCatLibelle(String libelle);
}
