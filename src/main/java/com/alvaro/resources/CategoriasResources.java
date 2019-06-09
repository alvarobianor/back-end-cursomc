package com.alvaro.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResources {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria categoria = new Categoria(1, "Sexshop");
		Categoria categoria2 = new Categoria(2, "Brinquedos");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(categoria);
		lista.add(categoria2);
		
		return lista;
	}
}