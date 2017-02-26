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

import info.debatty.java.stringsimilarity.*;
import java.util.ArrayList;

/**
 *
 * @author Thibault Debatty
 * @author Alexander Dehn
 */
public class NormalizedLevenshtein {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Levenshtein
        // ===========
        System.out.println("\nLevenshtein");
        info.debatty.java.stringsimilarity.NormalizedLevenshtein normalizedLevenshtein = new info.debatty.java.stringsimilarity.NormalizedLevenshtein();

        //Variablen Definition
        double total = 0, result;
        int l = 0;
        double match = 0.85;
        double maxDistance = 0.1;

        String[][] input = new String[5][6];
        ArrayList<String> topOutput = new ArrayList<String>();
        input[0][0] = "Mayer";
        input[0][1] = "Heinz";
        input[0][2] = "Herr";
        input[0][3] = "Musterstraße";
        input[0][4] = "12345";
        input[0][5] = "hmayer@mail.com";
        //input[0][6] = "Berlin";
        //input[0][7] = "7";

        input[1][0] = "Meier";
        input[1][1] = "Heinz";
        input[1][2] = "Herr";
        input[1][3] = "Musterstraße";
        input[1][4] = "12345";
        input[1][5] = "-";
        //input[1][6] = "Berlin";
        //input[1][7] = "7";

        input[2][0] = "Mayer";
        input[2][1] = "H.";
        input[2][2] = "Herr";
        input[2][3] = "Musterstrasse 7";
        input[2][4] = "12345";
        input[2][5] = "hmayer@mail.com";
        //input[2][6] = "Berlin";
        //input[2][7] = "7";

        input[3][0] = "Mayer";
        input[3][1] = "Heinz";
        input[3][2] = "Herr";
        input[3][3] = "Hauptstraße";
        input[3][4] = "45678";
        input[3][5] = "hmayer@mail.com";
        //input[3][6] = "München";
        //input[3][7] = "63";

        input[4][0] = "Mayer";
        input[4][1] = "Heinz";
        input[4][2] = "Herr";
        input[4][3] = "Hauptstraße";
        input[4][4] = "12345";
        input[4][5] = "mayer@web.com";
        //input[4][6] = "Berlin";
        //input[4][7] = "7";

        for (int k = 0; k < input.length; k++) {

            for (int j = 1; j < input.length; j++) {


                if (k < j && j != k) {

                    System.out.println(k + " & " + j);
                    for (int i = 0; i < input[0].length; i++) {
                        result = normalizedLevenshtein.distance(input[j][i], input[k][i]);
                        System.out.println("Vergleich: " + input[j][i] + " mit " + input[k][i] + ": " + result);
                        total += result;
                    }

                    System.out.println("\nVergleichsergebnis Datensätze:");
                    System.out.println(total);
                    System.out.println("Normalized Levenshtein distance: " + (total / (input[0].length)));
                    System.out.println("\n");
                    if ((total / (input[0].length)) < maxDistance) {
                        topOutput.add(k + " & " + j);
                    }
                        total = 0;
                }


            }

        }
        System.out.println("Distanz geringer als " + (maxDistance*100) + "%");
        for (String s : topOutput) {
            System.out.println(s);
        }
    }
}