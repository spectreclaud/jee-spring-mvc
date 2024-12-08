package pl.coderslab.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
public class FreeTimeController {

    @GetMapping("/free-time")
    public String freeTime() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime time = now.toLocalTime();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return "Wolne";
        } else {
            LocalTime nine = LocalTime.of(9, 0);
            LocalTime five = LocalTime.of(17, 0);
            if (time.isAfter(nine.minusNanos(1)) && time.isBefore(five.plusNanos(1))) {
                return "Pracuje, nie dzwoń.";
            } else {
                return "Po Pracy";
            }
        }
    }
}
