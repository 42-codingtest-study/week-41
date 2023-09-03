import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775 {
    private static int MAX = 14;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] apart = new int[MAX + 1][MAX + 1];

        for (int jdx = 0; jdx <= MAX; jdx++) {
            apart[0][jdx] = jdx;
        }

        for (int kdx = 1; kdx <= MAX; kdx++) {
            for (int ndx = 1; ndx <= MAX; ndx++) {
                apart[kdx][ndx] = apart[kdx][ndx - 1] +  apart[kdx - 1][ndx];
            }
        }

        for (int idx = 0; idx < T; idx++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(apart[k][n]);
        }

    }
}
