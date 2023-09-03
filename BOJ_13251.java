import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13251 {

    static int[] arr;
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        arr = new int[M + 1];

        setStoneType(br, M);

        int K = Integer.parseInt(br.readLine());

        double result = getComb(M, K);

        System.out.println(result);
    }

    private static void setStoneType(BufferedReader br, int M) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= M; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
            N += arr[idx];
        }
    }

    private static double getComb(int M, int K) {
        double result = 0;
        for (int idx = 1; idx <= M; idx++) {
            if (arr[idx] >= K) {
                int targetNumberAmount = arr[idx];
                int max = N;

                double tmpResult = 1.0;
                for (int jdx = 1; jdx <= K; jdx++) {
                    tmpResult *= (targetNumberAmount--) / (double)(max--);
                }
                result += tmpResult;
            }
        }
        return result;
    }
}
