package com.wolfhaus;

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
     * Test to identify the text written on a paper is equal to the instructed
     * text to write.
     */
    @Test
    public void testPencilWriteSeaShells() {
        PencilDurability pencilDurability = new PencilDurability();

        // Sample text to write
        String text = "She sells sea shells sea shells down by the sea shore";

        // Instruct the pencil to write the sample text.
        pencilDurability.write(text);

        // The sample text should be the only text currently on the paper.
        assertEquals(text, pencilDurability.paper);

    }
}
