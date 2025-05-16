import java.util.ArrayList;
import java.util.Arrays;

public class Gacha {
    private static boolean LostFiftyFifty = false;

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

    public void setLostFiftyFifty(boolean lostFiftyFifty) {
        LostFiftyFifty = lostFiftyFifty;
    }

    public ArrayList<ArrayList<String>> getCharacters() {
        ArrayList<ArrayList<String>> characters = new ArrayList<>(Arrays.asList(FiveStars, FourStars, ThreeStars));
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
