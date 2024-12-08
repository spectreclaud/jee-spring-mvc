package pl.coderslab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {

    @GetMapping(value = "/show-random", produces = "text/plain;charset=UTF-8")
    public String showRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return "Wylosowano liczbę: " + randomNumber;
    }
}
