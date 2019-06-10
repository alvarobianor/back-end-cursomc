package com.alvaro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.DAO.ProdutoDAO;
import com.alvaro.domain.Produto;
import com.alvaro.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	// vair instanciar na hora msm que a classe
	@Autowired
	private ProdutoDAO Dao;

	// na versao 2.x.x.release o spring só usa java 8+, então tem que ser criado
	// essa classe container Optnal para lidar com
	// acesso ao banco
	public Produto buscar(Integer id) {
		Optional<Produto> obj = Dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

}
