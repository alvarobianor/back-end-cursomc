package com.alvaro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alvaro.DAO.CategoriaDAO;
import com.alvaro.DAO.ProdutoDAO;
import com.alvaro.domain.Categoria;
import com.alvaro.domain.Produto;

@SpringBootApplication
public class Teste1Application implements CommandLineRunner{

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	public static void main(String[] args){
		SpringApplication.run(Teste1Application.class, args);
	}

	// na hora de criar a aplicação ele viai instanciar as categorias automaticamente
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Sexshop");
		Categoria cat2 = new Categoria(null, "Fantasias");
		
		Produto p1 =  new Produto(null, "vibrador", 40.00);
		Produto p2 =  new Produto(null, "Conta Premium Xvideos", 60.00);
		Produto p3 =  new Produto(null, "Roupa do Batman", 40.00);
		
		
		cat1.getProduto().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProduto().addAll(Arrays.asList(p2));

		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1, cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));

		
		categoriaDAO.saveAll(Arrays.asList(cat1, cat2));
		produtoDAO.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
