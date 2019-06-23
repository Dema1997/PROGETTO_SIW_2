package it.uniroma3.siw.authtest.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografo;
import it.uniroma3.siw.authtest.service.FotografoService;


@Controller
public class FotografoController {

	@Autowired
	private FotografoService fotografoService;


	public FotografoController() {
		super();
	}
	@RequestMapping(value = { "/fotografiAdmin" }, method = RequestMethod.GET)
	public String getFotografiGuest(Model model) {
		
		model.addAttribute("fotografi",this.fotografoService.tutti());
		model.addAttribute("fotografo",new Fotografo());

		return "fotografiAdmin";
	}

	@RequestMapping(value = { "/fotografi" }, method = RequestMethod.GET)
	public String getFotografi(Model model) {
		model.addAttribute("fotografi",this.fotografoService.tutti());
		return "fotografi";
	}
	@RequestMapping( "/fotografoForm" )
	public String getFotografoForm(Model model) {
		model.addAttribute("fotografo",new Fotografo());
		return "fotografoForm";
	}

	@RequestMapping(value="/fotografo", method= RequestMethod.POST)
	public String newFotografo(@Valid@ModelAttribute("fotografo")Fotografo fotografo,Model model) {
		
		
			this.fotografoService.inserisci(fotografo);
		
		//model.addAttribute("fotografi", this.fotografoService.tutti());

		return "conferma";

	}

	@RequestMapping(value="/fotografo/{idS}", method=RequestMethod.GET)
	public String getFotografo(@PathVariable("idS")Long idS,Model model) {
		Fotografo f=this.fotografoService.findById(idS);
        //f.getAlbum()
		if(idS!=null) {
			model.addAttribute("Albums", this.fotografoService.findByFotografo(f));
			model.addAttribute("album",new Album());
			model.addAttribute("fotografo", f);
			
			
			return "fotografo";
		}else {

			return "home";
		}
	}
	@RequestMapping(value="/guest/fotografo/{idS}", method=RequestMethod.GET)
	public String getFotografoGuest(@PathVariable("idS")Long idS,Model model) {
		Fotografo f=this.fotografoService.findById(idS);
        //f.getAlbum()
		if(idS!=null) {
			model.addAttribute("Albums", this.fotografoService.findByFotografo(f));
			model.addAttribute("fotografo", f);
			
			return "fotografoGuest";
		}else {

			return "home";
		}
	}

}


