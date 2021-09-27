package puissance4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grille {
    private int ligneVertical;
    private int ligneHorizontal;
    private char[][] horizontalLine;
    private char letter = 'a';

    public static void main(String[] args) {
        Grille grille = new Grille();
        grille.creationGrille();
        grille.placePion();
    }

    public Grille() {
        this.ligneHorizontal = 8;
        this.ligneVertical = 6;
        this.horizontalLine = new char[ligneHorizontal][ligneVertical];

        for (int x = 0; x < ligneHorizontal; x++) {
            for (int y = 0; y < ligneVertical; y++) {
                horizontalLine[x][y] = '-';
                if (x == 7) {
                    horizontalLine[x][y] = letter++;
                }
            }
        }
    }


    public void creationGrille() {
        for (int x = 0; x < ligneHorizontal; x++) {
            for (int y = 0; y < ligneVertical; y++) {
                // System.out.print("|" + horizontalLine[x][y]);
                if (x < 7) {
                    System.out.print("|" + horizontalLine[x][y]);
                } else {
                    System.out.print(" "+ horizontalLine[x][y]);
                }
            }
            if (x < 7) {
                System.out.println("|");
            } else {
                System.out.println("");
            }
            
        }
        System.out.println();
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

    public String placePion() {
        Pion newPion = new Pion("1", "X");
        Pion newPion1 = new Pion("2", "O");

        System.out.println(newPion.userPion);
        System.out.println(newPion1.userPion);


        return "";
    }
}
