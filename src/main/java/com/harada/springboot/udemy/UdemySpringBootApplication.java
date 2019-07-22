package com.harada.springboot.udemy;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harada.springboot.udemy.domain.Categoria;
import com.harada.springboot.udemy.domain.Cidade;
import com.harada.springboot.udemy.domain.Estado;
import com.harada.springboot.udemy.domain.Produto;
import com.harada.springboot.udemy.repositories.CategoriaRepository;
import com.harada.springboot.udemy.repositories.CidadeRepository;
import com.harada.springboot.udemy.repositories.EstadoRepository;
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
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired
	private EstadoRepository estadoRepo;
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
		
		Estado e1 = new Estado(null,"São Paulo");
		Estado e2 = new Estado(null, "Paraná");
		
		Cidade c1 = new Cidade(null, "São Paulo", e1);
		Cidade c2 = new Cidade(null, "Curitiba", e2);
		Cidade c3 = new Cidade(null, "Santos", e1);
		Cidade c4 = new Cidade(null, "Maringá", e2);
		
		e1.setCidades(new ArrayList<Cidade>());
		e1.getCidades().addAll(Arrays.asList(c1,c3));

		e2.setCidades(new ArrayList<Cidade>());
		e2.getCidades().addAll(Arrays.asList(c2,c4));
		
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepo.saveAll(Arrays.asList(e1,e2));
		cidadeRepo.saveAll(Arrays.asList(c1,c2,c3,c4));
	
	}

}
