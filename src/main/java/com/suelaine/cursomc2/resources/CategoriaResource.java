package com.suelaine.cursomc2.resources;



import java.net.URI;
import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.services.CategoriaService;

//COMUNICAM OS DADOS COM AS APLICAÇÕES 

@RestController
@RequestMapping(value="/categorias")


public class CategoriaResource {
	
	//@Autowired INSTANCIA AUTOMATICAMENTE
	@Autowired
	private CategoriaService service;
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String ok() {
//		return "REST está funcionando!";
//	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// ResponseEntity ENCAPSULA VARTIAD INFORMAÇÕES PARA UM RSERVIÇO REST
		Optional<Categoria> obj = Optional.ofNullable(service.find(id));
//		Categoria cat1 = new Categoria(1,"Informática");
//		Categoria cat2 = new Categoria(2,"Escritório");
//
//		List<Categoria> lista = new ArrayList<>();
//		lista.add(cat1);
//		lista.add(cat2);
		
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
