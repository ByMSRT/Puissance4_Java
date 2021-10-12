package puissance4;



public class Grid {
    private int line;
    private int column;
    private char[][] horizontalLine;
    private char letter = '1';

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
        if (RandomPlayer.randomPlayer() == "joueur 1") {
            do {
                Token tokenPlayer1 = new Token("1", 'X');
                if (!validePlacement(tokenPlayer1)){
                  break;
                }
                Token tokenPlayer2 = new Token("2", 'O');
                if (!validePlacement(tokenPlayer2)){
                  break;
                }
            } while (!placeInGrid()); // fonction qui vérifie si il reste de la place dans la grille.
        } else {
            do {
                Token tokenPlayer2 = new Token("2", 'O');
                if (!validePlacement(tokenPlayer2)){
                  break;
                }
                Token tokenPlayer1 = new Token("1", 'X');
                if (!validePlacement(tokenPlayer1)){
                  break;
                }
            } while (!placeInGrid()); // fonction qui vérifie si il reste de la place dans la grille.
        }
    }

    public boolean placeToken(Token newToken) {
        for (int y = line-1; y >= 0; y--) {
            if (horizontalLine[y][newToken.userToken-1] == '-') {
                horizontalLine[y][newToken.userToken-1] = newToken.signToken;
                if (verificationVictory(newToken.signToken, y, newToken.userToken-1)) {
                    return false;
                }
                break;
                
            } 
            if (y == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean validePlacement(Token token) {
        if (placeToken(token)) {
            gridCreation(); 
            return true;
        } else {
            return false;
        }
    }

    public boolean placeInGrid() {
        int count = 0;
        for (int x = 0; x < column; x++) {
            if (horizontalLine[1][x] == 'X' || horizontalLine[1][x] == 'O') {
                count++;
            }
        }   
        System.out.println(count);
        if (count < 7) {
            return false;
        } else {
            return true;
        }
    
    }

    // --------------------------- Condition de victoire -------------------------------

    public boolean verificationVictory(char symbol, int y, int x) {
        boolean victory = false;
        if (y == 0) {
            victory = true;
            System.out.println();

        } else if ((horizontalRightVictory(symbol, y, x) + horizontalLeftVictory(symbol, y, x) - 1) == 4) {
            victory = true;
            System.out.println("Victoire horizontal du joueur qui a le symbol " + symbol);
        } else if (verticalVictory(symbol, y ,x) == 4) {
            victory = true;
            System.out.println("Victoire vertical du joueur qui a le symbol " + symbol);
        } else if ((diagonalBD(symbol, y, x) + diagonalHG(symbol, y, x) - 1)== 4) {
            victory = true;
            System.out.println("Victoire diagonale BD du joueur qui a le symbol " + symbol);
        } else if ((diagonalBG(symbol, y, x) + diagonalHD(symbol, y, x) - 1) == 4) {
            victory = true;
            System.out.println("Victoire diagonale HD du joueur qui a le symbol " + symbol);
        }
        return victory;
    }

    // -------------------- Victoire horizontal ------------------------
    public int horizontalRightVictory(char symbol, int y, int x) {
        int victory = 1;
        int move = 1;

        while (victory <= 4 && x+move <= column-1) {
            if (horizontalLine[y][x] == symbol && horizontalLine[y][x+move] == symbol) {
                victory++;
                move++;
            } else {
                break;
            }
        }
        return victory;
    }
    public int horizontalLeftVictory(char symbol, int y, int x) {
        int victory = 1;
        int move = 1;
        while (victory <= 4 && x-move >= 0) {
            if (horizontalLine[y][x] == symbol && horizontalLine[y][x-move] == symbol) {
                victory++;
                move++;
            } else {
                break;
            }
        }
        return victory;
        
    }

    // -------------------- Victoire vertical ------------------------

    public int verticalVictory(char symbol, int y, int x) {
        int victory = 0;
        while (y < line-1 && horizontalLine[y][x] == symbol) {
            y++;
            victory++;
        }
        while (y >= 0 && horizontalLine[y][x] == symbol) {
            y--;
            victory++;
        }
        return victory;
    }

    // ---------------- Victoire diagonale en Bas-Droite et Haut-Gauche -------------------

    public int diagonalBD(char symbol, int y, int x){
        int victory = 1;
        int move = 1;

        while (x-move >= 0 && y-move >= 0) {
            if (horizontalLine[y][x] == symbol && horizontalLine[y-move][x-move] == symbol) {
                move++;
                victory++;
            } else {
                break;
            }
        }
        return victory;
    }

    public int diagonalHG(char symbol, int y, int x){
        int victory = 1;
        int move = 1;

        while (x+move <= column-1 && y+move <= line-1) {
            if (horizontalLine[y][x] == symbol && horizontalLine[y+move][x+move] == symbol) {
                move++;
                victory++;
            } else {
                break;
            }
        }
        return victory;
    }

    // ---------------- Victoire diagonale en Bas-Gauche et Haut-Droite -------------------

    public int diagonalBG(char symbol, int y, int x) {
        int victory = 1;
        int move = 1;
        while (victory <= 4 && x-move >= 0 && y+move <= line-1) {
            if (horizontalLine[y][x] == symbol && horizontalLine[y+move][x-move] == symbol) {
                move++;
                victory++;
            } else {
                break;
            }
        }
        return victory;
    }

    public int diagonalHD(char symbol, int y, int x) {
        int victory = 1;
        int move = 1;
        while (victory <= 4 && x+move <= column-1 && y-move >= 0) {
            if (horizontalLine[y][x] == symbol && horizontalLine[y-move][x+move] == symbol) {
                move++;
                victory++;
            } else {
                break;
            }
        }
        return victory;
    }
    

    
}
