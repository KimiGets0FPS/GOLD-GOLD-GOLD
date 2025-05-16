import java.util.ArrayList;
import java.util.Arrays;

public class WutheringWaves extends Gacha {

    private final ArrayList<String> NonEventFiveStars = new ArrayList<>(Arrays.asList());  // TODO: Add Characters

    private static int fiveStarPity = 0;
    private static int fourStarPity = 0;

    private static double FiveStarRate;
    private static double FourStarRate;

    public WutheringWaves(ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        super(FiveStars, FourStars, ThreeStars);
        FiveStarRate = 0.01;
        FourStarRate = 1.0;
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


    private static void increaseFiveStarRate() {
        FiveStarRate += 0.05;
    }

    private static void increaseFourStarRate() {
        FourStarRate += 0.05;
    }

    public Character pull() {
        /*
        TODO: Pity system
         */
        double roll = Math.random() * 100 + 1;
        if (roll <= FiveStarRate || fiveStarPity == 90) {  // Rolled 5 Star or hit Hard Pity
            // Calculating 50/50
            int fiftyFiftyRoll = (int) (Math.random() * 2);

            // Lost 50/50 and haven't lost 50/50 before
            if (fiftyFiftyRoll == 1 && !getLostFiftyFifty()) {
                setLostFiftyFifty(true);
                FiveStarRate = 0.01;
                return new FiveStarCharacter(NonEventFiveStars.get((int) (Math.random() * NonEventFiveStars.size())), 5, false);
            }
            // Guaranteed (by hard pity) or won 50/50
            else {
                setLostFiftyFifty(false);
                FiveStarRate = 0.01;
                return new FiveStarCharacter(getFiveStars().get(0), 5, true);
            }
        }

        // We don't get 5 star
        increaseFiveStarRate();
        fiveStarPity ++;

        if (roll <= FourStarRate || fourStarPity == 10) { // Rolled 4 Star or hit Hard Pity
            FourStarRate = 1.0;
            return new Character(getFourStars().get((int) (Math.random() * getFourStars().size())), 4);
        }

        // Doesn't roll anything
        increaseFourStarRate();
        fourStarPity ++;

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
