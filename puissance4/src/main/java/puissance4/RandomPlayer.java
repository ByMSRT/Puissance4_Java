package puissance4;

public class RandomPlayer {

    public static void main(String[] args) {
        randomPlayer();
    }
    

    public static void randomPlayer(){
        String player[] = {"joueur 1", "joueur 2"};

        int nbRandom = (int) (Math.random() * player.length);

        System.out.println("✅ Le " + player[nbRandom] + " commence la partie ! ✅");
    }
}
