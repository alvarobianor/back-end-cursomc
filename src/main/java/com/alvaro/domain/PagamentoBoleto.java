package com.alvaro.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.alvaro.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoBoleto extends Pagamento{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/aaaa || HH:mm:SS")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/aaaa || HH:mm:SS")
	private Date dataPagamento;
	public PagamentoBoleto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		// TODO Auto-generated constructor stub
		this.dataPagamento = dataPagamento;
		this.dataVencimento =  dataVencimento;
	}
	
	
}
