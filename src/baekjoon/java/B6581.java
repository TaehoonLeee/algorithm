package baekjoon.java;

import java.io.*;

public class B6581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        String str;
        while( !(str = br.readLine()).isEmpty()) {
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ') {
                    if(i+1 < str.length() && str.charAt(i+1) == ' ') {
                        i += 1;
                        while(str.charAt(i) == ' ') i++;
                        bw.write(' ');
                    }
                    else {
                        if(i+1 < str.length() && str.charAt(i+1) == '<') {
                            i += 1;
                            if(i+1 < str.length() && str.charAt(i+1) == 'b') {
                                bw.write('\n');
                                i += 3;
                            }
                            else if(i+1 < str.length() && str.charAt(i+1) == 'h') {
                                if(i-2 > 0 && str.charAt(i-2) != '>') bw.write('\n');
                                for(int j = 0; j < 80; j++) {
                                    bw.write('-');
                                }
                                bw.write('\n');
                                i += 3;
                            }
                        }
                        else {
                            cnt++;
                            if(i-1 > 0 && str.charAt(i-1) != '>') bw.write(' ');
                            if (cnt == 80) {
                                cnt = 0;
                                bw.write('\n');
                            }
                        }
                    }
                }
                else if(str.charAt(i) == '<') {
                    i += 1;
                    if(i < str.length() && str.charAt(i) == 'b') {
                        bw.write('\n');
                        i += 2;
                    }
                    else if(i < str.length() && str.charAt(i) == 'h') {
                        bw.write('\n');
                        for(int j = 0; j < 80; j++) {
                            bw.write('-');
                        }
                        bw.write('\n');
                        i += 2;
                    }
                }
                else {
                    bw.write(str.charAt(i));
                }
            }
        }

        bw.flush();
        bw.close();

    }
}
