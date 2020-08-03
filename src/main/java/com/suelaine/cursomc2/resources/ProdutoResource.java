package com.suelaine.cursomc2.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.domain.Produto;

import com.suelaine.cursomc2.resources.utils.URL;
import com.suelaine.cursomc2.services.ProdutoService;





import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.services.CategoriaService;


@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
//	@RequestMapping(value="/{id}",method=RequestMethod.GET)
//	public ResponseEntity<?> find(@PathVariable Integer id) {
//		// ResponseEntity ENCAPSULA VARTIAD INFORMAÇÕES PARA UM RSERVIÇO REST
//		Optional<Produto> obj = Optional.ofNullable(service.find(id));
////		Categoria cat1 = new Categoria(1,"Informática");
////		Categoria cat2 = new Categoria(2,"Escritório");
////
////		List<Categoria> lista = new ArrayList<>();
////		lista.add(cat1);
////		lista.add(cat2);
//		
//		
//		return ResponseEntity.ok().body(obj);
//	}
//	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<Page<ProdutoDTO>> findPage(
//			@RequestParam(value="nome", defaultValue="") String nome, 
//			@RequestParam(value="categorias", defaultValue="") String categorias, 
//			@RequestParam(value="page", defaultValue="0") Integer page, 
//			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
//			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
//			@RequestParam(value="direction", defaultValue="ASC") String direction) {
//		String nomeDecoded = URL.decodeParam(nome);
//		List<Integer> ids = URL.decodeIntList(categorias);
//		Page<Produto> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction)(nomeDecoded, ids, page, linesPerPage, orderBy, direction)(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
//		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));  
//		return ResponseEntity.ok().body(listDto);
//	}

}