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
}
