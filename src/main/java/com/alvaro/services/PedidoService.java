package com.alvaro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.DAO.PedidoDAO;
import com.alvaro.domain.Pedido;
import com.alvaro.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	// vair instanciar na hora msm que a classe
	@Autowired
	private PedidoDAO Dao;

	// na versao 2.x.x.release o spring só usa java 8+, então tem que ser criado
	// essa classe container Optnal para lidar com
	// acesso ao banco
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = Dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
