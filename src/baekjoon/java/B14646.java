package baekjoon.java;

import java.io.*;
import java.util.StringTokenizer;

public class B14646 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] menus = new int[n+1];

        int minus = 0;
        int sticker = 0; int answer = 0;
        for(int i = 0; i < n+n; i++) {
            int menu = Integer.parseInt(st.nextToken());
            if(++menus[menu] == 2) {
                minus--;
            }
            else sticker++;
            answer = Math.max(answer, sticker + minus);
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}