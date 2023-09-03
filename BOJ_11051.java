import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {

    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int idx = 0; idx <= N; idx++) {
            dp[idx][0] = 1;
            dp[idx][1] = idx;
            dp[idx][idx] = 1;
        }

        for (int idx = 2; idx <= N; idx++) {
            for (int jdx = 1; jdx <= K; jdx++) {
                dp[idx][jdx] = (dp[idx - 1][jdx] + dp[idx - 1][jdx - 1]) % 10007;
            }
        }

        System.out.println(dp[N][K]);
    }
}
