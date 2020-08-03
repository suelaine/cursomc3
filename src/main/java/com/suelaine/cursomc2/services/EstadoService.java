package com.suelaine.cursomc2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suelaine.cursomc2.domain.Estado;
import com.suelaine.cursomc2.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
//	public List<Estado> findAll() {
//		return repo.findAllByOrderByNome();
//	}
}
