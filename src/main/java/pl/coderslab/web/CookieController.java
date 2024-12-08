package pl.coderslab.web;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

@Controller
public class CookieController {

    @RequestMapping("/setcookie/{value1}/{value2}")
    @ResponseBody
    public String setCookie(@PathVariable String value1,
                            @PathVariable String value2,
                            HttpServletResponse response) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        cookie1.setPath("/");
        response.addCookie(cookie1);

        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie2.setPath("/");
        response.addCookie(cookie2);

        return "Cookies set";
    }

    @GetMapping("/getcookies")
    @ResponseBody
    public String getCookies(HttpServletRequest request,
                             @CookieValue(value = "cookie1", defaultValue = "defaultCookie1") String cookie1Value,
                             @CookieValue(value = "cookie2", defaultValue = "defaultCookie2") String cookie2Value) {
        Cookie cookie1WebUtils = WebUtils.getCookie(request, "cookie1");
        Cookie cookie2WebUtils = WebUtils.getCookie(request, "cookie2");

        String cookie1WebUtilsValue = (cookie1WebUtils != null) ? cookie1WebUtils.getValue() : "Brak cookie1 (WebUtils)";
        String cookie2WebUtilsValue = (cookie2WebUtils != null) ? cookie2WebUtils.getValue() : "Brak cookie2 (WebUtils)";

        System.out.println("Cookie1 (WebUtils): " + cookie1WebUtilsValue);
        System.out.println("Cookie2 (WebUtils): " + cookie2WebUtilsValue);

        System.out.println("Cookie1 (@CookieValue): " + cookie1Value);
        System.out.println("Cookie2 (@CookieValue): " + cookie2Value);

        return "Cookies retrieved";
    }
}
