package br.ufpb.anime.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.ufpb.anime.exception.ItemNotFoundException;
import br.ufpb.anime.model.Personagem;
import br.ufpb.anime.repository.PersonagemRepository;

@Service
public class PersonagemService {
	 PersonagemRepository personagemRepository;
	
	    public PersonagemService(PersonagemRepository personagemRepository) {
	        this.personagemRepository = personagemRepository;
	    }

	    public Personagem createPersonagem(Personagem personagem){
	        return personagemRepository.save(personagem);
	    }

	    public List<Personagem> listPersonagem(){
	        return personagemRepository.findAll();
	    }

	    public Personagem getPersonagem(Long personagemId){
	        Optional<Personagem> optionalPersonagem = personagemRepository.findById(personagemId);
	        if (optionalPersonagem.isPresent()){
	            return personagemRepository.getReferenceById(personagemId);
	        }
	        else {
	            throw new ItemNotFoundException("Personagem " + personagemId + " Não encontrado");
	        }
	    }
	    public Personagem updatePersonagem(Long personagemId, Personagem personagem){
	        Optional<Personagem> optionalPersonagem = personagemRepository.findById(personagemId);
	        if (optionalPersonagem.isPresent()){
	        	Personagem upade = optionalPersonagem.get();
	        	upade.setNome(personagem.getNome());
	        	upade.setIdade(personagem.getIdade());
	            return upade;
	        }
	        else {
	            throw new ItemNotFoundException("Personagem " + personagemId + "  Não encontrado");
	        }
	    }


	    public void deletePersonagem(Long personagemId){
	        Optional<Personagem> optionalPersonagem = personagemRepository.findById(personagemId);
	        if (optionalPersonagem.isPresent()){
	        	personagemRepository.deleteById(personagemId);
	        }
	        else {
	            throw new ItemNotFoundException("Personagem " + personagemId + " Não encontrado");
	        }
	    }
	}