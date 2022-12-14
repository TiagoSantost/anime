package br.ufpb.anime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.anime.logar.Logar;
import br.ufpb.anime.model.Usuario;

@RestController
@RequestMapping("/load")
public class LogarController {
	 private final Logar logar;
	 
	    public LogarController(Logar logar) {
	        this.logar = logar;
	    }

	    @GetMapping("/logar")
	    public Usuario carregarUsuario(){
	        logar.carregarUsuario();
	        return logar.getUsuario();
	    }
	

	}
