import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(new Player("Leandro"), new Player());
        int option;
        boolean played;

        do {
            Utils.clear();

            System.out.print("\n" + game + "\n\n OPCAO: ");

            option = scanner.nextInt();
            played = game.play(option - 1);

            if (game.isWinner()) {
                game.getPlayers()[game.getP()].win();
                game.resetField();
            }

            if (played) {
                game.takeTurn();
            }
        } while (option > 0 && option < 10);
    }
}
