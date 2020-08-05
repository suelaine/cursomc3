package com.suelaine.cursomc2.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.domain.Cidade;
import com.suelaine.cursomc2.domain.Endereco;
import com.suelaine.cursomc2.domain.enums.Perfil;
//import com.suelaine.cursomc2.dto.ClienteDTO;
//import com.suelaine.cursomc2.dto.ClienteNewDTO;
import com.suelaine.cursomc2.repositories.CidadeRepository;
import com.suelaine.cursomc2.repositories.EnderecoRepository;
//import com.suelaine.cursomc2.security.UserSS;
import com.suelaine.cursomc2.services.exceptions.AuthorizationException;
import com.suelaine.cursomc2.services.exceptions.DataIntegrityException;
import com.suelaine.cursomc2.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

//	@Autowired
//	private BCryptPasswordEncoder pe;

	@Autowired
	private EnderecoRepository repo;

//	@Autowired
//	private CidadeRepository cidadeRepository;
//
//	@Autowired
//	private EnderecoRepository enderecoRepository;

//	@Autowired
//	private S3Service s3Service;

//	@Autowired
//	private ImageService imageService;

//	@Value("${img.prefix.client.profile}")
//	private String prefix;
//
//	@Value("${img.profile.size}")
//	private Integer size;

	public Endereco find(Integer id) {

		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+Endereco.class.getName()     
				)
				);
	}

//	public Endereco insert(Endereco obj) {
//		obj.setId(null);
//		obj = repo.save(obj);
////		enderecoRepository.save(obj.getEnderecos());
//		return obj;
//	}
//
//	public Endereco update(Endereco obj) {
//		Endereco newObj = find(obj.getId());
//		updateData(newObj, obj);
//		return repo.save(newObj);
//	}
//
//	public void delete(Integer id) {
//		find(id);
//		try {
////			repo.delete(id);
//		} catch (DataIntegrityViolationException e) {
//			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
//		}
//	}
//
//	public List<Endereco> findAll() {
//		return repo.findAll();
//	}

//	public Endereco findByEmail(String email) {
//
////		UserSS user = UserService.authenticated();
////		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
////			throw new AuthorizationException("Acesso negado");
////		}
//
////		Endereco obj = repo.findByEmail(email);
////		if (obj == null) {
////			throw new ObjectNotFoundException(
////					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Endereco.class.getName());
////		}
////		return obj;
//	}

//	public Page<Endereco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
////		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		return null;
////				repo.findAll(pageRequest);
//	}

//	public Endereco fromDTO(EnderecoDTO objDto) {
//		return new Endereco(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
//	}
//
//	public Endereco fromDTO(EnderecoNewDTO objDto) {
////		Endereco cli = new Endereco(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(),
////				TipoEndereco.toEnum(objDto.getTipo()), pe.encode(objDto.getSenha()));
////		Cidade cid = cidadeRepository.findOne(objDto.getCidadeId());
////		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
////				objDto.getBairro(), objDto.getCep(), cli, cid);
////		cli.getEnderecos().add(end);
////		cli.getTelefones().add(objDto.getTelefone1());
////		if (objDto.getTelefone2() != null) {
////			cli.getTelefones().add(objDto.getTelefone2());
////		}
////		if (objDto.getTelefone3() != null) {
////			cli.getTelefones().add(objDto.getTelefone3());
////		}
//		return null;
////		cli;
//	}

//	private void updateData(Endereco newObj, Endereco obj) {
//		newObj.setNome(obj.getNome());
//		newObj.setEmail(obj.getEmail());
//	}
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
