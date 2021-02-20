package baekjoon.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B15918 {
    static int num, x, y, t;
    static List<Integer> nums;
    static List<Boolean> chk;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        t = y-x-1;

        nums = new ArrayList<>();
        chk = new ArrayList<>();
        for(int i = 0; i < num*2 + 1; i++) {
            nums.add(0);
            chk.add(false);
        }
        nums.set(x, t); nums.set(y, t);

        System.out.println(dfs(1));
    }

    static int dfs(int pos) {
        int cnt = 0;

        if(pos == t) return dfs(pos+1);
        if(pos == num + 1) return 1;

        for(int i = 1; i+pos+1 < 2*num+1; i++) {
            if(nums.get(i) == 0 && nums.get(i+pos+1) == 0) {
                nums.set(i, pos); nums.set(i+pos+1, pos);
                cnt += dfs(pos+1);
                nums.set(i, 0); nums.set(i+pos+1, 0);
            }
        }

        return cnt;
    }
}
