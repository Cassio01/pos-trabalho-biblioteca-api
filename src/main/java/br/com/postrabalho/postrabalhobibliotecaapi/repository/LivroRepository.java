package br.com.postrabalho.postrabalhobibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
