package glp.util;

import glp.domain.Categorie;
import glp.services.CategorieService;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CategorieFormatter implements Formatter<Categorie> {

	@Autowired
	CategorieService categorieService;
	@Override
	public String print(Categorie cat, Locale arg1) {
		return cat.getLib();
	}

	@Override
	public Categorie parse(String catId, Locale arg1) throws ParseException {
		return categorieService.getRowById(Integer.parseInt(catId));
	}

}
