package Converter;
import java.util.HashMap;

public class Converter {
    // Creating two HashMaps that is empty (its being filled in the constructor)
    private final HashMap<String, String> englishToMorseMap = new HashMap<String, String>();
    private final HashMap<String, String> morseToEnglishMap = new HashMap<String, String>();

    // Creating array for english words.
    private String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ",", ".",
            "?", " ", " "};

    // Creating array for morse code.
    private String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".---.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "--..--",
            ".-.-.-", "..--..", "_", "   "};

    // Constructor is filling the two HashMaps with letters and morse code from the english and morse arrays.
    public Converter() {


        for (int i = 0; i < english.length; i++) {
            englishToMorseMap.put(english[i], morse[i]);
        }

        for (int i = 0; i < morse.length; i++) {
            morseToEnglishMap.put(morse[i], english[i]);
        }

    }

    // Converts English To Morse
    public String[] convertEngToMorse(String wordInput) {
        wordInput = wordInput.toUpperCase(); // ERROR HANDLER - Converts input to upper case letters.
        String[] engLetters = wordInput.split(""); // Splitting input to separate letters and saves them in the array
        for (int i = 0; i < engLetters.length; i++) { // Looping over all the letters in the string array.
            if (englishToMorseMap.containsKey(engLetters[i])) {  // Checks if the letters in the array is in the english hashmap
                engLetters[i] = englishToMorseMap.get(engLetters[i]);  // Saves morse code in wordInput to the array letters.
            } else {
                engLetters[i] = "<invalid sign>"; // ERROR HANDLER - Prints out <invalid sign> if input not contained in the array.
            }
        }
        return engLetters;
    }

    // Converts Morse to English
    public String[] convertMorseToEng(String wordInput) {
        String[] morseLetters = wordInput.split(" ");
        for (int i = 0; i < morseLetters.length; i++) {
            if (morseToEnglishMap.containsKey(morseLetters[i])) {
                morseLetters[i] = morseToEnglishMap.get(morseLetters[i]);
            } else {

                morseLetters[i] = "<invalid sign>";

            }
        }
        return morseLetters;
    }

}
