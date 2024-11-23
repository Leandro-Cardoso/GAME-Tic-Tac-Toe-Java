import java.io.IOException;

/**
 * Metodos genericos.
 */

public class Utils {
    /**
     * Limpa a tela do terminal em diversos sistemas.
     */

    public static void clear() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }
        catch (IOException | InterruptedException ex) {
            System.err.println("\n ERRO: " + ex.getMessage());
        }
    }
}
