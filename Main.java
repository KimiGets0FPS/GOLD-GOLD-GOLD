import CMs.ColorPrint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        String option;
        while (true) {
            System.out.println("HSR or WuWa: ");
            option = io.nextLine().toLowerCase();
            if (option.equals("hsr") || option.equals("wuwa")) {
                break;
            }
            else {
                System.out.print("Invalid input!\nPress Enter to continue...");
                io.nextLine();
                ColorPrint.clear();
            }
        }
        if (option.equals("hsr")) {
            simulateHSR();
        }
        else {
            simulateWuWa();
        }
        ColorPrint.cpln("Thank you for playing!", ColorPrint.GREEN_TEXT);
    }

    public static void simulateHSR() {
        // Get characters before calling this
        // Version No, Patch No.
        // 5 Star, 4 Star, 3 Star
        // Specific Characters
        HonkaiStarRail hsr = new HonkaiStarRail(null, null, null);
    }

    public static void simulateWuWa() {
        // Get characters before calling this
        // Check HoyoCharacters.json before creating the list of characters
        WutheringWaves wuwa = new WutheringWaves(null, null, null);
    }
}
