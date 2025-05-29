import CMs.*;

import java.io.*;
import java.util.*;

import org.json.*;
// https://mvnrepository.com/artifact/org.json/json

import static CMs.ColorPrint.*;

public class Main {
    private static final Kattio io = new Kattio();

    // Stats
    private static int totalPulls = 0;
    private static int fiftyFiftyWins = 0;
    private static int fiftyFiftyLosses = 0;
    private static ArrayList<Integer> pullsToFiveStar = new ArrayList<>();

    /*
    TODO: Finish the simulate() methods
    TODO: Add the following stats: int totalPulls, int fiftyFiftyWins, int fiftyFiftyLosses, ArrayList<Integer> pullsToFiveStar
    TODO: Add the following methods: void displayStats(), void resetStats(), etc.
    TODO: Store these data points in a file so it could be seen the next time the program is run
     */
    public static void main(String[] args) throws IOException {
        cp("Welcome to the ", ColorPrint.GREEN_TEXT);
        cp("GOLD GOLD GOLD", ColorPrint.GOLD_TEXT);
        cpln(" Gacha Simulator!", ColorPrint.GREEN_TEXT);

        chooseGame();

        cpln("Thank you for playing!", ColorPrint.GREEN_TEXT);

        io.close();
    }

    public static void chooseGame() throws IOException {
        String option;
        while (true) {
            System.out.print("HSR or WuWa: ");
            option = io.next().toLowerCase();
            if (option.equalsIgnoreCase("hsr") || option.equalsIgnoreCase("wuwa")) {
                break;
            }
            else {
                System.out.print("Invalid input!\nPress Enter to continue...");
                io.nextLine();
                clear();
            }
        }

        clear();

        if (option.equals("hsr")) {
            simulateHSR();
        }
        else {
            simulateWuWa();
        }
    }

    public static void simulateHSR() {
        HashMap<String, HashMap<String, ArrayList<String>>> characters = parseJSON(fileReader("HSRCharacters"));

        String versionChoice = getVersionChoice(characters);

        ArrayList<String> a = new ArrayList<>();
        a.add("poop");

        HonkaiStarRail hsr = new HonkaiStarRail(
                characters.get(versionChoice).get("FiveStar"),
                characters.get(versionChoice).get("FourStar"),
                a);
        try {
            simulate(hsr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void simulateWuWa() {
        HashMap<String, HashMap<String, ArrayList<String>>> characters = parseJSON(fileReader("WuWaCharacters"));

        String versionChoice = getVersionChoice(characters);

        ArrayList<String> a = new ArrayList<>();
        a.add("poop");

        WutheringWaves wuwa = new WutheringWaves(
                characters.get(versionChoice).get("FiveStar"),
                characters.get(versionChoice).get("FourStar"),
                a);
        try {
            simulate(wuwa);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getVersionChoice(HashMap<String, HashMap<String, ArrayList<String>>> characters) {
        String versionChoice;
        while (true) {
            displayVersions(getVersions(characters));
            System.out.print("Enter the version you want to simulate: ");
            versionChoice = io.next().toUpperCase();
            if (getVersions(characters).contains(versionChoice)) {
                break;
            }
            else {
                cpln("Invalid input!", ColorPrint.RED_TEXT);
                cp("Press Enter to continue...", ColorPrint.RESET_TEXT);
                io.next();
            }
            clear();
        }
        return versionChoice;
    }

    public static ArrayList<String> getVersions(HashMap<String, HashMap<String, ArrayList<String>>> jsonCharacters) {
        return new ArrayList<>(jsonCharacters.keySet());
    }

    public static void displayVersions(ArrayList<String> versions) {
        for (int i=0; i < versions.size(); i ++) {
            cpln((i+1) + ". " + versions.get(i), ColorPrint.GREEN_TEXT);
        }
    }

    public static void simulate(Gacha gacha) throws IOException, InterruptedException {
        while (true) {
            cpln(
                    "1. Single Pull\n2. Ten Pull\n3. View Stats\n4. Switch Version\n5. Switch Game\n6. Quit\n", ColorPrint.RESET_TEXT);
            cp("Your Choice (1-6): ", ColorPrint.GREEN_TEXT);
            int option = io.nextInt();
            if (option == 1) {
                clear();
                Character pull = gacha.pull();
                printPullAnimation(getStar(pull));
                printCharacter(pull);
            }
            else if (option == 2) {
                clear();
                Character[] pulls = gacha.tenPull();
                printPullAnimation(getStar(pulls));
                for (Character pull : pulls) {
                    printCharacter(pull);
                }
            }
            else if (option == 3) {
                clear();
                System.out.println("Honkai Star Rail Stats:");  //Print out Wuwa and Hsr stats seperate - pity 5 stars 4 stars total pulls 50/50 wins
                System.out.println("Pity: " + HonkaiStarRail.getFiveStarPity());
                System.out.println("Total Pity: " + HonkaiStarRail.getTotalPity());
                System.out.println("Average Five Star Pity: " + HonkaiStarRail.getAvgFiveStar());
                System.out.println("50/50 Wins: " + HonkaiStarRail.getFiftyFiftyWon());
                System.out.println("50/50 Lost: " + HonkaiStarRail.getFiftyFiftyLost());
                System.out.println("\nWuthering Waves Stats:");
                System.out.println("Pity: " + WutheringWaves.getFiveStarPity());
                System.out.println("Total Pity: " + WutheringWaves.getTotalPity());
                System.out.println("Average Five Star Pity: " + WutheringWaves.getAvgFiveStar());
                System.out.println("50/50 Wins: " + WutheringWaves.getFiftyFiftyWon());
                System.out.println("50/50 Lost: " + WutheringWaves.getFiftyFiftyLost());
            }
            else if (option == 4) {
                if (gacha.getName().equals("Honkai Star Rail")) {
                    simulateHSR();
                }
                else {
                    simulateWuWa();
                }
                return;
            }
            else if (option == 5) {
                chooseGame();
            }
            else if (option == 6) {
                return;
            }
            else {
                cpln("Please enter a valid ", ColorPrint.RED_TEXT);
                cp("Press Enter to continue...", ColorPrint.RESET_TEXT);
                clear();
            }
        }
    }

    public static void printPullAnimation(int star) throws InterruptedException {
        ColorPrint.PullAnimation(star);
        System.out.println();
    }

    public static int getStar(Character character) {
        return character.getRarity();
    }

    public static int getStar(Character[] characters) {
        Character output = characters[0];
        for (int i=1; i < characters.length; i++) {
            if (characters[i].getRarity() > output.getRarity()) {
                output = characters[i];
            }
        }
        return output.getRarity();
    }

    public static void printCharacter(Character character) {

        if (character.getRarity() == 5) {
            cpln(character.toString(), ColorPrint.GOLD_TEXT);
        }
        else if (character.getRarity() == 4) {
            cpln(character.toString(), ColorPrint.PURPLE_TEXT);
        }
        else {
            cpln(character.toString(), ColorPrint.LIGHT_BLUE_TEXT);
        }
    }

    public void displayStats() {

    }

    public void resetStats() {
        totalPulls = 0;
        fiftyFiftyWins = 0;
        fiftyFiftyLosses = 0;
        pullsToFiveStar = new ArrayList<>();

    }

    public static String fileReader(String fileName) {
        StringBuilder jsonString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName + ".json"))) {
            String line;
            while ((line = reader.readLine()) != null) {  // If there is a current line
                jsonString.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString.toString();
    }

    public static HashMap<String, HashMap<String, ArrayList<String>>> parseJSON(String jsonString) {
        HashMap<String, HashMap<String, ArrayList<String>>> characters = new HashMap<>();

        JSONObject version = new JSONObject(jsonString);

        for (String versionName : version.keySet()) {
            JSONObject star = version.getJSONObject(versionName);
            HashMap<String, ArrayList<String>> starCharacters = new HashMap<>();
            for (String starName : star.keySet()) {
                starCharacters.put(starName, new ArrayList<>());
                JSONArray characterArray = star.getJSONArray(starName);
                for (int i=0; i < characterArray.length(); i++) {
                    starCharacters.get(starName).add(characterArray.getString(i));
                }
            }
            characters.put(versionName, starCharacters);
        }
        return characters;
    }
}