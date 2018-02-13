package br.com.postrabalho.postrabalhobibliotecaapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	
	private String bairro;
	
	private String quadra;
	
	private String lote;
	
	private String numero;
	
	private String complemento;
	
	private String cidade;
	
	private String estado;
	
	private String pais;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Endereco(String rua, String bairro, String quadra, String lote, String numero, String complemento,
			String cidade, String estado, String pais) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.quadra = quadra;
		this.lote = lote;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getQuadra() {
		return quadra;
	}
	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
