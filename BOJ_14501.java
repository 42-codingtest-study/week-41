import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {

    static int[] D;
    static int[] T;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        D = new int[N + 2];
        T = new int[N + 1];
        P = new int[N + 1];
        for (int idx = 1; idx < N + 1; idx++) {
            st = new StringTokenizer(br.readLine());

            T[idx] = Integer.parseInt(st.nextToken());
            P[idx] = Integer.parseInt(st.nextToken());
        }

        for (int day = N; day > 0; day--) {
            if (day + T[day] > N + 1) {
                D[day] = D[day + 1];
            } else {
                D[day] = Math.max(D[day + 1], D[day + T[day]] + P[day]);
            }
        }
        System.out.println(D[1]);
    }

}
