package com.wolfhaus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The PencilDurabilityTest implements all test-cases for use
 * of Test Driven Development for the Pencil Durability program.
 *
 * https://github.com/PillarTechnology/kata-pencil-durability
 *
 * @author  Scott Wolfenbarger
 * @version 1.0
 * @since   2018-07-05
 */
public class PencilDurabilityTest {

    /**
     * The VendingMachine object to be used with the tests.
     */
    private PencilDurability pencilDurability;

    /**
     * Test to identify the text written on a paper is equal to the instructed
     * text to write. This pencil has enough durability.
     */
    @Test
    public void testPencilWriteSeaShellsWithDurability() {
        // Instantiate a new pencil with 5000 point durability.
        this.pencilDurability = new PencilDurability(5000, 10, 10);

        // Sample text to write
        String text = "She sells sea shells sea shells down by the sea shore";

        // Instruct the pencil to write the sample text.
        this.pencilDurability.write(text);

        // The sample text should be the only text currently on the paper.
        assertEquals(text, this.pencilDurability.paper);
    }

    /**
     * Try to write "Text" with one point durability short.
     */
    @Test
    public void testPencilWriteTextWithoutFullDurability() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(4, 10, 10);

        // Sample text to write
        String text = "Text";

        // Instruct the pencil to write the sample text.
        this.pencilDurability.write(text);

        // The sample text should be the only text currently on the paper.
        assertEquals("Tex ", this.pencilDurability.paper);
    }

    /**
     * Test sharpening to continue writing after the pencil is dull with more length.
     */
    @Test
    public void testPencilWriteSharpenWriteWithDurabilityAndLength() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(22, 10, 10);

        // Sample text to write
        String text = "She sells sea shells s";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Sharpen the pencil
        this.pencilDurability.sharpen();

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // The sample text x2 should be the only text currently on the paper
        assertEquals(text + text, this.pencilDurability.paper);
    }

    /**
     * Test sharpening to continue writing after the pencil is dull with no more length.
     */
    @Test
    public void testPencilWriteSharpenWriteWithDurabilityAndNoLength() {
        // Instantiate a new pencil with 5 point durability.
        this.pencilDurability = new PencilDurability(22, 0, 10);

        // Sample text to write
        String text = "She sells sea shells sea s";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Sharpen the pencil
        this.pencilDurability.sharpen();

        // Instruct the pencil to write the sample text.
        this.pencilDurability.write(text);

        // The sample text and a second sample text all spaces appears on the paper
        assertEquals("She sells sea shells sea s                          "
                , this.pencilDurability.paper);
    }

    /**
     * Make sure the length is reduced when the pencil is sharpened.
     */
    @Test
    public void testPencilSharpenLengthReduction() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(22, 10, 10);

        // Sharpen the pencil
        this.pencilDurability.sharpen();

        // The sample text x2 should be the only text currently on the paper
        assertEquals(9, this.pencilDurability.curLength);
    }

    /**
     * Make sure the current point durability is reset.
     */
    @Test
    public void testPencilSharpenPointDurabilityReset() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(22, 10, 10);

        // Sample text to write
        String text = "She sells sea shells s";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Sharpen the pencil
        this.pencilDurability.sharpen();

        // The sample text x2 should be the only text currently on the paper
        assertEquals(22, this.pencilDurability.curPointDurability);
    }

    /**
     * Make sure a word can be erased
     */
    @Test
    public void testPencilEraseChuck() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(5000, 10, 10);

        // Sample text to write
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        String newText = "How much wood would a woodchuck chuck if a woodchuck could       wood?";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Instruct the pencil to erase the string "chuck"
        this.pencilDurability.erase("chuck");

        assertEquals(newText, this.pencilDurability.paper);
    }

    /**
     * Test erasing the same word twice.
     */
    @Test
    public void testPencilEraseChuckAgain() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(5000, 10, 10);

        // Sample text to write
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        String expectedText = "How much wood would a woodchuck chuck if a wood      could       wood?";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Instruct the pencil to erase the string "chuck"
        this.pencilDurability.erase("chuck");

        // Instruct the pencil to erase the string "chuck"
        this.pencilDurability.erase("chuck");

        assertEquals(expectedText, this.pencilDurability.paper);
    }

    /**
     * Test the eraser durability
     */
    @Test
    public void testPencilEraseWoodchuckWithoutEnoughDurability() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(5000, 10, 8);

        // Sample text to write
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        String expectedText = "How much wood would a woodchuck chuck if a w         could chuck wood?";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Instruct the pencil to erase the string "woodchuck"
        this.pencilDurability.erase("woodchuck");

        assertEquals(expectedText, this.pencilDurability.paper);
    }

    /**
     * Test the erase with edit functionality
     */
    @Test
    public void testPencilEraseWoodchuckReplaceChuckwood() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(500, 10, 10);

        // Sample text to write
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        String expectedText = "How much wood would a woodchuck chuck if a chuckwood could chuck wood?";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Instruct the pencil to erase the string "woodchuck" and insert in "chuckwood"
        this.pencilDurability.eraseWithEdit("woodchuck", "chuckwood");

        assertEquals(expectedText, this.pencilDurability.paper);
    }

    /**
     * Test the erase with edit functionality with collision
     */
    @Test
    public void testPencilEraseAppleReplaceArtichoke() {
        // Instantiate a new pencil.
        this.pencilDurability = new PencilDurability(500, 10, 10);

        // Sample text to write
        String text = "An apple a day keeps the doctor away";
        String expectedText = "An artich@k@ay keeps the doctor away";

        // Instruct the pencil to write the sample text
        this.pencilDurability.write(text);

        // Instruct the pencil to erase the string "woodchuck" and insert in "chuckwood"
        this.pencilDurability.eraseWithEdit("apple", "artichoke");

        assertEquals(expectedText, this.pencilDurability.paper);
    }
}
