import java.util.ArrayList;
import java.util.Arrays;

public class WutheringWaves extends Gacha {
    private static final ArrayList<String> NonEventFiveStars = new ArrayList<>(Arrays.asList("Encore", "Corpus", "Lingyang", "Verina", "Jianxin"));

    private static int fiveStarPity = 0;
    private static int fourStarPity = 0;

    private static double FiveStarRate;
    private static double FourStarRate;


    public WutheringWaves(ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        super("Wuthering Waves", FiveStars, FourStars, ThreeStars);
        FiveStarRate = 0.8;
        FourStarRate = 6.0;
    }

    public ArrayList<ArrayList<String>> getCharacters() {
        return super.getCharacters();
    }

    public ArrayList<String> getFourStars() {
        return super.getFourStars();
    }

    public ArrayList<String> getThreeStars() {
        return super.getThreeStars();
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
        TODO: Pity system
         */
        FiveStarRate = 99.2 / (1 + Math.pow(Math.E, -0.6 * (fiveStarPity - 70))) + 0.8;
        return super.pull(false, FiveStarRate);
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