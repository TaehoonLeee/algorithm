package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4811 {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new long[31][31];
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[3][0] = 5;

        eat(30, 0);

        int n = 0;
        while(true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            System.out.println(dp[n][0]);
        }
    }

    private static long eat(int W, int H) {
        if(W == 0) return 1;
        if(dp[W][H] != 0) return dp[W][H];

        long cnt = 0;
        if(W != 0) cnt += eat(W-1, H+1);
        if(H != 0) cnt += eat(W, H-1);

        return dp[W][H] = cnt;
    }
}
