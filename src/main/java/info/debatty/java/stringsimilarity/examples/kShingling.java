/*
 * The MIT License
 *
 * Copyright 2015 Thibault Debatty.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package info.debatty.java.stringsimilarity.examples;

import java.util.ArrayList;
import info.debatty.java.stringsimilarity.Cosine;

/**
 *
 * @author Thibault Debatty
 * @author Alexander Dehn
 *
 */
public class kShingling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // K-Shingling
        System.out.println("\nK-Shingling");

        String[][] input = new String[5][6];
        input[0][0] = "Mayer";
        input[0][1] = "Heinz";
        input[0][2] = "Herr";
        input[0][3] = "Musterstraße";
        input[0][4] = "12345";
        input[0][5] = "hmayer@mail.com";

        input[1][0] = "Meier";
        input[1][1] = "Heinz";
        input[1][2] = "Herr";
        input[1][3] = "Musterstraße";
        input[1][4] = "12345";
        input[1][5] = "-";

        input[2][0] = "Mayer";
        input[2][1] = "H.";
        input[2][2] = "Herr";
        input[2][3] = "Musterstrasse";
        input[2][4] = "12345";
        input[2][5] = "hmayer@mail.com";

        input[3][0] = "Mayer";
        input[3][1] = "Heinz";
        input[3][2] = "Herr";
        input[3][3] = "Hauptstraße";
        input[3][4] = "45678";
        input[3][5] = "hmayer@mail.com";

        input[4][0] = "Mayer";
        input[4][1] = "Heinz";
        input[4][2] = "Herr";
        input[4][3] = "Hauptstraße";
        input[4][4] = "45678";
        input[4][5] = "mayer@web.com";

        Cosine cosine = new Cosine(3);

        for (int j = 0; j < input.length; j++) {

            System.out.println(j);
            for (int i = 0; i < input[0].length; i++) {
                System.out.println(cosine.getProfile(input[j][i]));
            }

        }
    }
}
