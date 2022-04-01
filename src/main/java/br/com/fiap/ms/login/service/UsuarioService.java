package br.com.fiap.ms.login.service;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.fiap.ms.login.component.QueueSender;
import br.com.fiap.ms.login.dto.UsuarioDto;
import br.com.fiap.ms.login.model.Usuario;
import br.com.fiap.ms.login.model.UsuarioLoginHistorico;
import br.com.fiap.ms.login.repository.UsuarioRepository;
import br.com.fiap.ms.login.util.Utilitario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	 @Autowired
	 private QueueSender queueSender;

	public Boolean Cadastrar(UsuarioDto usuarioDto) {

		
		Optional<Usuario> usuarioExiste = usuarioRepository.findOneByEmail(usuarioDto.getEmail());
		 
		if (usuarioExiste.isPresent()) {
			return false;
		}
			Usuario usuario = new Usuario();
			usuario.setIdExterno(usuarioDto.getIdExterno()); 
			usuario.setEmail(usuarioDto.getEmail()); 
			usuario.setSenha(Utilitario.encriptarSenha(usuarioDto.getSenha()));
			usuarioRepository.save(usuario);
		
			return true;

	}

	public Boolean Logar(UsuarioDto usuarioDto) { 
		Optional<Usuario> usuario = usuarioRepository.findOneByEmail(usuarioDto.getEmail());
	 
			if (usuario.isPresent()) {
				if (usuario.get().getSenha().equals(Utilitario.encriptarSenha(usuarioDto.getSenha()))) {
 
			    	queueSender.send(new Gson().toJson(new UsuarioLoginHistorico(usuario.get())));
					return true;
				}
			}
		  
		return false;
	}

}
