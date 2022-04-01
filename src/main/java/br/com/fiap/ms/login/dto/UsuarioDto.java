package br.com.fiap.ms.login.dto;

public class UsuarioDto {
	private Long idExterno;
	private String email;
	private String senha;
	public String getEmail() {
		return email;
	}
	
	
	public Long getIdExterno() {
		return idExterno;
	}


	public void setIdExterno(Long idExterno) {
		this.idExterno = idExterno;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
