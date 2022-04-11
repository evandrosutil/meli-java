package com.meli.morse.api;

import com.meli.morse.util.Converter;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @GetMapping("/convert")
    @ResponseBody
    public String convertToText(@RequestParam String message) {
        return Converter.morseToText(message);
    }
}
