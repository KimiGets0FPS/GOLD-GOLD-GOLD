import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HonkaiStarRail extends Gacha {
    private static int fiveStarPity = 0;
    private static int fourStarPity = 0;
    private static int totalPity = 0;

    private static final ArrayList<String> NonEventFiveStars = new ArrayList<>(Arrays.asList("Bronya", "Himeko", "Bailu", "Gepard", "Welt", "Clara", "Yanqing"));

    private static double FiveStarRate;
    private static double FourStarRate;

    private static double avgFiveStar = 0;
    private static int totalFiveStars = 0;

    private static int fiftyFiftyWon = 0;
    private static int fiftyFiftyLost = 0;

    public HonkaiStarRail(ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        super("Honkai Star Rail", FiveStars, FourStars, ThreeStars);
        FiveStarRate = 0.03;
        FourStarRate = 5.1;
    }

    public ArrayList<ArrayList<String>> getCharacters() {
        return super.getCharacters();
    }

    public ArrayList<String> getFiveStars() {
        return super.getFiveStars();
    }

    public ArrayList<String> getFourStars() {
        return super.getFourStars();
    }

    public ArrayList<String> getThreeStars() {
        return super.getThreeStars();
    }

    public static boolean getLostFiftyFifty() {
        return Gacha.getLostFiftyFifty();
    }

    public static ArrayList<String> getNonEventFiveStars() {
        return NonEventFiveStars;
    }

    public static int getFiveStarPity() {
        return fiveStarPity;
    }

    public static int getFourStarPity() {
        return fourStarPity;
    }

    public static int getTotalPity() {return totalPity;}

    public static double getAvgFiveStar() {return avgFiveStar;}

    public static int getFiftyFiftyWon() {return fiftyFiftyWon;}

    public static int getFiftyFiftyLost() {return fiftyFiftyLost;}

    public static void increaseFiveStarPity() {
        fiveStarPity++;
    }

    public static void increaseFourStarPity() {
        fourStarPity++;
    }

    public static void resetFiveStarPity() {
        fiveStarPity = 0;
        fourStarPity = 0;
    }

    public static void resetFourStarPity() {
        fourStarPity = 0;
    }

    public Character pull() {
        /*
        TODO: Add pull functionality based on the list of characters given
        TODO: Pity system
         */
        fiveStarPity++;
        fourStarPity++;
        totalPity++;
        FiveStarRate = 99.97 / (1 + Math.pow(Math.E, -0.8 * (fiveStarPity - 82.5))) + 0.03;
        double roll = Math.random() * 100 + 1;
        if (roll <= FiveStarRate || fiveStarPity == 90) {  // Rolled 5 Star or hit Hard Pity
            // Calculating 50/50
            totalFiveStars++;
            avgFiveStar = (double) totalPity / totalFiveStars;
            fiveStarPity = 0;
            fourStarPity = 0;
            int fiftyFiftyRoll = (int) (Math.random() * 2);
            // Lost 50/50 and haven't lost 50/50 before
            if (fiftyFiftyRoll == 1 && !getLostFiftyFifty()) {
                setLostFiftyFifty(true);
                fiftyFiftyWon++;
                return new FiveStarCharacter(NonEventFiveStars.get((int) (Math.random() * NonEventFiveStars.size())), 5, false);
            }
            // Guaranteed (by hard pity) or won 50/50
            else {
                setLostFiftyFifty(false);
                fiftyFiftyLost++;
                return new FiveStarCharacter(getFiveStars().getFirst(), 5, true);
            }
        }

        // We don't get 5 star

        if (roll <= FourStarRate || fourStarPity == 10) { // Rolled 4 Star or hit Hard Pity
            fourStarPity = 0;
            return new Character(getFourStars().get((int) (Math.random() * getFourStars().size())), 4);
        }

        // Doesn't roll anything

        return new Character("poo poo", 3);
    }

    public Character[] tenPull() {
        /*
        TODO: Edit this method based off of the Pull() method above
        NOTE: Do not edit pity in here; the pity should be changed in the Pull() method
         */
        Character[] pulls = new Character[10];
        for (int i=0; i < 10; i ++) {
            pulls[i] = pull();
        }
        return pulls;
    }
}
