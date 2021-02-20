package baekjoon.java;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {
    private static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        times = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int time = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            time += times[i];
            sum += time;
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}
