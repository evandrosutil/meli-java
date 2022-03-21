package com.meli.romanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.meli.romanos.util.ConvertToRoman;

@RestController
public class Controller {

    @GetMapping("/romanos/{decimal}")
    public String converToRoman(@PathVariable("decimal") int decimal) {

        // maior número romano é 3888
        if (decimal <= 3888) {
            return ConvertToRoman.integerToRoman5(decimal);
        }
        return "Número não pode ser convertido: MMDCCCLXXXVIII é o maior algarismo romano";
    }
}
