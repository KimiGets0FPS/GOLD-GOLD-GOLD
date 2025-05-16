package CMs;

public class ColorPrint {
    public static final String LIGHT_BLUE_TEXT  = "\u001B[94m";
    public static final String DARK_BLUE_TEXT = "\u001B[34m";
    public static final String PURPLE_TEXT = "\u001B[35m";
    public static final String GOLD_TEXT = "\u001B[33m";
    public static final String RESET_TEXT = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {  // Testing
        PullAnimation(5);
    }

    public static void cp(String message, String color) {  // Color print
        String output = color + message;
        System.out.print(output);
    }

    public static void cpln(String message, String color) {
        cp(message + "\n", color);
    }

    public static void PullAnimation(int star) throws InterruptedException {
        for (int i=0; i < 8; i++) {
            cpln("█", LIGHT_BLUE_TEXT);
            Thread.sleep(350);
        }
        if (star == 5) {
            for (int i=0; i < 5; i++) {
                cpln("█", GOLD_TEXT);
                Thread.sleep(350);
            }
        }
        if (star == 4) {
            for (int i=0; i < 5; i++) {
                cpln("█", PURPLE_TEXT);
                Thread.sleep(350);
            }
        }
        if (star == 3) {
            for (int i=0; i < 5; i++) {
                cpln("█", DARK_BLUE_TEXT);
                Thread.sleep(350);
            }
        }
    }

    public static void clear() {
        // Clears the terminal on CodeHS (Works)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
