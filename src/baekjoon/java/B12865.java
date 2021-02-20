package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class B12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        int[] dp = new int[k+1];

        for(int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = k; j - weight[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }

        bw.write(dp[k]+"\n");
        bw.flush();
        bw.close();
    }
}
