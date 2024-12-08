package pl.coderslab.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class SessionController {

    @GetMapping("/session")
    @ResponseBody
    public String sessionCheck(HttpSession session) {
        LocalDateTime loginStart = (LocalDateTime) session.getAttribute("loginStart");

        if (loginStart != null) {
            return loginStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        } else {
            LocalDateTime now = LocalDateTime.now();
            session.setAttribute("loginStart", now);
            return "Ustawiono loginStart: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
}
