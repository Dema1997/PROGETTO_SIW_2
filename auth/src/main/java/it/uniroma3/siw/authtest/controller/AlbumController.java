package it.uniroma3.siw.authtest.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.authtest.model.Album;
import it.uniroma3.siw.authtest.model.Fotografo;
import it.uniroma3.siw.authtest.service.AlbumService;
import it.uniroma3.siw.authtest.service.AlbumValidator;
import it.uniroma3.siw.authtest.service.FotografoService;


@Controller
public class AlbumController {


	@Autowired
	private AlbumService albumService;
	@Autowired
	private AlbumValidator albumValidator;

	@Autowired
	private FotografoService fotografoService;


	public AlbumController() {
		super();
	}

	@RequestMapping(value="/fotografo/{idS}/album", method= RequestMethod.POST)
	public String newAlbum(@PathVariable("idS")Long idS,@Valid@ModelAttribute("album")Album album,Model model,BindingResult bindingResult) {
		Fotografo fotografo=this.fotografoService.fotografoPerId(idS);
		this.albumValidator.validate(album, bindingResult);
		
		if(!bindingResult.hasErrors()) {
		this.albumService.setFotografo(album, fotografo);
		this.albumService.inserisci(album);
		
		model.addAttribute("album",this.albumService.getAlbumPerFotografo(fotografo));

		return "listaAlbum";
		}else {
			model.addAttribute("Albums", this.fotografoService.findByFotografo(fotografo));
			model.addAttribute("album",new Album());
			model.addAttribute("fotografo", fotografo);
			return "fotografo";
		}

	}
	
	
}
