package br.com.postrabalho.postrabalhobibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Livro;
import br.com.postrabalho.postrabalhobibliotecaapi.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public Livro alterar(Livro livro) {

		pesquisaPorId(livro.getId());

		return this.repository.save(livro);
	}

	public Livro pesquisaPorId(Long id) {

		Livro livroPesquisado = this.repository.findOne(id);

		if (livroPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}

		return livroPesquisado;
	}

	public Livro inserir(Livro livro) {
		return this.repository.save(livro);
	}

	public void excluir(Long id) {
		this.repository.delete(id);
	}

	public List<Livro> listar() {
		return this.repository.findAll();
	}
}
