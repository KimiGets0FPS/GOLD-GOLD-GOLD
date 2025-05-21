package CMs;

import java.io.*;
import java.util.StringTokenizer;

public class Kattio extends PrintWriter {
    private final BufferedReader r;
    private StringTokenizer st;
    private String token;

    public Kattio() {
        this(System.in, System.out);
    }

    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException _) {
            }
        return token;
    }

    public void nextLine() throws IOException {
        if (hasMoreTokens()) {
            r.readLine();
        }
    }

    public String next() {
        try {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception ignored) {
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
