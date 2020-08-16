package com.harada.springboot.udemy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.harada.springboot.udemy.domain.Categoria;
import com.harada.springboot.udemy.repositories.CategoriaRepository;
import com.harada.springboot.udemy.services.exception.DataIntegrityException;
import com.harada.springboot.udemy.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	public List<Categoria> buscar() {
		return repository.findAll();
	}
	public Categoria buscar(Integer id) {
		Optional<Categoria> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Categoria nao encontrada para id '"+id+"' "));
	}
	public Categoria salvar(Categoria categoria) {
		return repository.save(categoria);
	}
	public void excluir(Integer id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao e possivel excluir uma categoria que possui produtos",e);
		}
	}
}
