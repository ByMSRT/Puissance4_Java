package puissance4;

public class Pion {
    int positionHorizontal = 0;
    String usernamePion = "";
    String positionVertical = "";

    public Pion(String username, String positionVertical, int positionHorizontal) {
        this.usernamePion = username;
        this.positionVertical = positionVertical;
        this.positionHorizontal = positionHorizontal;
    } 

}
