package puissance4;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Token {
    int userToken = 0;
    char signToken;


    // -------------------------- Constructeur de Pion -------------------------------------------
    public Token(String username, char signToken) throws Exception {
        this.userToken = inputPlayer(username);
        this.signToken = signToken;
    } 
    public int inputPlayer(String elementOfInput) throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nJoueur " + elementOfInput + " veuillez placer votre pion dans une des colonnes disponibles");
        while (!scanner.hasNextInt()) {
            System.out.println("Ceci n'est pas un nombre, au tour du joueur suivant de jouer !!");
            scanner.nextLine();
            System.out.println("\nJoueur " + elementOfInput + " veuillez placer votre pion dans une des colonnes disponibles");
        }

        final int input = scanner.nextInt();
        scanner.nextLine();
        return input;

        
        
    }
}
