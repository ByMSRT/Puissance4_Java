package puissance4;

import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {
        menu();
    }

    public static void printMenu(){
        System.out.println("\n ❌ Bienvenue sur le puissance 4 🟢 ! \n \n" +
        "1 - 🕹 Jouer 🕹 \n" +
        "2 - 📝 Regles 📝 \n" +
        "3 - 👋 Quitter 👋");
    }

    public static void MenuPlay(){

        int choice = -1;

        Scanner scan = new Scanner(System.in);
        System.out.println("\n1 - 🆚 Local - 1 vs 1 🆚");
        System.out.println("2 - 📡 En ligne 📡");
        System.out.println("3 - ⬅️ Retour ⬅️");
        System.out.println("4 - 👋 Quitter 👋");
        choice = scan.nextInt();
        switch(choice){
            case 1:
                System.out.println("\n1 - 🆚 TEST LOCAL 🆚");
                System.out.println("\f");
                    Grid grille = new Grid();
                    grille.gridCreation();
                    grille.nextToken();
                break;
            case 2:
                System.out.println("2 - 📡 TEST ONLINE 📡");
                // Exec Online
                break;
            case 3:
                printMenu();
                break;
            case 4:
                System.out.println("👋 Fin du programme 👋");
                System.exit(0);
            default:
                System.out.println("\f");
                System.out.println("🔴 Invalid 🔴 - Réessayer !");
                MenuPlay();
                break;
        }
        choice = scan.nextInt();
    };

    public static void MenuRules(){

        int choice = -1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Pour commencer une partie de puissance 4, on désigne le premier joueur.\nCelui-­ci met un de ses jetons de couleur dans l’une des colonnes de son choix.\nLe jeton tombe alors en bas de la colonne.\nLe deuxième joueur insère à son tour son jeton, de l’autre couleur dans la colonne de son choix.\nEt ainsi de suite jusqu’à obtenir une rangée de 4 jetons de même couleur.");
        System.out.println("Pour gagner une partie de puissance 4, il suffit d’être le premier à aligner 4 jetons de sa couleur horizontalement, verticalement et diagonalement.\nSi lors d’une partie, tous les jetons sont joués sans qu’il y est d’alignement de jetons, la partie est déclaré nulle.\n");
        System.out.println("1 - ⬅️ Retour ⬅️");
        System.out.println("2 - 👋 Quitter 👋");
        choice = scan.nextInt();
        switch(choice){
            case 1:
                menu();
                break;
            case 2:
                System.out.println("👋 Fin du programme 👋");
                System.exit(0);
            default:
                System.out.println("\f");
                System.out.println("🔴 Invalid 🔴 - Réessayer !");
                MenuRules();
                break;
        }
        choice = scan.nextInt();

    };

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        printMenu();
        choice = scan.nextInt();
        while (choice != 3){

            switch(choice) {
                case 1:
                    System.out.println("🕹 Jouer 🕹");
                    MenuPlay();
                    break;
                case 2:
                    System.out.println("📝 Regles 📝");
                    MenuRules();
                    break;
                default:
                    System.out.println("\f");
                    System.out.println("🔴 Invalid 🔴 - Réessayer !");
                    menu();
            }

            choice = scan.nextInt();
        }
        System.out.println("\f");
        System.out.println("👋 Fin du programme 👋");
        System.exit(0);
    }
}


