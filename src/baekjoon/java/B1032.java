package baekjoon.java;

import java.io.*;

public class B1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[] str = br.readLine().toCharArray();
        for(int i = 1; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                if(str[j] != input.charAt(j)) str[j] = '?';
            }
        }

        for(int i = 0; i < str.length; i++) {
            bw.write(str[i]);
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
