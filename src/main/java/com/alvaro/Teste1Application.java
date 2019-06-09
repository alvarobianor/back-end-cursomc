package com.alvaro;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alvaro.DAO.CategoriaDAO;
import com.alvaro.domain.Categoria;

@SpringBootApplication
public class Teste1Application implements CommandLineRunner{

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	public static void main(String[] args){
		SpringApplication.run(Teste1Application.class, args);
	}

	// na hora de criar a aplicação ele viai instanciar as categorias automaticamente
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "sexshop");
		Categoria cat2 = new Categoria(null, "informatica");
		categoriaDAO.saveAll(Arrays.asList(cat1, cat2));
	}

}
