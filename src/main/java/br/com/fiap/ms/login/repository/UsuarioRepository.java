package br.com.fiap.ms.login.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.ms.login.model.Usuario;
 
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findOneByEmail(String email);

}

