package com.wolfhaus;

/**
 * The PencilDurability program implements an application that
 * satisfies the requirements of the kata-pencil-durability
 * project.
 *
 * https://github.com/PillarTechnology/kata-pencil-durability
 *
 * @author  Scott Wolfenbarger
 * @version 1.0
 * @since   2018-07-05
 */
public class PencilDurability {

    /**
     * The paper the pencil will write text on.
     */
    public String paper = "";

    /**
     * The durability of the pencil point.
     */
    public int pointDurability;

    /**
     * Constructor Method for a pencil
     * @param pointDurability int containing the point durability.
     */
    public PencilDurability(int pointDurability) {
        this.pointDurability = pointDurability;
    }

    /**
     * Method to write text on a paper
     * @param text string containing text to be written to the paper.
     */
    public void write(String text) {
        // Check durability before writing the letter to the paper.
        for (int i = 0; i < text.length(); i++) {
            // Determine if this letter is upper case
            boolean isUpperCase = Character.isUpperCase(text.charAt(i));

            if(isUpperCase) {
                if (this.pointDurability >= 2) {
                    // Append the next letter.
                    this.paper += text.charAt(i);

                    // Deduct two points of durability.
                    this.pointDurability -= 2;
                } else {
                    // Append a space.
                    this.paper += ' ';
                }
            } else {
                if (this.pointDurability >= 1) {
                    // Append the next letter.
                    this.paper += text.charAt(i);

                    // Deduct one points of durability.
                    this.pointDurability -= 1;
                } else {
                    // Append a space.
                    this.paper += ' ';
                }
            }
        }
    }
}
