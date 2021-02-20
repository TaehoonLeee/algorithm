package baekjoon.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1417 {
    public static void main(String[] args) throws IOException {
        int N;
        int D;
        List<Integer> people = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }
        D = Integer.parseInt(br.readLine());
        for(int i = 0; i < N-1; i++) {
            people.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(people, Collections.reverseOrder());

        int cnt = 0;
        while(D <= people.get(0)) {
            cnt++;
            people.set(0, people.get(0)-1);
            D++;
            Collections.sort(people, Collections.reverseOrder());
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
