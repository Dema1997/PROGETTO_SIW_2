package it.uniroma3.siw.authtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.authtest.model.Fotografia;
import it.uniroma3.siw.authtest.model.Richiesta;
import it.uniroma3.siw.authtest.service.FotografiaService;
import it.uniroma3.siw.authtest.service.RichiestaService;

@Controller
public class RichiestaController {

		@Autowired
		private RichiestaService richiestaService;
		@Autowired
		private FotografiaService fotografiaService;
		
		@RequestMapping(value="/aggiornaCarrello/{idR}/{nome}",method= {RequestMethod.GET,RequestMethod.POST})
		public String aggiornaCarrello(@PathVariable("idR")Long idR,@PathVariable("nome")String nome,Model model) {
			//foto.set(richiesta)
			//mode.add foto
			Richiesta richiesta=this.richiestaService.findById(idR);
			Fotografia foto=this.fotografiaService.findByNome(nome);
			this.fotografiaService.setRichiesta(foto,richiesta);
			
			model.addAttribute("richiesta", richiesta);
			model.addAttribute("carrello",this.fotografiaService.getFotografiaPerRichiesta(richiesta));
			model.addAttribute("foto",this.fotografiaService.findAll());
			
			return "photos";
		}
		
		@RequestMapping(value="/richieste",method=RequestMethod.GET)
		public String getRichieste(Model model) {
			model.addAttribute("richieste",this.richiestaService.findAll());
			
			return "richieste";
			
		}
}
