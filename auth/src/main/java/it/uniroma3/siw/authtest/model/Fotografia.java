package it.uniroma3.siw.authtest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Fotografia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private Richiesta richiesta;
	@ManyToOne
	private Album album;
	@ManyToMany
	private List<Richiesta> richieste;
	
	public void setAlbum(Album album) {
		this.album=album;
	}
	public Album getAlbum() {
		return this.album;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		 this.nome=nome;
	}
	
	public void setRichiesta(Richiesta richiesta) {
		this.richiesta=richiesta;
		
	}
	public void setId(Long id) {
		this.id=id;
	}
	public Long  getId(Long id) {
		return this.id;
	}
	
}