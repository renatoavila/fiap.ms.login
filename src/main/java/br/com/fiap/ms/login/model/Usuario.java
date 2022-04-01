package br.com.fiap.ms.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

@SuppressWarnings("unused")
private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(unique=true,nullable = false) 
	private String email;
	
	@Column(unique=true,nullable = false) 
	private Long idExterno; 
	
	private String senha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public Long getIdExterno() {
		return idExterno;
	}
	public void setIdExterno(Long idExterno) {
		this.idExterno = idExterno;
	}
	public String getEmail() {
		return email;
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
