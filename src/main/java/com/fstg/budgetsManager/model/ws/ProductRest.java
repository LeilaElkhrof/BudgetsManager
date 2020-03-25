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

import com.fstg.budgetsManager.bean.Produit;
import com.fstg.budgetsManager.model.service.facade.ProduitService;

@RestController
@RequestMapping("products/")
@CrossOrigin(value = "http://localhost:4200",maxAge = 3600)
public class ProductRest{
	
	@Autowired
	private ProduitService ps;

	@PostMapping("")
	public int createProduct(@RequestBody Produit p) {
		return ps.createProduct(p);
	}

	@GetMapping("{scodeScanBar}")
	public Produit getProductByCodeScanBar(@PathVariable String codeScanBar) {
		return ps.findByCodeScanBar(codeScanBar);
	}

	@GetMapping("cat/{libelle}")
	public List<Produit> getProductesByCategory(@PathVariable String libelle) {
		return ps.findByCategory(libelle);
	}
	
	

}
