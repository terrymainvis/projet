package glp.tests;

import glp.dao.UtilisateurDaoImpl;
import glp.domain.Utilisateur;
import glp.services.UtilisateurServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@ContextConfiguration(locations = {"classpath:/WEB-INF/spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilisateurTest {

	@InjectMocks
	@Autowired
	private UtilisateurServiceImpl serv_u;
	
	@Mock
	private UtilisateurDaoImpl dao_user;
		
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGeneral() {
						
//		when(dao_user.save(any(Utilisateur.class))).thenReturn(Long.valueOf(1));
		
		Assert.assertNotNull(serv_u);		
		Utilisateur user = new Utilisateur("toto", "dep", "toto.dep@univ.fr");
		serv_u.insertRow(user);
		
		
		/*
		Categorie cat = new Categorie("categorie test", "youpi");
		serv_cat.insertRow(cat);
		
		Annonce annonce = new Annonce("annonce test", "je suis une annonce test", new Date(), cat, user);		
		serv_a.insertRow(annonce);
		*/
	}
}
