package br.com.postrabalho.postrabalhobibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Emprestimo;
import br.com.postrabalho.postrabalhobibliotecaapi.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	
	public Emprestimo inserir(Emprestimo emprestimo) {
		return this.repository.save(emprestimo);
	}
	
	public void excluir(Long id){
		this.repository.delete(id);
	}
	
	public List<Emprestimo> listar(){
		return this.repository.findAll();
	}
	
	public Emprestimo pesquisarPorId(Long id){
		Emprestimo emprestimoPesquisado = this.repository.findOne(id);
		
		if(emprestimoPesquisado == null){
			throw new EmptyResultDataAccessException(0);
		}
		
		return emprestimoPesquisado;
	}
	
	public Emprestimo alterar(Emprestimo emprestimo){
		pesquisarPorId(emprestimo.getId());
		
		return this.repository.save(emprestimo);
	}
	
}
