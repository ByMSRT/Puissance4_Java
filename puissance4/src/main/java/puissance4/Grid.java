package puissance4;



public class Grid {
    private int line;
    private int column;
    private char[][] horizontalLine;
    private char letter = '1';

    public static void main(String[] args) {
        Grid grille = new Grid();
        grille.gridCreation();
        grille.nextToken();
    }

    public Grid() {
        this.column = 8;
        this.line = 7;
        this.horizontalLine = new char[line][column];

        for (int y = 0; y < line; y++) {
            for (int x = 0; x < column; x++) {
                horizontalLine[y][x] = '-';
                if (y == 6) {
                    horizontalLine[y][x] = letter++;
                }
            }
        }
    }


    public void gridCreation() {
        for (int y = 0; y < line; y++) {
            for (int x = 0; x < column; x++) {
                if (y < 6) {
                    System.out.print("|" + horizontalLine[y][x]);
                } else {
                    System.out.print(" "+ horizontalLine[y][x]);
                }
            }
            if (y < 6) {
                System.out.println("|");
            } else {
                System.out.println("");
            }
            
        }
        System.out.println();
    }

    //  ----------------------------------- Placement Pion ---------------------------------------- 
    
    public void nextToken(){
        int tour = 0;

        do {
            Token tokenPlayer1 = new Token("1", 'X');
            validePlacement(tokenPlayer1);
            horizontalVictory(tokenPlayer1.signToken);
            verticalVictory(tokenPlayer1.signToken);
            Token tokenPlayer2 = new Token("2", 'O');
            validePlacement(tokenPlayer2);
            horizontalVictory(tokenPlayer2.signToken);
            verticalVictory(tokenPlayer2.signToken);
            tour++;
        } while (tour < 100); // fonction qui vérifie victoire null ou égalité)
    }

    public boolean placeToken(Token newToken) {

        for (int y = line-1; y >= 0; y--) {
            if (horizontalLine[y][newToken.userToken-1] == '-') {
                horizontalLine[y][newToken.userToken-1] = newToken.signToken;
                break;
            }
            if (y == 0) {
                return false;
            }
        
        }
        return true;
    }

    public void validePlacement(Token token) {
        if (placeToken(token)) {
            gridCreation(); 
        } else {
            System.out.println("Vous avez place votre pion dans une colonne complete");
        }
    }

    // --------------------------- Condition de victoire -------------------------------

    public void horizontalVictory(char symbol) {
        int victory = 1;

        for(int y = line-1; y >= 0; y--) {
            for (int x = 0; x < column-1; x++) {
                if (horizontalLine[y][x] == symbol && horizontalLine[y][x+1] == symbol) {
                    victory++;
                }
            }
        } 
        System.out.println("Il y a " + victory + " aligne sur l'axe horizontal avec le symbol "+ symbol);
    }

    public void verticalVictory(char symbol) {
        int victory = 1;
        for (int x = 0; x < column; x++) {
            for (int y = 0; y < line-1; y++) {
                if (horizontalLine[y][x] == symbol && horizontalLine[y+1][x] == symbol) {
                    victory++;
                }
            }
        }
        System.out.println("Il y a " + victory + " aligne sur l'axe vertical avec le symbol "+ symbol);
    }
}
