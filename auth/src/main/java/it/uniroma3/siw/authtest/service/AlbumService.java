package it.uniroma3.siw.authtest.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografo;
import it.uniroma3.siw.authtest.repository.AlbumRepository;


@Service
public class AlbumService {
	
	@Autowired 
	private AlbumRepository albumRepository;
	
	
	
	@Transactional
	public Album inserisci(Album album) {
	return	this.albumRepository.save(album);
	}
	
	
	@Transactional
	public List<Album> tutti() {
	return	(List<Album>) this.albumRepository.findAll();
	}
	@Transactional
	public List<Album> getAlbumPerFotografo(Fotografo fotografo) {
	return	(List<Album>) this.albumRepository.findByFotografo(fotografo);
	}
	
	@Transactional
	public Album findById(Long id) {
		return this.albumRepository.findById(id).get();
	}
	@Transactional
	public void setFotografo(Album album,Fotografo fotografo) {
		 album.setFotografo(fotografo);
	}
	

	/*public List<Fotografo> findByNome(String nome) {
		return this.studenteRepository.findByNome(nome);
	} */
	
}

