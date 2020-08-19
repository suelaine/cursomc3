package com.suelaine.cursomc2.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suelaine.cursomc2.domain.Cliente;

//ACESSO A DADOS

//um objeto desse tipo é capaz de fazer operações de acesso a banco de dados, fazer consultas
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Transactional(readOnly=true)
	Cliente findByEmail(String email);
	

}
