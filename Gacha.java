import java.util.ArrayList;

public class Gacha {
    private ArrayList<String> FiveStar;
    private ArrayList<String> FourStar;
    private ArrayList<String> ThreeStar;
    private static int pity;

    public Gacha(ArrayList<String> FiveStar, ArrayList<String> FourStar, ArrayList<String> ThreeStar) {
        this.FiveStar = FiveStar;
        this.FourStar = FourStar;
        this.ThreeStar = ThreeStar;
        pity = 0;
    }

    public static String Pull() {
        pity ++;
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
