package br.ufpb.anime.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.ufpb.anime.dto.AnimeDTO;
import br.ufpb.anime.model.Anime;
import br.ufpb.anime.service.AnimeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AnimeController {
	  private final AnimeService animeService;
	    private final ModelMapper modelMapper;

	    public AnimeController(AnimeService animeService, ModelMapper modelMapper) {
	        this.animeService = animeService;
	        this.modelMapper = modelMapper;
	    }

	    private AnimeDTO convertToDTO(Anime anime){
	        return modelMapper.map(anime, AnimeDTO.class);
	    }

	    private Anime convertToEntity(AnimeDTO animeDTO){
	        return modelMapper.map(animeDTO, Anime.class);
	    }

	    @PostMapping(path = "/anime")
	    AnimeDTO createAnime(@Valid @RequestBody AnimeDTO animeDTO) {
	    	Anime anime = convertToEntity(animeDTO);
	    	Anime salvar = animeService.createAnime(anime);
	        return convertToDTO(salvar);
	    }

	    @GetMapping(path = "/animes")
	    List<Anime> listAnimes() {
	        return animeService.listAnime();
	    }

	    @GetMapping("/animes/{animeId}")
	    public AnimeDTO getAnime(@Valid @PathVariable Long animeId) {
	    	Anime anime = animeService.getAnime(animeId);
	        System.out.println(anime.toString());
	        return convertToDTO(anime);
	    }


	    @PutMapping("/animes/{animeId}")
	    public AnimeDTO updateAnime(@Valid @PathVariable Long animeId, @RequestBody AnimeDTO animeDTO) {
	    	Anime anime = convertToEntity(animeDTO);
	    	Anime animeAtualizado = animeService.updateAnime(animeId, anime);
	        return convertToDTO(animeAtualizado);
	    }

	    @ResponseStatus(HttpStatus.OK)
	    @DeleteMapping("/anime/{animeId}")
	    public void deleteAnime(@Valid @PathVariable Long animeId) {
	    	animeService.deleteAnime(animeId);
	    }
}

