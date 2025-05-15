import java.util.ArrayList;

public class Gacha {
    private ArrayList<String> FiveStar;
    private ArrayList<String> FourStar;
    private ArrayList<String> ThreeStar;

    public Gacha(ArrayList<String> FiveStar, ArrayList<String> FourStar, ArrayList<String> ThreeStar) {
        this.FiveStar = FiveStar;
        this.FourStar = FourStar;
        this.ThreeStar = ThreeStar;
    }

    public static String Pull() {
        // Version; Patch
        // 5 Star, 4 Star, 3 Star
        // Specific Characters
        return "";
    }

    public static String[] TenPull() {
        String[] pulls = new String[10];
        for (int i=0; i < 10; i ++) {
            pulls[i] = Pull();
        }
        return pulls;
    }
}
