package puissance4;

import java.util.Scanner;

public class Menu {
    
    public static void main(String[] args) {
        int selected;
        int play;
        int rules;
        do {
            selected = MenuData();
            switch(selected) {
                case 1:
                    System.out.println("Jouer - Quelle mode choisissez-vous ?");
                    do {
                        play = MenuPlay();
                        switch(play){
                            case 1:
                                // Lancement en local
                                break;
                            case 2:
                                // Lancement en ligne
                                break;
                        }   
                    }
                    while(play > 2);
                    break;
                case 2:
                    System.out.println("Regles");
                    do {
                        rules = MenuRules();
                        switch(rules){
                            case 1:
                                MenuData();
                                break;
                            case 2:
                                System.out.println("Quit");
                                System.exit(0);
                                break;
                        }
                    }
                    while(rules > 2);
                    break;
                    
                case 3:
                    System.out.println("Quit");
                    System.exit(0);
                    break;
            
            }
        }
        while(selected > 3);
    };

    public static int MenuData(){

        int selection; 

        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Jouer");
        System.out.println("2 - Regles");
        System.out.println("3 - Quit");

        selection = sc.nextInt();
        return selection;
    };

    public static int MenuPlay(){

        int playMode;

        Scanner play = new Scanner(System.in);
        System.out.println("1 - Local - 1 vs 1");
        System.out.println("2 - En ligne");

        playMode = play.nextInt();
        return playMode;
    };

    public static int MenuRules(){

        int Rules;

        Scanner rules = new Scanner(System.in);
        System.out.println("EXPLICATION");
        System.out.println("1 - Retour");
        System.out.println("2 - Quit");

        Rules = rules.nextInt();
        return Rules;
    };
}
