package pl.rutkowski.zadanie22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudioController {

    private final MailService mailService;

    public StudioController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/offer")
    public String offer() {
        return "offer";
    }

    @GetMapping("/contact")
    public String email() {
        return "email";
    }

    @PostMapping("/save")
    public String getMessage(MailDto mailDto) {
        try {
            mailService.sendMail(mailDto);
            return "redirect:success";
        } catch (Exception e) {
            return "redirect:error";

        }

    }
}
