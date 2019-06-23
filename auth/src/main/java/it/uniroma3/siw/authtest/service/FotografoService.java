package it.uniroma3.siw.authtest.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografo;
import it.uniroma3.siw.authtest.repository.FotografoRepository;

@Service
public class FotografoService {
	
	@Autowired 
	private FotografoRepository fotografoRepository;
	@Autowired 
	private AlbumService albumService;
	@Transactional
	public List<Album> findByFotografo(Fotografo fotografo) {
	return	this.albumService.getAlbumPerFotografo(fotografo);
	}
	
	
	@Transactional
	public Fotografo fotografoPerId(Long id) {
	return	this.fotografoRepository.findById(id).get();
	}
	
	@Transactional
	public Fotografo inserisci(Fotografo fotografo) {
	return	this.fotografoRepository.save(fotografo);
	}
	
	
	@Transactional
	public List<Fotografo> tutti() {
	return	(List<Fotografo>) this.fotografoRepository.findAll();
	}
	
	@Transactional
	public Fotografo findById(Long id) {
		return this.fotografoRepository.findById(id).get();
	}
	
	

	/*public List<Fotografo> findByNome(String nome) {
		return this.studenteRepository.findByNome(nome);
	} */
	

   
	
}

