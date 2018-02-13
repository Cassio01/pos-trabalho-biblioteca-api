package br.com.postrabalho.postrabalhobibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Cliente;
import br.com.postrabalho.postrabalhobibliotecaapi.repository.ClienteRespository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRespository repository;
	
	public Cliente inserir(Cliente cliente) {
		return this.repository.save(cliente);
	}
	
	public void excluir(Long id){
		this.repository.delete(id);
	}
	
	public List<Cliente> listar(){
		return this.repository.findAll();
	}
	
	public Cliente pesquisarPorId(Long id){
		Cliente clientePesquisado = this.repository.findOne(id);
		
		if(clientePesquisado == null){
			throw new EmptyResultDataAccessException(0);
		}
		
		return clientePesquisado;
	}
	
	public Cliente alterar(Cliente cliente){
		pesquisarPorId(cliente.getId());
		
		return this.repository.save(cliente);
	}
}
