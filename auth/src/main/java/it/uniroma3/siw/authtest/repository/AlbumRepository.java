package it.uniroma3.siw.authtest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografo;


public interface AlbumRepository extends CrudRepository<Album,Long>{

	List<Album> findByFotografo(Fotografo fotografo);

}
