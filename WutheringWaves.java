import java.util.ArrayList;

public class WutheringWaves extends Gacha {
    private ArrayList<String> FiveStar;
    private ArrayList<String> FourStar;
    private ArrayList<String> ThreeStar;

    private static int fiveStarPity = 0;
    private static int fourStarPity = 0;

    public WutheringWaves(ArrayList<String> FiveStar, ArrayList<String> FourStar, ArrayList<String> ThreeStar) {
        super(FiveStar, FourStar, ThreeStar);
        this.FiveStar = FiveStar;
        this.FourStar = FourStar;
        this.ThreeStar = ThreeStar;
    }

    public static ArrayList<ArrayList<String>> getCharacters() {
        ArrayList<ArrayList<String>> characters = new ArrayList<>();
        return characters;
    }

    public static void single() {
        if (fiveStarPity == 80) {
            fiveStarPity = 0;

        }
        else if (fourStarPity == 10) {

        }
        else {

        }
    }
}
