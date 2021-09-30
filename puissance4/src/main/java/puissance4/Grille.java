package puissance4;

import java.io.*;


public class Grille {
    private int ligneVertical;
    private int ligneHorizontal;
    private char[][] horizontalLine;
    private char letter = '1';

    public static void main(String[] args) {
        Grille grille = new Grille();
        grille.creationGrille();
        grille.nextPion();
        grille.creationGrille();
    }

    public Grille() {
        this.ligneHorizontal = 8;
        this.ligneVertical = 7;
        this.horizontalLine = new char[ligneVertical][ligneHorizontal];

        for (int x = 0; x < ligneVertical; x++) {
            for (int y = 0; y < ligneHorizontal; y++) {
                horizontalLine[x][y] = '-';
                if (x == 6) {
                    horizontalLine[x][y] = letter++;
                }
            }
        }
    }


    public void creationGrille() {
        for (int x = 0; x < ligneVertical; x++) {
            for (int y = 0; y < ligneHorizontal; y++) {
                if (x < 6) {
                    System.out.print("|" + horizontalLine[x][y]);
                } else {
                    System.out.print(" "+ horizontalLine[x][y]);
                }
            }
            if (x < 6) {
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

    //  ----------------------------------- Placement Pion ---------------------------------------- 
    public void nextPion(){
        int tour = 0;

        do {
            Pion pionPlayer1 = new Pion("1", 'X');
            validePlacement(pionPlayer1);
            Pion pionPlayer2 = new Pion("2", 'O');
            validePlacement(pionPlayer2);
            tour++;
        } while (tour < 5); // fonction qui vérifie victoire null ou égalité)
    }

    public boolean placePion(Pion newPion) {

        System.out.println(newPion.userPion);

        for (int x = ligneVertical-1; x >= 0; x--) {
            if (horizontalLine[x][newPion.userPion-1] == '-') {
                horizontalLine[x][newPion.userPion-1] = newPion.signPoint;
                break;
            }
            if (x == 0) {
                return false;
            }
        
        }
        return true;
    }

    public void validePlacement(Pion pion) {
        if (placePion(pion)) {
            creationGrille(); 
        } else {
            System.out.println("Vous avez place votre pion dans une colonne complete");
        }
    }

    // --------------------------- Condition de victoire -------------------------------
}
