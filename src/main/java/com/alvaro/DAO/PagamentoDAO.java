package com.alvaro.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvaro.domain.Pagamento;


//MDSSSSS usar essa interface do Jpa é top, desse jeito el já permite usar para um CRUD cmpleto no banco de dados
@Repository
public interface PagamentoDAO extends JpaRepository<Pagamento, Integer> {

}
