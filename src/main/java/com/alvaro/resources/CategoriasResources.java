package com.alvaro.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvaro.domain.Categoria;
import com.alvaro.domain.DTO.CategoriaDTO;
import com.alvaro.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResources {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	//ADICIONAR 
	//metodo verboso, horrivel
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria obj){
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//ATUALIZAR
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Categoria obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build();
	} 
	
	//DELETAR
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		service.deletar(id);
	return ResponseEntity.noContent().build();
	}
	
	//BUSCAR TODOS USANDO DTO
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> buscarTodos() {
		
		List<Categoria> aux = service.buscarTodos();
		List<CategoriaDTO> obj = aux.stream().map((obj2) -> (new CategoriaDTO(obj2))).collect(Collectors.toList()); //gamb detected
		
		return ResponseEntity.ok().body(obj);
	}
	
	//BUSCAR TODOS USANDO PAGINAÇÃO
	@RequestMapping(value = "/pages",method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> buscarPage(
			@RequestParam(name = "p", defaultValue = "0") Integer page, 
			@RequestParam(name = "l", defaultValue = "24") Integer lines, 
			@RequestParam(name = "o", defaultValue = "nome") String orderBy, 
			@RequestParam(name = "d", defaultValue = "ASC") String direction){
		
		Page<Categoria> pageAll = service.buscarPage(page, lines, orderBy, direction);
		Page<CategoriaDTO> list = pageAll.map(obj -> (new CategoriaDTO(obj)));
		
		return ResponseEntity.ok().body(list);
	}
	
	// só para nivel de curiosidade, sem usar dto
	@RequestMapping(value = "Maps",method = RequestMethod.GET)
	public ResponseEntity<?> buscarTodos2() {
		
		List<Categoria> objAux = service.buscarTodos();
		
		List<Categoria> obj = new ArrayList<>();
		
		for(Categoria x : objAux) {			
			obj.add(new Categoria(x.getId(), x.getNome()));
		}
		
		return ResponseEntity.ok().body(obj);
	}
	
}
