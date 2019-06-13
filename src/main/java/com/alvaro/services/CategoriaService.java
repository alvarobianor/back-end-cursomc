package com.alvaro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.DAO.CategoriaDAO;
import com.alvaro.domain.Categoria;
import com.alvaro.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	// vair instanciar na hora msm que a classe
	@Autowired
	private CategoriaDAO Dao;

	// na versao 2.x.x.release o spring só usa java 8+, então tem que ser criado
	// essa classe container Optnal para lidar com
	// acesso ao banco
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = Dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria cat) {
		cat.setId(null);
		return Dao.save(cat);
	}

}
