package com.harada.springboot.udemy.domain.enums;

public enum TipoCliente {
	PESSOAFISICA (1, "Pessoa Física"),
	PESSOAJURICA (2, "Pessoa Juridica");
	
	private int codigo;
	private String descricao;
	
	TipoCliente(int codigo, String descricao) {
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
	
	public static TipoCliente toEnum(int codigo) {
		for(TipoCliente tc:TipoCliente.values()) {
			if(tc.getCodigo()==codigo) {
				return tc;
			}
		}
		throw new IllegalArgumentException("codigo invalido :"+codigo);
	}
	 
}
