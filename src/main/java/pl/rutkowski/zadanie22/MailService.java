package pl.rutkowski.zadanie22;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void getMail(MailDto mailDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("studiotest@op.pl");
        mailMessage.setFrom("studiotest@op.pl");
        mailMessage.setSubject(mailDto.getName() + " " + mailDto.getEmail());
        mailMessage.setText(mailDto.getContent());
        javaMailSender.send(mailMessage);
    }

    public void sendMail(MailDto mailDto) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setReplyTo(mailDto.getEmail()); kiedy uzywam tej metody, mail nie jest wysylany do podanego maila
        mailMessage.setTo(mailDto.getEmail());
        mailMessage.setFrom("studiotest@op.pl");
        mailMessage.setSubject("Otrzymaliśmy Twoją wiadomość");
        mailMessage.setText("Dziękujemy za kontakt, odezwiemy się niebawem");
        javaMailSender.send(mailMessage);

    }


}
