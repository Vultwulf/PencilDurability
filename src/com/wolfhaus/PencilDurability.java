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
    public String paper;

    /**
     * Method to write text on a paper
     * @param text string containing text to be written to the paper.
     */
    public void write(String text) {
        this.paper = text;
    }
}
