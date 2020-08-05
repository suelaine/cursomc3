package com.suelaine.cursomc2.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.suelaine.cursomc2.domain.Categoria;
import com.suelaine.cursomc2.domain.Cliente;
//import com.suelaine.cursomc2.domain.ItemPedido;
import com.suelaine.cursomc2.domain.PagamentoComBoleto;
import com.suelaine.cursomc2.domain.Pedido;
import com.suelaine.cursomc2.domain.enums.EstadoPagamento;
import com.suelaine.cursomc2.repositories.ClienteRepository;
//import com.suelaine.cursomc2.repositories.ItemPedidoRepository;
import com.suelaine.cursomc2.repositories.PagamentoRepository;
import com.suelaine.cursomc2.repositories.PedidoRepository;
import com.suelaine.cursomc2.repositories.ProdutoRepository;
//import com.suelaine.cursomc2.security.UserSS;
import com.suelaine.cursomc2.services.exceptions.AuthorizationException;
import com.suelaine.cursomc2.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
//	@Autowired
//	private BoletoService boletoService;
//	
//	@Autowired
//	private PagamentoRepository pagamentoRepository;
//	
//	@Autowired
//	private ProdutoRepository produtoRepository;
//	
//	@Autowired
//	private ItemPedidoRepository itemPedidoRepository;
//	
//	@Autowired
//	private ClienteRepository clienteRepository;
//	
//	@Autowired
//	private EmailService emailService;	
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: "+Pedido.class.getName()     
				)
				);
	}
//
//	public Pedido insert(Pedido obj) {
//		obj.setId(null);
//		obj.setInstante(new Date());
//		obj.setCliente(clienteRepository.findOne(obj.getCliente().getId()));
//		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
//		obj.getPagamento().setPedido(obj);
//		if (obj.getPagamento() instanceof PagamentoComBoleto) {
//			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
//			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
//		}
//		obj = repo.save(obj);
//		pagamentoRepository.save(obj.getPagamento());
//		for (ItemPedido ip : obj.getItens()) {
//			ip.setDesconto(0.0);
//			ip.setProduto(produtoRepository.findOne(ip.getProduto().getId()));
//			ip.setPreco(ip.getProduto().getPreco());
//			ip.setPedido(obj);
//		}
//		itemPedidoRepository.save(obj.getItens());
//		emailService.sendOrderConfirmationEmail(obj);
//		return obj;
//	}
//	
//	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
//		UserSS user = UserService.authenticated();
//		if (user == null) {
//			throw new AuthorizationException("Acesso negado");
//		}
//		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		Cliente cliente =  clienteRepository.findOne(user.getId());
//		return repo.findByCliente(cliente, pageRequest);
//	}
}
