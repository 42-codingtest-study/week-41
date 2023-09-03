import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {

    static final long MOD = 1_000_000_000L;
    static long[][] D;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        D = new long[N + 1][10];

        for (int idx = 1; idx <= 9; idx++) {
            D[1][idx] = 1;
        }

        for (int idx = 2; idx <= N; idx++) {
            for (int jdx = 0; jdx <= 9; jdx++) {
                if (jdx == 0) {
                    D[idx][0] = (D[idx - 1][1]) % MOD;
                } else if (jdx == 9) {
                    D[idx][9] = (D[idx - 1][8]) % MOD;
                } else {
                    D[idx][jdx] = (D[idx - 1][jdx - 1] + D[idx - 1][jdx + 1]) % MOD;
                }
            }
        }

        long result = 0;
        for (long count : D[N]) {
            result += count;
        }
        System.out.println(result % MOD);
    }

}
