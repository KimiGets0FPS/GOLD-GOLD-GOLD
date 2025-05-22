import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HonkaiStarRail extends Gacha {
    private static int fiveStarPity = 0;
    private static int fourStarPity = 0;

    private static final ArrayList<String> NonEventFiveStars = new ArrayList<>(Arrays.asList("Bronya", "Himeko", "Bailu", "Gepard", "Welt", "Clara", "Yanqing"));

    private static double FiveStarRate;
    private static double FourStarRate;

    public HonkaiStarRail(ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        super("Honkai Star Rail", FiveStars, FourStars, ThreeStars);
        FiveStarRate = 0.01;
        FourStarRate = 1.0;
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

    public boolean getLostFiftyFifty() {
        return super.getLostFiftyFifty();
    }

    public ArrayList<String> getNonEventFiveStars() {
        return NonEventFiveStars;
    }

    public static int getFiveStarPity() {
        return fiveStarPity;
    }

    public static int getFourStarPity() {
        return fourStarPity;
    }

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
        FiveStarRate = 99.97 / (1 + Math.pow(Math.E, -0.8 * (fiveStarPity - 82.5))) + 0.03;
        return super.pull(true, FiveStarRate);
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
