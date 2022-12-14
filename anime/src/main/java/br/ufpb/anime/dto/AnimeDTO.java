package br.ufpb.anime.dto;

import javax.validation.constraints.NotBlank;

import br.ufpb.anime.model.Personagem;

public class AnimeDTO {
	private Long id;	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	@NotBlank(message = "Ano é obrigatório")
	private String ano;
	@NotBlank(message = "Personagem obrigatorio")
	private Personagem personagem;
	
	public AnimeDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	@Override
	public String toString() {
		return "AnimeDTO [id=" + id + ", nome=" + nome + ", ano=" + ano + ", personagem=" + personagem + "]";
	}
	
	
}
