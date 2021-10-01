package puissance4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Grille {
    private int ligneVertical;
    private int ligneHorizontal;
    private char[][] horizontalLine;
    private char letter = '1';

/*     public static void main(String[] args) {
        Grille grille = new Grille();
        grille.creationGrille();
        grille.nextPion();
        grille.creationGrille();
    } */

    public static void runGrille() {
        Grille grille = new Grille();
        grille.creationGrille();
        grille.nextPion();
        grille.creationGrille();
    }

    public Grille() {
        this.ligneHorizontal = 6;
        this.ligneVertical = 8;
        this.horizontalLine = new char[ligneVertical][ligneHorizontal];

        for (int x = 0; x < ligneVertical; x++) {
            for (int y = 0; y < ligneHorizontal; y++) {
                horizontalLine[x][y] = '-';
                if (x == 7) {
                    horizontalLine[x][y] = letter++;
                }
            }
        }
    }


    public void creationGrille() {
        for (int x = 0; x < ligneVertical; x++) {
            for (int y = 0; y < ligneHorizontal; y++) {
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

    public void nextPion(){
        
        int tour = 0;

        do {
            Pion pionPlayer1 = new Pion("1", 'X');
            placePion(pionPlayer1);
            creationGrille();
            Pion pionPlayer2 = new Pion("2", 'O');
            placePion(pionPlayer2);
            creationGrille();
            tour++;
        } while (tour < 2);// fonction qui vérifie victoire null ou égalité)

    }

    public char[][] placePion(Pion newPion) {

        System.out.println(newPion.userPion);

        // newPion.userPion = this.ligneVertical;
        // newPion1.userPion = this.ligneVertical;

        for (int x = ligneVertical-1; x >= 0; x--) {
            if (x-1 >= 0) {
                horizontalLine[x-1][newPion.userPion-1] = newPion.signPoint;
                break;
            }
            // if (horizontalLine[x][newPion.userPion] == 'X' || horizontalLine[x][newPion.userPion] == 'O') {
            //     if (x-1 >= 0) {
            //         horizontalLine[x-1][newPion.userPion-1] = newPion.signPoint;
            //     } 
            // }
        }
        return horizontalLine;
    }
}
