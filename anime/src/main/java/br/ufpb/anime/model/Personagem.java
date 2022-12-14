package br.ufpb.anime.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_Personagem")
public class Personagem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "personagem_id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "idade")
	private String idade;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "anime_id")
	private Anime anime;

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

}
