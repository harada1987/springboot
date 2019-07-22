package com.harada.springboot.udemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harada.springboot.udemy.domain.Categoria;
import com.harada.springboot.udemy.repositories.CategoriaRepository;
import com.harada.springboot.udemy.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	public List<Categoria> buscar() {
		return repository.findAll();
	}
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Categoria nao encontrada para id '"+id+"' "));
	}
}
