package it.uniroma3.siw.authtest.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.authtest.model.Richiesta;
import it.uniroma3.siw.authtest.repository.RichiestaRepository;

@Service
public class RichiestaService {
	@Autowired
	private RichiestaRepository richiestaRepository;
	@Transactional
	public Richiesta inserisci(Richiesta richiesta) {
		// TODO Auto-generated method stub
		return this.richiestaRepository.save(richiesta);

	}
	public Richiesta findById(Long idR) {
		// TODO Auto-generated method stub
		return this.richiestaRepository.findById(idR).get();
	}
	public List<Richiesta> findAll() {
		// TODO Auto-generated method stub
		return (List<Richiesta>) this.richiestaRepository.findAll();
	}

}
