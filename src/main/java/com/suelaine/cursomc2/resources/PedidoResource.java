package com.suelaine.cursomc2.resources;



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
import com.suelaine.cursomc2.domain.Pedido;
import com.suelaine.cursomc2.services.CategoriaService;
import com.suelaine.cursomc2.services.PedidoService;

//COMUNICAM OS DADOS COM AS APLICAÇÕES 

@RestController
@RequestMapping(value="/pedidos")


public class PedidoResource {
	
	//@Autowired INSTANCIA AUTOMATICAMENTE
	@Autowired
	private PedidoService service;
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String ok() {
//		return "REST está funcionando!";
//	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		// ResponseEntity ENCAPSULA VARTIAD INFORMAÇÕES PARA UM RSERVIÇO REST
		Optional<Pedido> obj = Optional.ofNullable(service.find(id));
//		Categoria cat1 = new Categoria(1,"Informática");
//		Categoria cat2 = new Categoria(2,"Escritório");
//
//		List<Categoria> lista = new ArrayList<>();
//		lista.add(cat1);
//		lista.add(cat2);
		
		
		return ResponseEntity.ok().body(obj);
	}

}
