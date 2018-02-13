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

@Entity
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = -3015408353237299135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dataDoEmprestimo;

	@Temporal(TemporalType.DATE)
	private Date dataDeDevolucao;

	@Column(precision = 10, scale = 2)
	private BigDecimal valorDoEmprestimo;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;

	public Emprestimo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emprestimo(Long id, Date dataDoEmprestimo, Date dataDeDevolucao, 
			BigDecimal valorDoEmprestimo, Cliente cliente, Livro livro) {
		super();
		this.id = id;
		this.dataDoEmprestimo = dataDoEmprestimo;
		this.dataDeDevolucao = dataDeDevolucao;
		this.valorDoEmprestimo = valorDoEmprestimo;
		this.cliente = cliente;
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDoEmprestimo() {
		return dataDoEmprestimo;
	}

	public void setDataDoEmprestimo(Date dataDoEmprestimo) {
		this.dataDoEmprestimo = dataDoEmprestimo;
	}

	public Date getDataDeDevolucao() {
		return dataDeDevolucao;
	}

	public void setDataDeDevolucao(Date dataDeDevolucao) {
		this.dataDeDevolucao = dataDeDevolucao;
	}

	public BigDecimal getValorDoEmprestimo() {
		return valorDoEmprestimo;
	}

	public void setValorDoEmprestimo(BigDecimal valorDoEmprestimo) {
		this.valorDoEmprestimo = valorDoEmprestimo;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
