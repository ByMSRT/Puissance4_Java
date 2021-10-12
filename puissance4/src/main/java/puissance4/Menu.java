package puissance4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    static String text;
    public static void main(String[] args) throws IOException{
        menu();
    }

    public static void printMenu(){
        System.out.println("\n  Bienvenue sur le puissance 4  ! \n \n" +
        "1 -  Jouer  \n" +
        "2 -  Regles  \n" +
        "3 -  Quitter ");
    }

    public static void MenuPlay() throws IOException{

        int choice = -1;

        Scanner scan = new Scanner(System.in);
        System.out.println("\n1 -  Local - 1 vs 1 ");
        System.out.println("2 -  En ligne ");
        System.out.println("3 -  Retour ");
        System.out.println("4 -  Quitter ");
        choice = scan.nextInt();
        switch(choice){
            case 1:
                System.out.println("\n1 -  TEST LOCAL ");
                System.out.println("\f");
                Grid grille = new Grid();
                // grille.gridCreation();
                if (!grille.nextToken()) {
                    System.exit(0);
                }
                break;
            case 2:
                System.out.println("2 -  TEST ONLINE ");
                // Exec Online
                ServerOrClient();
                break;
            case 3:
                printMenu();
                break;
            case 4:
                System.out.println(" Fin du programme ");
                System.exit(0);
            default:
                System.out.println("\f");
                System.out.println(" Invalid  - Réessayer !");
                MenuPlay();
                break;
        }
        /* choice = scan.nextInt(); */
    };

    public static void ServerOrClient() throws IOException {
        int choice = -1;

        Scanner scan = new Scanner(System.in);
        System.out.println("Choisissez : ");
        System.out.println("\n1 - Server");
        System.out.println("2 - Client");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                Communicator.createServ("");
                break;
            case 2:
                System.out.println("Client - Veuillez rentrer une adresse IP : ");
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                text = br.readLine();
                Communicator.createServ(text);
                break;
            default:
                break;
        }

    }

    public static void MenuRules() throws IOException{

        int choice = -1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Pour commencer une partie de puissance 4, on designe le premier joueur.\nCelui ci met un de ses jetons de couleur dans l une des colonnes de son choix.\nLe jeton tombe alors en bas de la colonne.\nLe deuxieme joueur insere a son tour son jeton, de l autre couleur dans la colonne de son choix.\nEt ainsi de suite jusqu a obtenir une rangee de 4 jetons de meme couleur.");
        System.out.println("Pour gagner une partie de puissance 4, il suffit d etre le premier a aligner 4 jetons de sa couleur horizontalement, verticalement et diagonalement.\nSi lors d une partie, tous les jetons sont joues sans qu il y est d alignement de jetons, la partie est declare nulle.\n");
        System.out.println("1 -  Retour ");
        System.out.println("2 -  Quitter ");
        choice = scan.nextInt();
        switch(choice){
            case 1:
                menu();
                break;
            case 2:
                System.out.println(" Fin du programme ");
                System.exit(0);
            default:
                System.out.println("\f");
                System.out.println(" Invalid  - Réessayer !");
                MenuRules();
                break;
        }
        /* choice = scan.nextInt(); */

    };

    public static void menu() throws IOException{
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        printMenu();
        choice = scan.nextInt();
        while (choice != 3){

            switch(choice) {
                case 1:
                    System.out.println(" Jouer ");
                    MenuPlay();
                    break;
                case 2:
                    System.out.println(" Regles ");
                    MenuRules();
                    break;
                default:
                    System.out.println("\f");
                    System.out.println(" Invalid  - Réessayer !");
                    menu();
            }

            /* choice = scan.nextInt(); */
        }
        System.out.println("\f");
        System.out.println(" Fin du programme ");
        System.exit(0);
    }
}


