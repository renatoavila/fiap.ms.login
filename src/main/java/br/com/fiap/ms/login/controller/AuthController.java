package br.com.fiap.ms.login.controller;
 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.ms.login.dto.LoginDto;
import br.com.fiap.ms.login.dto.UsuarioDto;
import br.com.fiap.ms.login.service.UsuarioService;
 
 
@RestController 
public class AuthController {
	

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
	 @RequestMapping(value = "api/login/", method = RequestMethod.POST)  
		public ResponseEntity<Boolean> logar(@RequestBody LoginDto loginDto) {			 			 
		 	Boolean ret = usuarioService.Logar(loginDto);	 
			if(ret)
			{
				return ResponseEntity.ok(ret);
			}
			else
			{
				return ResponseEntity.badRequest().build();
			}			 
		}
	 
	 @RequestMapping(value = "api/login/create/", method = RequestMethod.POST)  
		public ResponseEntity<Boolean> cadastrar(@RequestBody UsuarioDto usuarioDto) {
			Boolean ret = usuarioService.Cadastrar(usuarioDto);	 
			if(ret)
			{
				return ResponseEntity.ok(ret);
			}
			else
			{
				return ResponseEntity.badRequest().build();
			}			 
		}
	
}
