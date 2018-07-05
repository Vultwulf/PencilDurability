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
    String paper = "";

    /**
     * The initial durability of the pencil point.
     */
    private final int initPointDurability;

    /**
     * The current durability of the pencil point.
     */
    int curPointDurability;

    /**
     * The durability of the eraser.
     */
    int eraserDurability;

    /**
     * The length of the pencil.
     */
    int length;

    /**
     * Constructor Method for a pencil
     * @param pointDurability int containing the initial point durability.
     * @param length int containing the initial pencil length.
     * @param eraserDurability int containing the initial eraser durability.
     */
    public PencilDurability(int pointDurability, int length, int eraserDurability) {
        this.initPointDurability = pointDurability;
        this.curPointDurability = pointDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
    }

    /**
     * Method to write text on a paper
     * @param text string containing text to be written to the paper.
     */
    public void write(String text) {
        StringBuilder sb = new StringBuilder();

        // Check durability before writing the letter to the paper.
        for (int i = 0; i < text.length(); i++) {
            if(processCharacter(text.charAt(i))) {
                // This character was written.
                 sb.append(text.charAt(i));
            } else {
                // A space was written.
                sb.append(" ");
            }
        }

        this.paper += sb.toString();
    }

    /**
     * Method to determine if a character can be written, and then
     * reduce the durability.
     * @param character char containing the letter to be written.
     */
    private boolean processCharacter(char character) {
        // Determine if this letter is upper case
        boolean isUpperCase = Character.isUpperCase(character);
        boolean isCharacterWritten = false;

        if(character == ' ' || character == '\n') {
            // If this is a space or newline, don't reduce point durability.
            isCharacterWritten = true;
        } else if(isUpperCase) {
            if (this.curPointDurability >= 2) {
                // Deduct two points of durability.
                this.curPointDurability -= 2;
                isCharacterWritten = true;
            }
        } else {
            if (this.curPointDurability >= 1) {
                // Deduct one points of durability.
                this.curPointDurability -= 1;
                isCharacterWritten = true;
            }
        }

        return isCharacterWritten;
    }

    /**
     * Method to sharpen the pencil
     */
    public void sharpen() {
        // Set the current point durability to the initial point durability if the length is over 0.
        if(this.length > 0) {
            this.curPointDurability = this.initPointDurability;
            this.length -= 1;
        }
    }

    /**
     * Method to erase text
     * @param string string containing the word to be erased
     */
    public void erase(String string) {
        eraseWithEdit(string, "");
    }

    /**
     * Method to erase text, with the option of a replacement word
     * @param string string containing the word to be erased
     * @param newString string containing the word to replace string
     */
    public void eraseWithEdit(String string, String newString) {
        // Find the first character of where last occurrence of a string is in the text.
        int charIndex = this.paper.lastIndexOf(string);

        // Only process erasure if the word was actually found.
        if(charIndex != -1) {
            // Convert the paper to a char array for easy editing.
            char[] editPaper = this.paper.toCharArray();

            // Loop through the last instance of the found string and erase
            for (int i = charIndex + string.length() - 1; i >= charIndex; i--) {
                // If there is eraser durability, erase a letter.
                if (eraserDurability > 0) {
                    editPaper[i] = ' ';
                    this.eraserDurability--;
                }
            }

            // If the new string exists, replace it on the paper.
            if (newString.length() > 0) {
                int j = 0;
                // Insert the new string into the old string's place
                for (int i = charIndex; i < charIndex + newString.length(); i++) {
                    if (processCharacter(newString.charAt(j))) {
                        if (editPaper[i] == ' ') {
                            editPaper[i] = newString.charAt(j);
                        } else {
                            editPaper[i] = '@';
                        }
                    }
                    j++;
                }
            }

            // Set the paper to the new value after erasing
            this.paper = String.valueOf(editPaper);
        }
    }
}
