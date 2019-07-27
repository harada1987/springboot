package com.harada.springboot.udemy.domain.enums;

public enum EstadoPagamento {
	PENDENTE (1, "Pendente"),
	QUITADO (2, "Quitado"),
	CANCELADO (3, "Cancelado");
	
	private int codigo;
	private String descricao;
	
	EstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static EstadoPagamento toEnum(int codigo) {
		for(EstadoPagamento tc:EstadoPagamento.values()) {
			if(tc.getCodigo()==codigo) {
				return tc;
			}
		}
		throw new IllegalArgumentException("codigo invalido :"+codigo);
	}
	 
}
