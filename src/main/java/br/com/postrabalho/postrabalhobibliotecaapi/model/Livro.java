package br.com.postrabalho.postrabalhobibliotecaapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = -4405891883207519046L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome é obrigatório!")
	private String nome;

	private Integer volume;

	@Temporal(TemporalType.DATE)
	private Date dataDePublicacao;

	@Column(precision = 10, scale = 2)
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "id_genero", nullable = false)
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false)
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "id_editora", nullable = false)
	private Editora editora;

	public Livro() {
		super();
	}

	public Livro(Long id, String nome, Integer volume, Date dataDePublicacao, BigDecimal valor, Genero genero,
			Autor autor, Editora editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.volume = volume;
		this.dataDePublicacao = dataDePublicacao;
		this.valor = valor;
		this.genero = genero;
		this.autor = autor;
		this.editora = editora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
