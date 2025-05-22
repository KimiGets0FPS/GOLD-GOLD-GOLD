import java.util.ArrayList;
import java.util.Arrays;

public class Gacha {
    private String name;

    private static boolean LostFiftyFifty = false;

    private static ArrayList<String> FiveStars;
    private static ArrayList<String> FourStars;
    private static ArrayList<String> ThreeStars;

    public Gacha(String name, ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        this.name = name;
        Gacha.FiveStars = FiveStars;
        Gacha.FourStars = FourStars;
        Gacha.ThreeStars = ThreeStars;
    }

    public String getName() {
        return name;
    }

    public boolean getLostFiftyFifty() {
        return LostFiftyFifty;
    }

    public void setLostFiftyFifty(boolean lostFiftyFifty) {
        LostFiftyFifty = lostFiftyFifty;
    }

    public ArrayList<ArrayList<String>> getCharacters() {
        return new ArrayList<>(Arrays.asList(FiveStars, FourStars, ThreeStars));
    }

    public ArrayList<String> getFiveStars() {
        return FiveStars;
    }

    public ArrayList<String> getFourStars() {
        return FourStars;
    }

    public ArrayList<String> getThreeStars() {
        return ThreeStars;
    }

    public Character pull(boolean hsr, double rate) {
        /*
        TODO: Pity system
         */
        
        double roll = Math.random() * 100 + 1;
        if (roll <= rate || hsr ? HonkaiStarRail.getFiveStarPity() : WutheringWaves.getFiveStarPity() == hsr ? 90 : 80) {  // Rolled 5 Star or hit Hard Pity
            // Calculating 50/50
            hsr ? HonkaiStarRail.resetFiveStarPity() : WutheringWaves.resetFiveStarPity();
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
        if (hsr) {
            HonkaiStarRail.increaseFiveStarPity();
        }
        else {
            WutheringWaves.increaseFiveStarPity();
        }

        if (roll <= FourStarRate || fourStarPity == 10) { // Rolled 4 Star or hit Hard Pity
            hsr ? HonkaiStarRail.resetFourStarPity() : WutheringWaves.resetFourStarPity();
            return new Character(getFourStars().get((int) (Math.random() * getFourStars().size())), 4);
        }

        // Doesn't roll anything
        if (hsr) {
            HonkaiStarRail.increaseFourStarPity();
        }
        else {
            WutheringWaves.increaseFourStarPity();
        }


        return new Character("poo poo", 3);
    }
}
