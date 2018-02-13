package br.com.postrabalho.postrabalhobibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Editora;
import br.com.postrabalho.postrabalhobibliotecaapi.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	public Editora inserir(Editora editora) {
		return this.repository.save(editora);
	}
	
	public void excluir(Long id){
		this.repository.delete(id);
	}
	
	public List<Editora> listar(){
		return this.repository.findAll();
	}
	
	public Editora pesquisarPorId(Long id){
		Editora editoraPesquisada = this.repository.findOne(id);
		
		if(editoraPesquisada == null){
			throw new EmptyResultDataAccessException(0);
		}
		
		return editoraPesquisada;
	}
	
	public Editora alterar(Editora editora){
		pesquisarPorId(editora.getId());
		
		return this.repository.save(editora);
	}
}
