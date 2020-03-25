package com.fstg.budgetsManager.model.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.budgetsManager.bean.ExpressionBesoin;
import com.fstg.budgetsManager.bean.ExpressionBesoinProduit;
import com.fstg.budgetsManager.model.service.facade.ExpressionBesoinProduitService;
import com.fstg.budgetsManager.model.service.facade.ExpressionBesoinService;


@RestController
@RequestMapping("/ebproduits")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class ExpressionBesoinProduitRest {
	
	@Autowired
	private ExpressionBesoinProduitService ebps;

	@GetMapping("/{ebID}")
	public List<ExpressionBesoinProduit> findByEb(@PathVariable Long ebID) {
		return ebps.findByEbId(ebID);
	}

    
	
	

}
