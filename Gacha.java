import java.util.ArrayList;

public class Gacha {
    private boolean LostFiftyFifty = false;

    // Rates
    private static int FiveStarPity = 0;
    private static int FourStarPity = 0;

    private static ArrayList<String> FiveStars;
    private static ArrayList<String> FourStars;
    private static ArrayList<String> ThreeStars;

    public Gacha(ArrayList<String> FiveStars, ArrayList<String> FourStars, ArrayList<String> ThreeStars) {
        Gacha.FiveStars = FiveStars;
        Gacha.FourStars = FourStars;
        Gacha.ThreeStars = ThreeStars;
    }

    public boolean getLostFiftyFifty() {
        return LostFiftyFifty;
    }

    public int getFiveStarPity() {
        return FiveStarPity;
    }

    public int getFourStarPity() {
        return FourStarPity;
    }

    public ArrayList<ArrayList<String>> getCharacters() {
        ArrayList<ArrayList<String>> characters = new ArrayList<>();
        return characters;
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
}
