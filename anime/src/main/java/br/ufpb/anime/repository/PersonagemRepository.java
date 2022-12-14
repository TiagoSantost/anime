package br.ufpb.anime.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpb.anime.model.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
 
}

