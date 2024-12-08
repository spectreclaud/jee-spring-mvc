package pl.coderslab.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SampleController {
    Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/random/{max}")
    @ResponseBody
    public String hello(@PathVariable int max) {
        try {
            Random random = new Random();
            int randomNumber = random.nextInt(max) + 1;
            return "Uzytkownik podal wartosc " + max + ". Wylosowano liczbe: " + randomNumber;
        } catch (IllegalArgumentException e) {
            return "Blad: Wartosc 'max' musi być wieksza od 0.";
        }
    }
}
