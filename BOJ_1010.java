import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * eCs
 *
 * dp[e][s] = dp[e - 1][s] + dp[e - 1][s - 1]
 */
public class BOJ_1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < T; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[][] dp = new int[e + 1][e + 1];
            for (int jdx = 0; jdx <= e; jdx++) {
                dp[jdx][0] = 1;
                dp[jdx][1] = jdx;
                dp[jdx][jdx] = 1;
            }

            for (int edx = 2; edx <= e; edx++) {
                for (int sdx = 1; sdx <= s; sdx++) {
                    dp[edx][sdx] = dp[edx - 1][sdx - 1] + dp[edx - 1][sdx];
                }
            }

            System.out.println(dp[e][s]);
        }
    }
}
