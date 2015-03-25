package glp.util;

import glp.domain.Annonce;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sun.mail.smtp.SMTPTransport;

public class EmailSender {
	
	/**
	 * le fichier XML pour les emails n'existe pas encore, creation de celui ci
	 */
	public static void enregistreFichier() {
		
		Element racine = new Element("email-config");
		Document doc = new Document(racine);
		
		Element smtps = new Element("mail.smtps.host");
		smtps.setText("smtps.univ-lille1.fr");
		
		Element login = new Element("login");
		login.setText("a renseigner");
		
		Element password = new Element("password");
		password.setText("a renseigner");
		
		Element sujet_msg = new Element("sujet-msg");
		sujet_msg.setText("Lille 1 community - Votre annonce ");
				
		racine.addContent(smtps);
		racine.addContent(login);
		racine.addContent(password);
		racine.addContent(sujet_msg);
		
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(doc, new FileOutputStream("email-config.xml"));
		}
		catch(IOException e) {
			System.out.println("Erreur lors de la sauvegarde du fichier email-config.xml");
		}
	}
	
	public static boolean sendMail(String mailTo, String mailFrom, String content,
			Annonce ann) {
		
		//récupère le fichier de config pour l'envoi du mail
		SAXBuilder sxb = new SAXBuilder();
		Document document;
		try {
			File fichier = new File("email-config.xml");
			document = sxb.build(fichier);
			System.out.println(fichier.getAbsolutePath());
		
			Element racine = document.getRootElement();
			
			String host = racine.getChild("mail.smtps.host").getText();
			String sujet = racine.getChild("sujet-msg").getText();
			String login = racine.getChild("login").getText();
			String password = racine.getChild("password").getText();
						
			Properties props = System.getProperties();
			props.put("mail.smtps.host", host);
			props.put("mail.smtps.auth", "true");
			Session session = Session.getInstance(props, null);
			Message msg = new MimeMessage(session);
			
				msg.setFrom(new InternetAddress(mailFrom));
	
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(mailTo, false));
				msg.setSubject(sujet + ann.getTitre());
				msg.setText(content);
				msg.setSentDate(new Date());
				SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
				t.connect(host, login, password);
				t.sendMessage(msg, msg.getAllRecipients());
				System.out.println("Response: " + t.getLastServerResponse());
				t.close();
				
				return true;
			
		} catch (IOException e1) {
			enregistreFichier();
		} 
		catch (MessagingException e2) {
			e2.printStackTrace();
			return false;
		} catch (JDOMException e3) {
			enregistreFichier();
		}		
		return false;
	}
}
