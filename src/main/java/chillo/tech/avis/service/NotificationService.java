package chillo.tech.avis.service;

import chillo.tech.avis.entite.Validation;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationService {

    JavaMailSender javaMailSender;
    public void envoyer(Validation validation){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@chillo.tech");
        message.setTo(validation.getUtilisateur().getEmail());
        message.setSubject("Votre code d'activation");

       String texte = String.format("bonjour %s,  Votre code d'activation est %s, A bientot",
                validation.getUtilisateur().getNom(),
                validation.getCode());

        message.setText(texte);
        javaMailSender.send(message);
    }
}
