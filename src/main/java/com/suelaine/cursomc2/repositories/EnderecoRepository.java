package com.suelaine.cursomc2.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.domain.Endereco;

//ACESSO A DADOS

//um objeto desse tipo é capaz de fazer operações de acesso a banco de dados, fazer consultas
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
