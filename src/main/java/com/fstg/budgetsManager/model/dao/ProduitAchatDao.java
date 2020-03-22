package com.fstg.budgetsManager.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.budgetsManager.bean.ProduitAchat;

@Repository
public interface ProduitAchatDao extends JpaRepository<ProduitAchat, Long> {
	public List<ProduitAchat> findByAchatDateAchat(Date dateAchat);

	public List<ProduitAchat> findByProduitCodeScanbar(String codeScanbar);
}
