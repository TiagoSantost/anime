package br.ufpb.anime.service;


import org.springframework.stereotype.Service;

import br.ufpb.anime.exception.ItemNotFoundException;
import br.ufpb.anime.model.Anime;
import br.ufpb.anime.repository.AnimeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
	  AnimeRepository animeRepository;

	    public AnimeService(AnimeRepository animeRepository) {
	        this.animeRepository = animeRepository;
	    }

	    public Anime createAnime(Anime anime){
	        return animeRepository.save(anime);
	    }

	    public List<Anime> listAnime(){
	        return animeRepository.findAll();
	    }

	    public Anime getAnime(Long animeId){
	        Optional<Anime> optionalAnime = animeRepository.findById(animeId);
	        if (optionalAnime.isPresent()){
	            return animeRepository.getReferenceById(animeId);
	        }
	        else {
	            throw new ItemNotFoundException("Anime " + animeId + "Não encontrado");
	        }
	    }
	    public Anime updateAnime(Long animeId, Anime anime){
	        Optional<Anime> optionalVeiculo = animeRepository.findById(animeId);
	        if (optionalVeiculo.isPresent()){
	        	Anime update = optionalVeiculo.get();
	        	update.setNome(anime.getNome());
	        	update.setAno(anime.getAno());
	            return update;
	        }
	        else {
	            throw new ItemNotFoundException("Anime " + animeId + " Não encontrado");
	        }
	    }


	    public void deleteAnime(Long animeId){
	        Optional<Anime> optionalAnime = animeRepository.findById(animeId);
	        if (optionalAnime.isPresent()){
	        	animeRepository.deleteById(animeId);
	        }
	        else {
	            throw new ItemNotFoundException("Anime " + animeId + " Não encontrado");
	        }
	    }
	}
