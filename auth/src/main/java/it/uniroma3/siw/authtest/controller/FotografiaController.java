package it.uniroma3.siw.authtest.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografia;
import it.uniroma3.siw.authtest.model.Richiesta;
import it.uniroma3.siw.authtest.service.AlbumService;

import it.uniroma3.siw.authtest.service.FotografiaService;
import it.uniroma3.siw.authtest.service.RichiestaService;

@Controller
public class FotografiaController {
	
	@Autowired 
	private FotografiaService fotografiaService;
	@Autowired 
	private AlbumService albumService;
	@Autowired 
	private RichiestaService richiestaService;
	
	
	@RequestMapping(value="/fotografo/{idS}/album/{idA}", method= RequestMethod.GET)
	public String getAlbum(@PathVariable("idA")Long idA,Model model) {
		
		Album album=this.albumService.findById(idA);
		
		model.addAttribute("foto1",new Fotografia());
		model.addAttribute("album",album);
		model.addAttribute("foto", this.fotografiaService.getFotoPerAlbum(album));

		return "listaFoto";
		}

	
	@RequestMapping(value="/guest/fotografo/{idS}/album/{idA}", method= RequestMethod.GET)
	public String getAlbumGuest(@PathVariable("idA")Long idA,Model model) {
		
		Album album=this.albumService.findById(idA);
		
		
		model.addAttribute("album",album);
		model.addAttribute("foto", this.fotografiaService.getFotoPerAlbum(album));

		return "listaFotoGuest";

	}
	@RequestMapping(value="/{idA}/confermaFoto", method=RequestMethod.POST)
	public String fotoInserita(@PathVariable("idA")Long idA,@Valid@ModelAttribute("foto1")Fotografia fotografia,Model model) {
		this.fotografiaService.inserisci(fotografia);
		Album album=this.albumService.findById(idA);
		this.fotografiaService.setAlbum(album, fotografia);
		model.addAttribute("foto1",fotografia);
		return "confermaFoto";

	}
	@RequestMapping(value="/photos",method= {RequestMethod.GET,RequestMethod.POST})
	public String tutteFoto(Model model){
		
		Richiesta richiesta=new Richiesta();
		this.richiestaService.inserisci(richiesta);
		
		
		model.addAttribute("richiesta",richiesta);
		model.addAttribute("foto",	this.fotografiaService.findAll());
		model.addAttribute("carrello",this.fotografiaService.getFotografiaPerRichiesta(richiesta));
		
		return "photos";
	}
	


}
