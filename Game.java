public class Game {
    private char[] field = new char[9];
    private Player[] players = new Player[2];
    private int p;
    private final int[][] VICTORIES = {{0, 1, 2},
                                       {3, 4, 5},
                                       {6, 7, 8},
                                       {0, 3, 6},
                                       {1, 4, 7},
                                       {2, 5, 8},
                                       {0, 4, 8},
                                       {2, 4, 6}
                                      };
    private final String COLOR = "\033[33m";
    private final String END_COLOR = "\033[m";

    public Game(Player player1, Player player2) {
        this.players[0] = player1;
        this.players[1] = player2;
        this.p = 0;
        this.resetField();
    }

    public void resetField() {
        for (int i = 0; i < 9; i++) {
            this.field[i] = (char) (49 + i);
        }
    }

    public void takeTurn() {
        this.p = this.p == 0 ? 1 : 0;
    }

    public boolean play(int i) {
        if (i < 0 || i >= this.field.length) {
            return false;
        }

        if (this.field[i] != this.players[0].getSymbol() && this.field[i] != this.players[1].getSymbol()) {
            this.field[i] = this.players[this.p].getSymbol();

            return true;
        }
        
        return false;
    }

    public boolean isWinner() {
        for (int[] victory : this.VICTORIES) {
            for (int i : victory) {
                if (this.field[i] != this.players[this.p].getSymbol()) {
                    break;
                }

                if (i == victory[2]) {
                    return true;
                }
            }
        }

        return false;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public int getP() {
        return this.p;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(" TIC-TAC-TOE\n\n");

        if (this.p == 0) {
            str.append(this.COLOR + this.players[0] + this.END_COLOR + "\n" + this.players[1] + "\n");
        }
        else {
            str.append(this.players[0] + "\n" + this.COLOR + this.players[1] + this.END_COLOR + "\n");
        }

        for (int i = 0; i < this.field.length; i++) {
            if (i % 3 == 0 && i != 9) {
                str.append("\n");
            }
            
            if (this.field[i] == this.players[0].getSymbol() || this.field[i] == this.players[1].getSymbol()) {
                str.append(" " + this.COLOR + this.field[i] + this.END_COLOR);
            }
            else {
                str.append(" " + this.field[i]);
            }
        }

        return str.toString();
    }
}
