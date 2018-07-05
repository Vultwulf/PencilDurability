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
     * The initial durability of the pencil point.
     */
    public int initPointDurability;

    /**
     * The current durability of the pencil point.
     */
    public int curPointDurability;

    /**
     * The initial length of the pencil.
     */
    public int initLength;

    /**
     * The current length of the pencil.
     */
    public int curLength;

    /**
     * Constructor Method for a pencil
     * @param pointDurability int containing the initial point durability.
     * @param length int containing the initial pencil length.
     */
    public PencilDurability(int pointDurability, int length) {
        this.initPointDurability = pointDurability;
        this.curPointDurability = pointDurability;
        this.initLength = length;
        this.curLength = length;
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

            if(text.charAt(i) == ' ') {
                // If this is a space, don't reduce point durability.
                this.paper += text.charAt(i);
            }
            else if(isUpperCase) {
                if (this.curPointDurability >= 2) {
                    // Append the next letter.
                    this.paper += text.charAt(i);

                    // Deduct two points of durability.
                    this.curPointDurability -= 2;
                } else {
                    // Append a space.
                    this.paper += ' ';
                }
            } else {
                if (this.curPointDurability >= 1) {
                    // Append the next letter.
                    this.paper += text.charAt(i);

                    // Deduct one points of durability.
                    this.curPointDurability -= 1;
                } else {
                    // Append a space.
                    this.paper += ' ';
                }
            }
        }
    }

    /**
     * Method to sharpen the pencil
     */
    public void sharpen() {
        // Set the current point durability to the initial point durability if the length is over 0.
        if(this.curLength > 0) {
            this.curPointDurability = this.initPointDurability;
            this.curLength -= 1;
        }
    }
}
