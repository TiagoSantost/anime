package br.ufpb.anime.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufpb.anime.model.Anime;


public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
