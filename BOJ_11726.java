import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        D = new int[n + 1];

        D[1] = 1;
        if (n == 1) {
            System.out.println(D[1]);
            return;
        }
        D[2] = 2;
        for (int idx = 3; idx <= n; idx++) {
            D[idx] = (D[idx - 1] + D[idx - 2]) % 10007;
        }
        System.out.println(D[n]);

    }
}
