package pl.coderslab.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/first")
public class FormController {

    @PostMapping("/form")
    @ResponseBody
    public String handleForm(@RequestParam String paramName, @RequestParam("paramDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate paramDate) {
        System.out.println("paramName: " + paramName);
        System.out.println("paramDate: " + paramDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        return paramName + "-" + paramDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
