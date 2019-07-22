package com.harada.springboot.udemy;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harada.springboot.udemy.domain.Categoria;
import com.harada.springboot.udemy.domain.Produto;
import com.harada.springboot.udemy.repositories.CategoriaRepository;
import com.harada.springboot.udemy.repositories.ProdutoRepository;

@SpringBootApplication
public class UdemySpringBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UdemySpringBootApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	public void run(String... args) throws Exception{
		Categoria cat1 = new Categoria(null,"Tipo manolo");
		Categoria cat2 = new Categoria(null,"Tipo madame");
		
		Produto p1 = new Produto(null, "Produto dahora", 100.0);
		Produto p2 = new Produto(null, "Produto marromeno", 9.99);
		Produto p3 = new Produto(null, "Produto dimarca",1000.0);
		
		p1.setCategorias(new ArrayList<Categoria>());
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.setCategorias(new ArrayList<Categoria>());
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.setCategorias(new ArrayList<Categoria>());
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		cat1.setProdutos(new ArrayList<Produto>());
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		
		cat2.setProdutos(new ArrayList<Produto>());
		cat1.getProdutos().addAll(Arrays.asList(p2,p3));
		
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
	}

}
