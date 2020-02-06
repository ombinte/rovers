package com.omb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainLauncher {

    public static void main(String args[]) {

        try {

            if (args.length > 0) {
                List<Rover> rovers = new ArrayList<>();

                // Lecture du fichier et recuperation de la liste des
                // position des rovers ainsi que des mouvements
                Path currentRelativePath = Paths.get(args[0]);

                // Initialisation du plateau
                String sizeOfMatrix =
                        Files.lines(currentRelativePath).findFirst().orElse("");
                if(sizeOfMatrix.isEmpty()) {
                    throw new IllegalArgumentException("Taille de la matrice " +
                            "non definie !!");
                }
                Matrix matrix = InputUtils.initMatrix(sizeOfMatrix);

                Stream<String> linesRover = Files.lines(currentRelativePath);
                List<String> startedPosition =
                        linesRover.skip(1).filter(l -> Character.isDigit(l.charAt(0))).collect(Collectors.toList());

                Stream<String> linesNavigation =
                        Files.lines(currentRelativePath);
                List<String> navigations =
                        linesNavigation.skip(1).filter(l -> Character.isLetter(l.charAt(0))).collect(Collectors.toList());

                int index = 0;
                for(String coord : startedPosition) {
                    Rover rover = new Rover();

                    // initialisation des coordonnée
                    InputUtils.extractLocalisation(coord, rover);

                    // Recuperation de la navigation
                    String [] mouvements = navigations.get(index).split(
                            "(?!^)");

                    // Navigation du rover
                    for(String mouvement : mouvements) {
                        switch (mouvement ) {
                            case "L":
                                rover.spinToLeft();
                                break;
                            case "R":
                                rover.spinToRight();
                                break;
                            case "M":
                                rover.move();
                                break;
                        }
                    }

                    index++;

                    try {
                        // Verification des coordonnee finale, si KO on ne
                        // l'ajoute pas.
                        if (rover.checkCoordinate(matrix)) {
                            rovers.add(rover);
                        }
                    } catch (BadCoordinateException bac) {
                        System.out.println(bac.getMessage());
                    }

                }

                // Affichage de la position des rovers suite à la navigation
                rovers.forEach((r-> System.out.println(r.toString())));
            } else {
                throw new IllegalArgumentException("Paramètres manquant !!");
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }



}
