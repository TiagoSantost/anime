package br.ufpb.anime.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tb_Anime")
public class Anime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "anime_id")
	private Long id;

	@Column(name = "nome")
	private String nome;
	@Column(name = "ano")
	private String ano;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private Collection<Personagem> personagem;

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

	public Collection<Personagem> getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Collection<Personagem> personagem) {
		this.personagem = personagem;
	}

}
