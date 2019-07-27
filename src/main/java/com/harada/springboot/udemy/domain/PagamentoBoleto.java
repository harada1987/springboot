package com.harada.springboot.udemy.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.harada.springboot.udemy.domain.enums.EstadoPagamento;

@Entity
public class PagamentoBoleto extends Pagamento {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6705349750297584945L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	public PagamentoBoleto() {
	}
	public PagamentoBoleto(Pedido pedido, EstadoPagamento estadoPagamento, Date dataVencimento, Date dataPagamento) {
		super(null,estadoPagamento,pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}
