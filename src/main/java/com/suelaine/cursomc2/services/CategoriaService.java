package com.suelaine.cursomc2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.repositories.CategoriaRepository;
import com.suelaine.cursomc2.services.exceptions.ObjectNotFoundException;

//REGRAS DE NEGÓCIO
//RESPONSÁVEL POR OFERECER OPERAÇÕES E CONSULTAS PARA OS NOSSOS CONTROLADORES REST - OS RESOURCES 
// NÃO TEM CONTATO COM TECNOLOGIAS 
@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
//	public Categoria find(Integer id) {
//		Optional<Categoria> obj = repo.findById(id);
//		return obj.orElse(null);
//	}
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+Categoria.class.getName()     
				)
				);
	}
	
	public Categoria insert(Categoria obj) {
		return repo.save(obj);
		
	}
}
