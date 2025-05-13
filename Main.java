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
                System.out.println("Invalid input!");
            }
        }
        if (option.equals("hsr")) {
            simulateHSR();
        }
        else {
            simulateWuWa();
        }
    }
    public static void simulateHSR() {

    }
    public static void simulateWuWa() {

    }
}
