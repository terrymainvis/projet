package glp.util;

import javax.transaction.Transactional;

import glp.domain.Annonce;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AnnonceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Annonce.class.equals(clazz);
	}

	@Override
	@Transactional
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre",
				"titre.empty", "Le renseignement d'un titre est obligatoire");
		Annonce annonce = (Annonce) obj;
		
		if(annonce.getTitre().length() < 4){
			errors.rejectValue("titre", "tropCourt", "Le titre doit faire plus de 4 caractères");
		}
		if(annonce.getTitre().length() > 30){
			errors.rejectValue("titre", "tropLong", "Le titre doit faire moins de 30 caractères");
		}
		if(annonce.getTitre().length() < 4){
			errors.rejectValue("desc", "tropCourt", "La description doit faire plus de 4 caractères");
		}
		if(annonce.getTitre().length() > 200){
			errors.rejectValue("desc", "tropLong", "La description doit faire moins de 200 caractères");
		}

	}

}
