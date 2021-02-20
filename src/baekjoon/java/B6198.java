package baekjoon.java;

import java.io.*;
import java.util.Stack;

public class B6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        n = Integer.parseInt(br.readLine());

        Long[] people = new Long[n];
        for (int i = 0; i < n; i++) {
            people[i] = Long.parseLong(br.readLine());
        }

        long answer = 0L;
        Stack<Long> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while( !stack.empty() && stack.lastElement() <= people[i] ) stack.pop();
            answer += stack.size();
            stack.push(people[i]);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
