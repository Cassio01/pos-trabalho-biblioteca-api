package br.com.postrabalho.postrabalhobibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Genero;
import br.com.postrabalho.postrabalhobibliotecaapi.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;

	public Genero alterar(Genero genero) {

		pesquisaPorId(genero.getId());

		return this.repository.save(genero);
	}

	public Genero pesquisaPorId(Long id) {

		Genero generoPesquisado = this.repository.findOne(id);

		if (generoPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}

		return generoPesquisado;
	}

	public Genero inserir(Genero genero) {
		return this.repository.save(genero);
	}

	public void excluir(Long id) {
		this.repository.delete(id);
	}

	public List<Genero> listar() {
		return this.repository.findAll();
	}
}
