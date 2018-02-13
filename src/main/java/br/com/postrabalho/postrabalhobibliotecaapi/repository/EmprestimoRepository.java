package br.com.postrabalho.postrabalhobibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
