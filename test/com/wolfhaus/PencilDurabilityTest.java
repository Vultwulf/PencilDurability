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
        this.pencilDurability = new PencilDurability(5000);

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
        // Instantiate a new pencil with 5 point durability.
        this.pencilDurability = new PencilDurability(4);

        // Sample text to write
        String text = "Text";

        // Instruct the pencil to write the sample text.
        this.pencilDurability.write(text);

        // The sample text should be the only text currently on the paper.
        assertEquals("Tex ", this.pencilDurability.paper);
    }
}
