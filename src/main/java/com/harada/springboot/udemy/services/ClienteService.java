package com.harada.springboot.udemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harada.springboot.udemy.domain.Cliente;
import com.harada.springboot.udemy.repositories.ClienteRepository;
import com.harada.springboot.udemy.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	public List<Cliente> buscar() {
		return repository.findAll();
	}
	public Cliente buscar(Integer id) {
		Optional<Cliente> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Cliente nao encontrado para id '"+id+"' "));
	}
}
