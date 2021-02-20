package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class B11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int min = 0;
        for(int i = n-1; i >= 0; i--) {
            if(coins[i] <= k) {
                min += k / coins[i];
                k -= coins[i] * (k / coins[i]);
            }
        }

        bw.write(min+"\n");
        bw.flush();
        bw.close();

    }
}
