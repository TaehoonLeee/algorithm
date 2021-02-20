package baekjoon.java;

import java.io.*;
import java.util.ArrayList;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        ArrayList<String> stack = new ArrayList<>();

        int firstMinusIndex = Integer.MAX_VALUE;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == '-') {
                if(firstMinusIndex == Integer.MAX_VALUE) firstMinusIndex = stack.size();
                i += 1;
                i = add(str, stack, i);
            }
            else {
                i = add(str, stack, i);
            }
        }

        int sum = 0;
        for(int i = 0; i < stack.size(); i++) {
            if(i < firstMinusIndex) {
                sum += Integer.parseInt(stack.get(i));
            }
            else {
                sum -= Integer.parseInt(stack.get(i));
            }
        }

        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }

    private static int add(char[] str, ArrayList<String> stack, int i) {
        int index = i;
        while (i < str.length && str[i] != '-') i++;
        String tmp = "";
        for (int j = index; j < i; j++) {
            if (str[j] == '+') {
                stack.add(tmp);
                j += 1;
                tmp = "";
            }
            tmp += str[j];
        }
        stack.add(tmp);
        i--;
        return i;
    }
}
