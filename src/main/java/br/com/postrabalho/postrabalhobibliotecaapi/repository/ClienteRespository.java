package br.com.postrabalho.postrabalhobibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postrabalho.postrabalhobibliotecaapi.model.Cliente;

public interface ClienteRespository extends JpaRepository<Cliente, Long>{

}
