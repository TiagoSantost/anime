package br.ufpb.anime.dto;

import javax.validation.constraints.NotBlank;

import br.ufpb.anime.model.Anime;

public class PersonagemDTO {
	private Long id;	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	@NotBlank(message = "Ano é obrigatório")
	private String idade;
	@NotBlank(message = "Anime obrigatorio")
	private Anime anime;
	
	public PersonagemDTO() {}

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

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	@Override
	public String toString() {
		return "PersonagemDTO [id=" + id + ", nome=" + nome + ", idade=" + idade + ", anime=" + anime + "]";
	}
	

}
