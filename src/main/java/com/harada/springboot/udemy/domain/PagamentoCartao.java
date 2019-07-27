package com.harada.springboot.udemy.domain;

import javax.persistence.Entity;

import com.harada.springboot.udemy.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6705349750297584945L;
	private Integer numeroParcelas;
	public PagamentoCartao() {
	}
	public PagamentoCartao(Pedido pedido, EstadoPagamento estadoPagamento, Integer numeroParcelas) {
		super(null,estadoPagamento,pedido);
		this.numeroParcelas = numeroParcelas;
	}
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
}
