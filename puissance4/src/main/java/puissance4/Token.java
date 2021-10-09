package puissance4;

import java.io.*;

public class Token {
    int userToken = 0;
    char signToken;


    // -------------------------- Constructeur de Pion -------------------------------------------
    public Token(String username, char signToken) {
        this.userToken = inputPlayer(username);
        this.signToken = signToken;
    } 
    public int inputPlayer(String elementOfInput) {
        System.out.println("Joueur " + elementOfInput + " veuillez placer votre pion dans une des colonnes disponibles");
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(streamReader);
        try {
            int valueOfToken = Integer.parseInt(read.readLine());
            return valueOfToken;
        } catch (Exception e) {
            System.err.println("Error is : " + e.getMessage());
            return 0;
        }
    }
}
