package Converter;
import java.util.Scanner;

public class Printer {
    private String input;

    private Converter con = new Converter();
    private Scanner scan = new Scanner(System.in);

    public void welcomeMenu() {
        while (true) {
            System.out.println("-----------------------------------------------\n");
            System.out.println("Hello and welcome to the morse code converter!\n");
            System.out.println("What do you want to convert? \nEnter a valid number:\n");
            System.out.println("1. English -> Morse code");
            System.out.println("2. Morse code -> English");
            System.out.println("3. Exit\n");
            System.out.println("-----------------------------------------------");
            try {
                int choice = Integer.valueOf(scan.nextLine());
                converterMenu(choice);
            } catch (Exception e) {
                System.out.println("Sorry, please enter a number");  // ERROR HANDLER - if user writing letters in the menu.
            }
        }
    }

    public void converterMenu(int option) {

        switch (option) {
            case 1:
                printEnglishToMorse();
                break;
            case 2:
                printMorseToEnglish();
                break;
            case 3:
                System.out.println("Thanks for using me! Bye..");
                System.exit(0);
                break;
            default:
                System.out.println("Didnt get what you mean? Try again..."); // ERROR HANLDER - for other numbers than 1,2,3.
                break;
        }
    }

    private String takesEnglishInput() {
        System.out.println("What to you want to translate from english to morse?");
        String englishWord = scan.nextLine();
        return englishWord;
    }

    private String takesMorseInput() {
        System.out.println("What to you want to translate from morse to english?");
        System.out.println("!OBS! Add space between morse letters and add _ between each word in a sentance. !OBS!");
        System.out.println("Example for HELLO WORLD ---> .... . .-.. .-.. --- _ .-- --- .-. .-.. -..");
        String morseCode = scan.nextLine();
        return morseCode;
    }

    // Takes the input from takesEnglishInput method and prints out in morse code.
    private void printEnglishToMorse() {
        input = takesEnglishInput();
        String[] translatedLetters = con.convertEngToMorse(input);
        for (int i = 0; i < translatedLetters.length; i++) {
            System.out.print(translatedLetters[i] + " ");
        }
        System.out.println("");

    }

    // Takes the input from takesMorseInput method and prints out in english.
    private void printMorseToEnglish() {
        input = takesMorseInput();
        String[] translatedCodes = con.convertMorseToEng(input);
        for (int i = 0; i < translatedCodes.length; i++) {
            System.out.print(translatedCodes[i]);
        }
        System.out.println("\n");
    }
}


