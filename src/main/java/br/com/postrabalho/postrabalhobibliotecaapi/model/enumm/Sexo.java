package br.com.postrabalho.postrabalhobibliotecaapi.model.enumm;

public enum Sexo {

	MASCULINO("Masculino"), FEMININO("Feminino");
	
	private String tipoSexo;
	
	private Sexo(String tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public String getTipoSexo() {
		return tipoSexo;
	}
}
