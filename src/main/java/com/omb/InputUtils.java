package com.omb;

import java.util.StringTokenizer;

public class InputUtils {

    public static void extractLocalisation(String localisation, Rover rover) {
        StringTokenizer tokenizer = new StringTokenizer(localisation, " ");
        if(tokenizer.countTokens() > 3) {
            throw new IllegalArgumentException("Mauvaises " +
                    "coordonnee : " + localisation);
        }

        int index = 0;
        while(tokenizer.hasMoreTokens()) {
            String d = tokenizer.nextToken();
            if(index == 0) {
                rover.getPosition().getLocation().setX(Integer.valueOf(d));
            } else if(index ==1) {
                rover.getPosition().getLocation().setY(Integer.valueOf(d));
            } else {
                Cardinal cardinal = Cardinal.getFromCode(d);
                rover.getPosition().setCardinal(cardinal);
            }

            index++;
        }
    }

    public static Matrix initMatrix(String sizeOfMatrix) {
        String [] coord = sizeOfMatrix.split(" ");
        if(coord.length > 2) {
            throw new IllegalArgumentException("Taille de la matrice pas " +
                    "bonne" +
                    " : " + sizeOfMatrix);
        }

        if(Character.isLetter(coord[0].charAt(0))) {
            throw new IllegalArgumentException("La coordonnee 1 n'est pas " +
                    "correcte : " + coord[0]);
        }

        if(Character.isLetter(coord[1].charAt(0))) {
            throw new IllegalArgumentException("La coordonnee 2 n'est pas " +
                    "correcte : " + coord[1]);
        }

        return new Matrix(Integer.valueOf(coord[0]),
                Integer.valueOf(coord[1]));
    }
}
