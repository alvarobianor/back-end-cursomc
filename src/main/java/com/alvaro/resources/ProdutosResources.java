package com.alvaro.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.domain.Produto;
import com.alvaro.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosResources {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		
		Produto obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
