package com.meli.morse.util;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Converter {

    private static final Map<String,String> morseText = Map.ofEntries(
            entry(".-", "A"),
            entry("-...", "B"),
            entry("-.-.", "C"),
            entry("-..", "D"),
            entry(".", "E"),
            entry("..-.", "F"),
            entry("--.", "G"),
            entry("....", "H"),
            entry("..", "I"),
            entry(".---", "J"),
            entry("-.-", "K"),
            entry(".-..", "L"),
            entry("--", "M"),
            entry("-.", "N"),
            entry("--.--", "Ñ"),
            entry("---", "O"),
            entry(".--.", "P"),
            entry("--.-", "Q"),
            entry(".-.", "R"),
            entry("...", "S"),
            entry("-", "T"),
            entry("..-", "U"),
            entry("...-", "V"),
            entry(".--", "W"),
            entry("-..-", "X"),
            entry("-.--", "Y"),
            entry("--..", "Z"),
            entry("-----", "0"),
            entry(".----", "1"),
            entry("..---", "2"),
            entry("...--", "3"),
            entry("....-", "4"),
            entry(".....", "5"),
            entry("-....", "6"),
            entry("--...", "7"),
            entry("---..", "8"),
            entry("----.", "9"),
            entry(".-.-.-", "."),
            entry("--..--", ","),
            entry("---...", ":"),
            entry("..--..", "?"),
            entry(".----.", "'"),
            entry("-....-", "-"),
            entry("-..-.", "/"),
            entry(".-..-.", "\""),
            entry(".--.-.", "@"),
            entry("-...-", "="),
            entry("−.−.−−", "!"));

    public static String morseToText(String morseCode) {
        List<String> text = new ArrayList<>();

        // split words
        String[] words = morseCode.split("\\s{3}");
        for (String word:
             words) {

            //split 'letters'
            String[] letters = word.split("\\s");
            String decodedWord = "";
            for (String morseLetter:
                 letters) {
                if (morseLetter.equals("")) {
                    continue;
                }
                decodedWord = decodedWord.concat(morseText.get(morseLetter));
            }
            text.add(decodedWord);
        }

        String decodedText = String.join(" ", text);
        return decodedText;
    }
}
