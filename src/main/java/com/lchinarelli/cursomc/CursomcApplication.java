package com.lchinarelli.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lchinarelli.cursomc.domain.Categoria;
import com.lchinarelli.cursomc.domain.Cidade;
import com.lchinarelli.cursomc.domain.Cliente;
import com.lchinarelli.cursomc.domain.Endereco;
import com.lchinarelli.cursomc.domain.Estado;
import com.lchinarelli.cursomc.domain.Produto;
import com.lchinarelli.cursomc.domain.enums.TipoCliente;
import com.lchinarelli.cursomc.repositories.CategoriaRepository;
import com.lchinarelli.cursomc.repositories.CidadeRepository;
import com.lchinarelli.cursomc.repositories.ClienteRepository;
import com.lchinarelli.cursomc.repositories.EnderecoRepository;
import com.lchinarelli.cursomc.repositories.EstadoRepository;
import com.lchinarelli.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	     Categoria cat1 = new Categoria(null, "Informática");
	     Categoria cat2 = new Categoria(null,"Escritório");
	     
	     Produto p1 = new Produto(null,"Computador",2000.00);
	     Produto p2 = new Produto(null,"Impressora",800.00);
	     Produto p3 = new Produto(null,"Mouse",80.00);
	     
	     cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
	     cat2.getProdutos().addAll(Arrays.asList(p2));
	     
	     p1.getCategorias().addAll(Arrays.asList(cat1));
	     p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
	     p3.getCategorias().addAll(Arrays.asList(cat1));
	     
	     categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	     produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	     
	     Estado est1 = new Estado(null,"Minas Gerais");
	     Estado est2 = new Estado(null,"São Paulo");
	     
	     Cidade c1 = new Cidade(null, "Uberlândia",est1);
	     Cidade c2 = new Cidade(null, "Campinas", est2);
	     Cidade c3 = new Cidade(null, "São Paulo", est2);
	     
	     est1.getCidades().addAll(Arrays.asList(c1));
	     est2.getCidades().addAll(Arrays.asList(c2, c3));
	     
	     estadoRepository.saveAll(Arrays.asList(est1, est2));
	     cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	     
	     Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "0940183936", TipoCliente.PESSOAFISICA);
	     cli1.getTelefones().addAll(Arrays.asList("4632207876", "4788289829"));
	     
	     Endereco e1 = new Endereco(null, "Rua das Flores", "300", "Apt 101", "Jardim", "21371712", cli1, c1);
	     Endereco e2 = new Endereco(null, "Av. Matos", "283", "Proximo a Floricultura", "Napoleao", "1122345", cli1, c2);
	     
	     cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
	     
	     clienteRepository.saveAll(Arrays.asList(cli1));
	     enderecoRepository.saveAll(Arrays.asList(e1, e2));
	     
	}
	
	
}
