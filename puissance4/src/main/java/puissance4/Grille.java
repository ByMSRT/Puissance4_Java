package puissance4;

import java.io.*;
import java.util.ArrayList;

public class Grille {

    public static void main(String[] args) {
        Grille grille = new Grille();
        grille.creationPion();
        grille.creationGrille();
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

    public void creationPion() {
        for (int numberPlayer = 0; numberPlayer < 2; numberPlayer++) {
            String user = informationGame("votre nom ?");
            String position = informationGame("la position de votre nouveau pion ?");
            Pion newPion = new Pion(user, position, 0);
            System.out.println(newPion.usernamePion);            
        }
    }

    public void creationGrille() {
        String[] horizontalLine = {"", "", "", "", "", "", "", "", ""};
        String test = "";
        char letter = 'a';
        for (int index1 = 0; index1 <= 7; index1++) {
            if (index1 == 7) {
                break;
            }
            for (int index2 = 1; index2 <= horizontalLine.length; index2++) {
                if (index1 == 6) {
                    // Ajout de lettre en bas des colonne afin de se repérer
                    if (index2 <= 8) {
                        test += "  " + letter++ + "  ";
                        continue;
                    } else {
                        test += " ";
                        continue;
                    }
                }

                // Création première ligne d'une colonne
                if (index2 == 1) {
                    test += "|  ";
                    continue;
                //  Création de la fin d'une ligne d'une colonne
                } else if (index2 == 9) {
                    test +=  "  |\n";
                    continue;
                } else {
                   test += horizontalLine[index2] +"  |  "; 
                }

                
            }

        }
        System.out.println(test);
    }

}
