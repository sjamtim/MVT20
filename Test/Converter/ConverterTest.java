package Converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConverterTest {
    Converter con = new Converter();


    @Test
        // Test incorrect english letter or symbol, return error.
    void testEnterIncorrectEnglishReturnError() {

        // Arrange
        String[] expected = {"<invalid sign>", "<invalid sign>"};

        // Act
        String[] actual = con.convertEngToMorse("*Ö");

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
        // Test incorrect morse code, return error.
    void testEnterIncorrectMorseReturnError() {

        // Arrange
        String[] expected = {"<invalid sign>"};

        // Act
        String[] actual = con.convertMorseToEng("ÅÄÖ*^`");

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
        // Test correct words returning correct morse code
    void testEnterWordsReturnMorseCode() {

        // Arrange
        String[] expected = {"....", ".", ".-..", ".-..", "---", "   ", ".--", "---", ".-.", ".-..", "-.."};

        // Act
        String[] actual = con.convertEngToMorse("HELLO WORLD");

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
        // Test correct morse code return correct words.
    void testEnterMorseCodeReturnWords() {

        // Arrange
        String[] expected = {"H", "E", "L", "L", "O", " ", "W", "O", "R", "L", "D"};

        // Act
        String[] actual = con.convertMorseToEng(".... . .-.. .-.. --- _ .-- --- .-. .-.. -..");

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
        // Test lower case input
    void testLowerCaseInput() {

        // Arrange

        String[] expected = {"--.."};

        // Act
        String[] actual = con.convertEngToMorse("z");

        // Assert
        assertArrayEquals(expected, actual);
    }
	/*
	@Test // removed because more complicated test after.
	void testEnterAReturnMorse() {

		// Arrange
		String[] expected = { ".-" };

		// Act
		String[] actual = con.convertEngToMorse("A");

		// Assert
		assertArrayEquals(expected, actual);

	}

	@Test
	void testEnterMorseReturnZ() {

		// Arrange
		String[] expected = { "Z" };

		// Act
		String[] actual = con.convertMorseToEng("--..");

		// Assert
		assertArrayEquals(expected, actual);
	}
	*/
}


