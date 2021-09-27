package puissance4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grille {
    private String[] horizontalLine = {"", "", "", "", "", "", "", "", ""};

    public static void main(String[] args) {
        Grille grille = new Grille();
        System.out.println(grille.creationGrille());
        grille.placePion();
    }

    public String informationGame(String information) {
        System.out.println("Quelle est " + information);
        InputStreamReader io = new InputStreamReader(System.in);
        BufferedReader readio = new BufferedReader(io);

        try {
            String responseInformation = readio.readLine();
            return responseInformation;
        } catch (Exception e) {
            System.err.println("Error is :" + e.getMessage());
            return "";
        }
    }

     
    public String creationGrille() {
        String test = "";
        char letter = 'a';
        for (int y = 0; y < 7; y++) {
            for (int x = 1; x <= horizontalLine.length; x++) {
                // Création dernière ligne avec les lettres
                if (y == 6) {
                    // Ajout de lettre en bas des colonne afin de se repérer
                    if (x <= 8) {
                        test += "  " + letter++ + "  ";
                        continue;
                    } else {
                        test += " ";
                        continue;
                    }
                }

                // Création première ligne d'une colonne
                if (x == 1) {
                    test += "|  ";
                    continue;
                //  Création de la fin d'une ligne d'une colonne
                } else if (x == 9) {
                    test +=  "  |\n";
                    continue;
                } else {
                   test += horizontalLine[x] +"  |  "; 
                }                
            }

        }
        return test;
    }

    public void analyzeString() {
        String str = creationGrille();
        for (int index = 0; index < str.length(); index++) {
            if (index == 1) {
                System.out.println(str[index+1]);
            }
        }
        Scanner scan = new Scanner(str);
        String test = scan.nextLine();
        System.out.println(test);
        scan.close();
    }

    public String placePion() {
        Pion newPion = new Pion("1", "X");
        Pion newPion1 = new Pion("2", "O");

        System.out.println(newPion.userPion);
        System.out.println(newPion1.userPion);


        return "";
    }
}
