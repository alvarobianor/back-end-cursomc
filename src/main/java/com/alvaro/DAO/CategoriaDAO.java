package com.alvaro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvaro.domain.Categoria;


//MDSSSSS usar essa interface do Jpa é top
@Repository
public interface CategoriaDAO extends JpaRepository<Categoria, Integer> {

}
