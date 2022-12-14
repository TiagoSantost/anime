package br.ufpb.anime.controller;
import br.ufpb.anime.dto.PersonagemDTO;
import br.ufpb.anime.model.Personagem;
import br.ufpb.anime.service.PersonagemService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PersonagemController {
	private final PersonagemService personagemService;
    private final ModelMapper modelMapper;

    public PersonagemController(PersonagemService personagemService, ModelMapper modelMapper) {
        this.personagemService = personagemService;
        this.modelMapper = modelMapper;
    }

    private PersonagemDTO convertToDTO(Personagem personagem){
        return modelMapper.map(personagem, PersonagemDTO.class);
    }

    private Personagem convertToEntity(PersonagemDTO personagemDTO){
        return modelMapper.map(personagemDTO, Personagem.class);
    }

    @PostMapping(path = "/personagem")
    public PersonagemDTO createPersonagem(@Valid @RequestBody PersonagemDTO personagemDTO) {
        Personagem personagem = convertToEntity(personagemDTO);
        Personagem salvar = personagemService.createPersonagem(personagem);
        return convertToDTO(salvar);
    }

    @GetMapping(path = "/personagens")
    public List<Personagem> listPersonagem() {
        return personagemService.listPersonagem();
    }

    @GetMapping("/personagem/{personagemId}")
    public PersonagemDTO getVenda(@Valid @PathVariable Long personagemId) {
        Personagem personagem = personagemService.getPersonagem(personagemId);
        System.out.println(personagem.toString());
        return convertToDTO(personagem);
    }


    @PutMapping("/personagem/{personagemId}")
    public PersonagemDTO updateVenda(@Valid @PathVariable Long personagemId, @RequestBody PersonagemDTO personagemDTO) {
        Personagem p = convertToEntity(personagemDTO);
        Personagem personagemAtualizado = personagemService.updatePersonagem(personagemId, p);
        return convertToDTO(personagemAtualizado);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/personagem/{personagemId}")
    public void deleteVenda(@Valid @PathVariable Long personagemId) {
    	personagemService.deletePersonagem(personagemId);
    }

}
