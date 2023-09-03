import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193 {

    static long[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        D = new long[N + 1];

        D[0] = 0;
        D[1] = 1;

        for (int idx = 2; idx <= N; idx++) {
            D[idx] = D[idx - 2] + D[idx - 1];
        }
        System.out.println(D[N]);
    }

}
