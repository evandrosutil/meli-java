package com.person.age.controllers;

import com.person.age.util.CalcAge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AgeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("{day}/{month}/{year}")
    public int CalcAge(@PathVariable("day") int day,
                          @PathVariable("month") int month,
                          @PathVariable("year") int year) {
        return CalcAge.execute(year, month, day);
    }
}
