package br.com.postrabalho.postrabalhobibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
