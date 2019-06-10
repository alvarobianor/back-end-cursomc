package com.alvaro.domain;

import javax.persistence.Entity;

import com.alvaro.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	private Integer numeroParcelas;

	public PagamentoCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.setNumeroParcelas(numeroParcelas);
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
