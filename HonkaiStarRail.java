import java.util.ArrayList;

public class HonkaiStarRail extends Gacha {
    private ArrayList<String> FiveStar;
    private ArrayList<String> FourStar;
    private ArrayList<String> ThreeStar;

    // Rates
    private static int FiveStarPity = 0;
    private static int FourStarPity = 0;

    private double FiveStarRate;
    private double FourStarRate;

    public HonkaiStarRail(ArrayList<String> FiveStar, ArrayList<String> FourStar, ArrayList<String> ThreeStar) {
        super(FiveStar, FourStar, ThreeStar);
        this.FiveStar = FiveStar;
        this.FourStar = FourStar;
        this.ThreeStar = ThreeStar;
    }

    public static ArrayList<ArrayList<String>> getCharacters() {
        ArrayList<ArrayList<String>> characters = new ArrayList<>();
        return characters;
    }
}
