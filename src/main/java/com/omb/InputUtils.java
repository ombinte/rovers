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
}
