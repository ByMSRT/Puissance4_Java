package puissance4;

import java.io.*;

public class Pion {
    int userPion = 0;
    char signPoint;


    // Constructeur de Pion
    public Pion(String username, char signPoint) {
        this.userPion = inputPlayer(username);
        this.signPoint = signPoint;
    } 

    // public String valuePoint(int player) {
    //     if (player == 1) {
    //         return "X";
    //     } else if (player == 2) {
    //         return "O";
    //     } else {
    //        return "";
    //     }
    // }

    public int inputPlayer(String elementOfInput) {
        System.out.println("Joueur " + elementOfInput + " veuillez placer votre pion dans une des colonnes disponibles");
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(streamReader);
        try {
            int valueOfPoint = Integer.parseInt(read.readLine());
            return valueOfPoint;
        } catch (Exception e) {
            System.err.println("Error is : " + e.getMessage());
            return 0;
        }
    }
}
