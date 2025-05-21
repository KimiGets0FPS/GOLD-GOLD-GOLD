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



    public Character pull() {
        /*
        TODO: Pity system
         */
        FiveStarRate = 99.2 / (1 + Math.pow(Math.E, -0.6 * (fiveStarPity - 70))) + 0.8;
        System.out.println(FiveStarRate + " ----- " + fiveStarPity);
        double roll = Math.random() * 100 + 1;
        if (roll <= FiveStarRate || fiveStarPity == 80) {  // Rolled 5 Star or hit Hard Pity
            // Calculating 50/50
            fiveStarPity = 0;
            int fiftyFiftyRoll = (int) (Math.random() * 2);
            // Lost 50/50 and haven't lost 50/50 before
            if (fiftyFiftyRoll == 1 && !getLostFiftyFifty()) {
                setLostFiftyFifty(true);
                return new FiveStarCharacter(NonEventFiveStars.get((int) (Math.random() * NonEventFiveStars.size())), 5, false);
            }
            // Guaranteed (by hard pity) or won 50/50
            else {
                setLostFiftyFifty(false);
                return new FiveStarCharacter(getFiveStars().getFirst(), 5, true);
            }
        }

        // We don't get 5 star
        fiveStarPity ++;

        if (roll <= FourStarRate || fourStarPity == 10) { // Rolled 4 Star or hit Hard Pity
            return new Character(getFourStars().get((int) (Math.random() * getFourStars().size())), 4);
        }

        // Doesn't roll anything
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