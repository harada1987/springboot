package com.harada.springboot.udemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.harada.springboot.udemy.domain.Categoria;
import com.harada.springboot.udemy.domain.Cidade;
import com.harada.springboot.udemy.domain.Cliente;
import com.harada.springboot.udemy.domain.Endereco;
import com.harada.springboot.udemy.domain.Estado;
import com.harada.springboot.udemy.domain.ItemPedido;
import com.harada.springboot.udemy.domain.Pagamento;
import com.harada.springboot.udemy.domain.PagamentoBoleto;
import com.harada.springboot.udemy.domain.PagamentoCartao;
import com.harada.springboot.udemy.domain.Pedido;
import com.harada.springboot.udemy.domain.Produto;
import com.harada.springboot.udemy.domain.enums.EstadoPagamento;
import com.harada.springboot.udemy.domain.enums.TipoCliente;
import com.harada.springboot.udemy.repositories.CategoriaRepository;
import com.harada.springboot.udemy.repositories.CidadeRepository;
import com.harada.springboot.udemy.repositories.ClienteRepository;
import com.harada.springboot.udemy.repositories.EnderecoRepository;
import com.harada.springboot.udemy.repositories.EstadoRepository;
import com.harada.springboot.udemy.repositories.ItemPedidoRepository;
import com.harada.springboot.udemy.repositories.PagamentoRepository;
import com.harada.springboot.udemy.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private PagamentoRepository pagamentoRepo;
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;
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
		
		Cliente cli1 = new Cliente(null, "Joao", "jao@teste", "00000000191", TipoCliente.PESSOAFISICA);
		cli1.setTelefones(new LinkedHashSet<String>());
		cli1.getTelefones().addAll(Arrays.asList("912341234","943214321"));
		
		Endereco end1 = new Endereco(null,"1","","Terceira divisão","01234-123",c1,cli1);
		Endereco end2 = new Endereco(null,"1","","Rola cabocla","01424-123",c1,cli1);
		
		cli1.setEnderecos(new ArrayList<Endereco>());
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		Pedido ped1 = new Pedido(null, new Date(), cli1, end1 );
		Pedido ped2 = new Pedido(null, new Date(), cli1, end2 );
		
		Pagamento pgto1 = new PagamentoBoleto(ped1, EstadoPagamento.QUITADO, new Date(), new Date());
		Pagamento pgto2 = new PagamentoCartao(ped2, EstadoPagamento.PENDENTE, 12);
		
		ped1.setPagamento(pgto1);
		ped2.setPagamento(pgto2);
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,10.0, 3, 100.0);
		ItemPedido ip2 = new ItemPedido(ped2,p2,10.0, 3, 100.0);
		
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepo.saveAll(Arrays.asList(e1,e2));
		cidadeRepo.saveAll(Arrays.asList(c1,c2,c3,c4));
		clienteRepo.saveAll(Arrays.asList(cli1));
		enderecoRepo.saveAll(Arrays.asList(end1,end2));
		
		pedidoRepo.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepo.saveAll(Arrays.asList(pgto1,pgto2));
		itemPedidoRepo.saveAll(Arrays.asList(ip1,ip2));
	}

}
