import java.util.ArrayList;

public class HonkaiStarRail extends HoYoverse {
    public HonkaiStarRail() {
        ArrayList<String> FiveStar = new ArrayList<>();
        ArrayList<String> FourStar = new ArrayList<>();
        ArrayList<String> ThreeStar = new ArrayList<>();
        super(FiveStar, FourStar, ThreeStar);
    }

    public static ArrayList<ArrayList<String>> getCharacters() {
        ArrayList<ArrayList<String>> characters = new ArrayList<>();
        return characters;
    }
}
