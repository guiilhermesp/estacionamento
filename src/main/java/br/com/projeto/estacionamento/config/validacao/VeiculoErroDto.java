package br.com.projeto.estacionamento.config.validacao;

public class VeiculoErroDto {

	private String campo;
	private String erro;
	
	
	public VeiculoErroDto(String erro, String campo) {
		this.erro = erro;
		this.campo = campo;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
}
