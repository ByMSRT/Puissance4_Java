package puissance4;

import java.io.*;

public class Grille {

    public static void main(String[] args) {
        Grille grille = new Grille();
        grille.creationPion();
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

    public Pion creationPion() {
        String user = informationGame("votre nom ?");
        String position = informationGame("la position de votre nouveau pion ?");
        Pion newPion = new Pion(user, position, 0);
        System.out.println(newPion.usernamePion);
        return newPion;
    }
}
