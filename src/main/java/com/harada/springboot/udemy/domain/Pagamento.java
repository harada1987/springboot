package com.harada.springboot.udemy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.harada.springboot.udemy.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pagamento extends DefaultDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6705349750297584945L;
	@Id
	private Integer id;
	private Integer estadoPagamento;
	
	@OneToOne
	@JoinColumn(name="idPedido")
	@MapsId
	@JsonIgnore
	private Pedido pedido;

	public Pagamento() {
	}
	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento.getCodigo();
		this.pedido = pedido;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}
	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {		
		this.estadoPagamento = estadoPagamento.getCodigo();
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}