import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class Kattio extends PrintWriter {
    public Kattio(String fileName) throws IOException {
        super(new BufferedOutputStream(new FileOutputStream(fileName + ".json")));
        r = new BufferedReader(new InputStreamReader(new FileInputStream(fileName + ".json")));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() {
        return Long.parseLong(nextToken());
    }

    public String next() {
        return nextToken();
    }

    private final BufferedReader r;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException _) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        simulateHSR();
    }
//    public static void main(String[] args) {
//        Scanner io = new Scanner(System.in);
//        String option;
//        while (true) {
//            System.out.println("HSR or WuWa: ");
//            option = io.nextLine().toLowerCase();
//            if (option.equals("hsr") || option.equals("wuwa")) {
//                break;
//            }
//            else {
//                System.out.print("Invalid input!\nPress Enter to continue...");
//                io.nextLine();
//                ColorPrint.clear();
//            }
//        }
//        if (option.equals("hsr")) {
//            simulateHSR();
//        }
//        else {
//            simulateWuWa();
//        }
//        ColorPrint.cpln("Thank you for playing!", ColorPrint.GREEN_TEXT);
//    }

    public static void simulateHSR() throws IOException {
        // Get characters before calling this
        // Version No, Patch No.
        // 5 Star, 4 Star, 3 Star
        // Specific Characters
        HashMap<String, String> banners = parse(readFile("HSRCharacters"));
        int i=1;
        for (String key : banners.keySet()) {
            System.out.println(i + ". " + key);
            i ++;
        }

        HonkaiStarRail hsr = new HonkaiStarRail(null, null, null);
    }

    public static void simulateWuWa() {
        // Get characters before calling this
        // Check HSRCharacters.json before creating the list of characters


        WutheringWaves wuwa = new WutheringWaves(null, null, null);
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        Kattio io = new Kattio(fileName);
        while (io.hasMoreTokens()) {
            content.append(io.next());
        }
        return content.toString();
    }

    public static HashMap<String, String> parse(String jsonString) {
        HashMap<String, String> output = new HashMap<>();
        jsonString = jsonString.trim();
        if (jsonString.startsWith("{") && jsonString.endsWith("}")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1);
            String[] keyValuePairs = jsonString.split(",");
            for (String keyValuePair : keyValuePairs) {
                String[] parts = keyValuePair.split(":");
                if (parts.length == 2) {
                    String key = parts[0].trim().replaceAll("\"", "");
                    String value = parts[1].trim().replaceAll("\"", "");
                    output.put(key, value);
                }
            }
        }
        return output;
    }

}
