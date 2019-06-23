package it.uniroma3.siw.authtest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografia;
import it.uniroma3.siw.authtest.model.Fotografo;
import it.uniroma3.siw.authtest.model.Richiesta;
import it.uniroma3.siw.authtest.repository.FotografiaRepository;

@Service
public class FotografiaService {
	
	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Transactional
	public List<Fotografia> getFotoPerAlbum(Album album) {
	return	(List<Fotografia>) this.fotografiaRepository.findByAlbum(album);
	}
	@Transactional
	public Fotografia inserisci(Fotografia fotografia) {
		return this.fotografiaRepository.save(fotografia);
	}
	@Transactional
	public void setAlbum(Album album, Fotografia fotografia) {
		 fotografia.setAlbum(album);
	}
	@Transactional
	public List<Fotografia> findAll() {
	return (List<Fotografia>) this.fotografiaRepository.findAll();
		
	}
	@Transactional
	public Fotografia findById(Long id) {
		return this.fotografiaRepository.findById(id).get();
	}
	@Transactional
	public void setRichiesta(Fotografia foto, Richiesta richiesta) {
		foto.setRichiesta(richiesta);
		
	}
	@Transactional
	public List<Fotografia> getFotografiaPerRichiesta(Richiesta richiesta) {
	return	(List<Fotografia>) this.fotografiaRepository.findByRichiesta(richiesta);
	}
	@Transactional
	public Fotografia findByNome(String nome) {
		// TODO Auto-generated method stub
		return this.fotografiaRepository.findByNome(nome);
	}
	

}
