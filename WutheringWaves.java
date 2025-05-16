import java.util.ArrayList;
import java.util.Arrays;

public class WutheringWaves extends Gacha {

    private final ArrayList<String> NonEventFiveStars = new ArrayList<>(Arrays.asList());  // TODO: Add Characters

    private static int fiveStarPity = 0;
    private static int fourStarPity = 0;

    private double FiveStarRate;
    private double FourStarRate;

    public WutheringWaves(ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        super(FiveStars, FourStars, ThreeStars);
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

    public static String Pull() {
        /*
        TODO: Change output to something like HashMap<String, String[]> where the key is the character name and the
         values are properties of the character (ie. rarity, event character, etc.)
        TODO: Add pull functionality based on the list of characters given
        TODO: Pity system
         */
        return "";
    }

    public static String[] TenPull() {
        /*
        TODO: Edit this method based off of the Pull() method above
        NOTE: Do not edit pity in here; the pity should be changed in the Pull() method
         */
        String[] pulls = new String[10];
        for (int i=0; i < 10; i ++) {
            pulls[i] = Pull();
        }
        return pulls;
    }
}
