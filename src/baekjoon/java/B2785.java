package baekjoon.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B2785 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        List<Integer> chains = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < num; i++) {
            chains.add(scanner.nextInt());
        }

        Collections.sort(chains);

        while(true) {
            if(chains.size() == 1) break;

            chains.set(0, chains.get(0) - 1);
            chains.remove(chains.size() - 1);
            if(chains.get(0) == 0) chains.remove(0);

            cnt++;
        }
        System.out.println(cnt);
    }

}
