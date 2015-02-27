package glp.util;

import glp.domain.Annonce;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class EmailSender {
	
	public static boolean sendMail(String mailTo, String mailFrom, String content,
			Annonce ann) {
		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtps.univ-lille1.fr");
		props.put("mail.smtps.auth", "true");
		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(mailFrom));

			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailTo, false));
			msg.setSubject("Lille 1 community - " + "Votre annonce " + ann.getTitre());
			msg.setText(content);
			msg.setSentDate(new Date());
			SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
			t.connect("smtps.univ-lille1.fr", "terry.mainvis@etudiant.univ-lille1.fr",
					"lille1community@");
			t.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Response: " + t.getLastServerResponse());
			t.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}

	}


}
