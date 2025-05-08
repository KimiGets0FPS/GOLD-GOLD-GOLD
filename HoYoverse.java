import java.util.ArrayList;

public class HoYoverse extends Gacha {
    public HoYoverse(ArrayList<String> FiveStar, ArrayList<String> FourStar, ArrayList<String> ThreeStar) {
        super(FiveStar, FourStar, ThreeStar);
    }

    public static ArrayList<ArrayList<String>> getCharacters() {
        ArrayList<ArrayList<String>> characters = new ArrayList<>();
        return characters;
    }
}
