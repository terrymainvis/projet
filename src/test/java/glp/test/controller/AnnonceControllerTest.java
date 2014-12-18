package glp.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import glp.controller.AnnonceController;
import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Utilisateur;
import glp.services.AnnonceService;
import glp.services.CategorieService;
import glp.services.UtilisateurService;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

public class AnnonceControllerTest extends TestCase{
	
	@InjectMocks
	private AnnonceController controller = new AnnonceController();
	
	@Mock
	private AnnonceService mockAnnonceService;
	
	@Mock
	private CategorieService mockCategorieService;
	
	@Mock
	private UtilisateurService mockUtilisateurService;
	
	@Mock
	View mockView;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build();
	}

	@Test
	public void testGetCreateAnnForm() throws Exception {
		//Utilisation des methodes de service utilisees dans le controller avec des mocks
		// ici utilisateurService.getUserInSession() et categorieService.getList()
		 List<Categorie> expectedCategorie = Arrays.asList(new Categorie());
		 when(mockCategorieService.getList()).thenReturn(expectedCategorie);
		 
		 Utilisateur user = new Utilisateur();
		 when(mockUtilisateurService.getUserInSession()).thenReturn(user);
		 
		 // Test des resultats obtenu grace aux mocks de services
		this.mockMvc.perform(get("/annonce/new"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("catList", expectedCategorie))
			.andExpect(model().attribute("utilisateur", user));
	}
	
	@Test
	public void testGetAllAnnonce() throws Exception{
		List<Annonce> expectedAnnonce = Arrays.asList(new Annonce());
		when(mockAnnonceService.getList()).thenReturn(expectedAnnonce);
		
		mockMvc.perform(get("/annonce/list"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("annList", expectedAnnonce))
			.andExpect(view().name("ann_list"));
	}
	
	@Test
	public void testGetAnnonceViaRecherche() throws Exception{
		List<Annonce> expectedAnnonce = Arrays.asList(new Annonce());
		when(mockAnnonceService.getListByCatEtMot("UneCategorie", "UnMotCle")).thenReturn(expectedAnnonce);
		
		mockMvc.perform(get("/annonce/recherche?cat=UneCategorie&motCle=UnMotCle"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("annList", expectedAnnonce))
			.andExpect(view().name("ann_list"));
	}
	
	@Test
	public void testAddAnnonce() throws Exception{
		mockMvc.perform(get("/annonce/addAnn"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("annonce"))
			.andExpect(view().name("redirect:/"));
	}

}
