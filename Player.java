public class Player {
    private String name;
    private char symbol;
    private int score;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public Player(String name) {
        this(name, 'X');
    }

    public Player() {
        this("IA", 'O');
    }

    public void win() {
        this.score++;
    }

    public void reset() {
        this.score = 0;
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;
            return this.name == player.name ? true : false;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return " Player (" + this.symbol + "): " + this.name + " - " + this.score;
    }
}
