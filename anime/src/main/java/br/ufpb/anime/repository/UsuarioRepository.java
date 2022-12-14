package br.ufpb.anime.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpb.anime.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}
