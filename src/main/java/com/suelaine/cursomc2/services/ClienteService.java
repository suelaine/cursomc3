package com.suelaine.cursomc2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suelaine.cursomc2.domain.Cidade;
import com.suelaine.cursomc2.domain.Cliente;
import com.suelaine.cursomc2.domain.Endereco;
import com.suelaine.cursomc2.domain.enums.TipoCliente;
import com.suelaine.cursomc2.dto.ClienteDTO;
import com.suelaine.cursomc2.dto.ClienteNewDTO;
import com.suelaine.cursomc2.repositories.CidadeRepository;
import com.suelaine.cursomc2.repositories.ClienteRepository;
import com.suelaine.cursomc2.repositories.EnderecoRepository;
import com.suelaine.cursomc2.services.exceptions.DataIntegrityException;
import com.suelaine.cursomc2.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

//	@Autowired
//	private BCryptPasswordEncoder pe;

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

//	@Autowired
//	private S3Service s3Service;

//	@Autowired
//	private ImageService imageService;

//	@Value("${img.prefix.client.profile}")
//	private String prefix;
//
//	@Value("${img.profile.size}")
//	private Integer size;

	public Cliente find(Integer id) {

		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+Cliente.class.getName()     
				)
				);
	}

	@Transactional // vai garantir que ele salve tanto os clientes quanto os endereos na mesma transação do banco de dados
	public Cliente insert(Cliente obj) {
		
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}	
	

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há ENTIDADES relacionadAs");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

//	public Cliente findByEmail(String email) {
//
//		UserSS user = UserService.authenticated();
//		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
//			throw new AuthorizationException("Acesso negado");
//		}
//
////		Cliente obj = repo.findByEmail(email);
////		if (obj == null) {
////			throw new ObjectNotFoundException(
////					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
////		}
////		return obj;
//	}	
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){		
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);		
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
				TipoCliente.toEnum(objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(),null,null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

	
//
//	public URI uploadProfilePicture(MultipartFile multipartFile) {

//		UserSS user = UserService.authenticated();
//		if (user == null) {
//			throw new AuthorizationException("Acesso negado");
//		}

//		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
//		jpgImage = imageService.cropSquare(jpgImage);
//		jpgImage = imageService.resize(jpgImage, size);

//		String fileName = prefix + user.getId() + ".jpg";

//		return null;
//		s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
//	}
}
