package com.harada.springboot.udemy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ItemPedido extends DefaultDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6705349750297584945L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	@ManyToOne
	@JoinColumn(name="idPedido")
	@JsonManagedReference
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name="idProduto")
	@JsonManagedReference
	private Produto produto;
	public ItemPedido() {
	}
	public ItemPedido(Integer id, Double desconto, Integer quantidade, Double preco, Pedido pedido, Produto produto) {
		super();
		this.id = id;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.pedido = pedido;
		this.produto = produto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
