package br.com.postrabalho.postrabalhobibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Autor;
import br.com.postrabalho.postrabalhobibliotecaapi.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	public Autor alterar(Autor autor) {

		pesquisaPorId(autor.getId());

		return this.repository.save(autor);
	}

	public Autor pesquisaPorId(Long id) {

		Autor autorPesquisado = this.repository.findOne(id);

		if (autorPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}

		return autorPesquisado;
	}

	public Autor inserir(Autor autor) {
		return this.repository.save(autor);
	}

	public void excluir(Long id) {
		this.repository.delete(id);
	}

	public List<Autor> listar() {
		return this.repository.findAll();
	}
}
