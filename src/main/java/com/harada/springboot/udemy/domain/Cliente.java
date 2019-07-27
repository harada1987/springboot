package com.harada.springboot.udemy.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.harada.springboot.udemy.domain.enums.TipoCliente;

@Entity
public class Cliente extends DefaultDomain  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4394328627559193521L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfCnpj;
	private Integer tipoCliente;
	@OneToMany(mappedBy="cliente")
	@JsonManagedReference
	private List<Endereco> enderecos;
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones;
	@OneToMany(mappedBy="cliente")
	@JsonManagedReference
	private List<Pedido> pedidos;
	public Cliente() {	
	}
	public Cliente(Integer id, String nome, String email, String cpfCnpj, TipoCliente tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = tipoCliente.getCodigo();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCodigo();
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
}
