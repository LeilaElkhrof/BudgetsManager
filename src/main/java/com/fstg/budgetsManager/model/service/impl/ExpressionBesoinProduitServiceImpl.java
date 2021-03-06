package com.fstg.budgetsManager.model.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fstg.budgetsManager.bean.ExpressionBesoin;
import com.fstg.budgetsManager.bean.ExpressionBesoinProduit;
import com.fstg.budgetsManager.bean.Produit;
import com.fstg.budgetsManager.model.dao.ExpressionBesoinProduitDao;
import com.fstg.budgetsManager.model.service.facade.ExpressionBesoinProduitService;
import com.fstg.budgetsManager.model.service.facade.ProduitService;


@Service
public class ExpressionBesoinProduitServiceImpl implements ExpressionBesoinProduitService {
	@Autowired
	private ExpressionBesoinProduitDao expBsProDao;

	@Autowired
	private ProduitService ps;


	@Override
	public void valideAndsaveEBP(List<ExpressionBesoinProduit> exbProduit,ExpressionBesoin eb) {
		Iterator<ExpressionBesoinProduit> itr = exbProduit.iterator();
		while (itr.hasNext()) {
			ExpressionBesoinProduit expBP = itr.next();
			
			/*Associated Product*/
			Produit pBD = ps.findByCodeScanbar(expBP.getProduit().getCodeScanbar());
			
			//Product Exist
			if (pBD != null)
				expBP.setProduit(pBD);
				expBP.setEb(eb);
				expBsProDao.save(expBP);
			
		}
	}

	@Override
	public List<ExpressionBesoinProduit> findByEbId(Long ebID) {
		return expBsProDao.findByEbId(ebID);
	}

	@Override
	public int deleteByEbId(Long id) {
		expBsProDao.deleteByEbId(id);
		return 1;
				
	}



}
