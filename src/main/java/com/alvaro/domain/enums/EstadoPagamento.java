package com.alvaro.domain.enums;

public enum EstadoPagamento {

	quitado(0, "Quitado"),
	pendente(1, "Pendente"),
	cancelado(-1, "Cancelado");
	
	private int estado;
	private String descricao;
	
	private EstadoPagamento() {}

	private EstadoPagamento(int estado, String descricao) {
		this.estado = estado;
		this.descricao = descricao;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null)
			return null;
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getEstado()))
				return x;
		}
		
		throw new IllegalArgumentException("Cod inválido "+cod);
	}
	
}
