package baekjoon.java;

import java.io.*;

public class B4354 {
    private static int[] next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        while( !s.equals(".") ) {
            next = new int[s.length()];
            next[0] = 0;

            int j = 0;
            for(int i = 1; i < s.length(); i++) {
                while( (j > 0) && (s.charAt(i) != s.charAt(j)) ) j = next[j-1];
                if(s.charAt(i) == s.charAt(j)) next[i] = ++j;
            }

            int answer;
            if(s.length() % (s.length()-next[s.length()-1]) != 0) answer = 1;
            else answer = s.length() / (s.length() - next[s.length()-1]);
            bw.write( answer + "\n");
            s = br.readLine();
        }

        bw.flush();
        bw.close();
    }
}
