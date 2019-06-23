package it.uniroma3.siw.authtest.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografia;
import it.uniroma3.siw.authtest.model.Fotografo;
import it.uniroma3.siw.authtest.model.Richiesta;


public interface FotografiaRepository extends CrudRepository<Fotografia,Long>{
	public List<Fotografia> findByAlbum(Album album);
	public List<Fotografia> findByRichiesta(Richiesta richiesta);
	public Fotografia findByNome(String nome);
}
