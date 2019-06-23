package it.uniroma3.siw.authtest.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.authtest.model.Album;



@Component 
public class AlbumValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Album.class.equals(arg0);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");
	}

	
}
