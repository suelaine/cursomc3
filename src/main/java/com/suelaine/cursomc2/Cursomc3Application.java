package com.suelaine.cursomc2;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.domain.Cidade;
import com.suelaine.cursomc2.domain.Cliente;
import com.suelaine.cursomc2.domain.Endereco;
import com.suelaine.cursomc2.domain.Estado;
import com.suelaine.cursomc2.domain.Produto;
import com.suelaine.cursomc2.domain.enums.TipoCliente;
import com.suelaine.cursomc2.repositories.CategoriaRepository;
import com.suelaine.cursomc2.repositories.CidadeRepository;
import com.suelaine.cursomc2.repositories.ClienteRepository;
import com.suelaine.cursomc2.repositories.EnderecoRepository;
import com.suelaine.cursomc2.repositories.EstadoRepository;
import com.suelaine.cursomc2.repositories.ProdutoRepository;

@SpringBootApplication
public class Cursomc3Application implements CommandLineRunner {

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
		SpringApplication.run(Cursomc3Application.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Artes");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",90.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		
		Cidade c1 = new Cidade(null, "Ouro Preto", est1);
		Cidade c2 = new Cidade(null, "Barbacena", est1);
		Cidade c3 = new Cidade(null, "Búzios", est2);
		Cidade c4 = new Cidade(null, "Paraty", est2);
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		Cliente cli1 =  new Cliente(null, "MAria sILVA", "maria@gmail.com", "06847985645",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("33321540","33326598"));
		
		Endereco e1 =   new Endereco(null, "Rua das flores", "300","apt 09","Jardim", "06847985645",cli1,c1);
		Endereco e2 =   new Endereco(null, "Avenida Campos", "70","Sala 87","Centro", "3247985645",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));

		

	}	

}
