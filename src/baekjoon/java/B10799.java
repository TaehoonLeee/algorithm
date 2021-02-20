package baekjoon.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.next();
        int ans = 0;

        List<Character> stack = new ArrayList<>();

        for(int i = 0; i < scan.length(); i++) {
            if(scan.charAt(i) == '(') stack.add('(');
            else {
                stack.remove(stack.size()-1);

                if(scan.charAt(i-1) == '(') ans+= stack.size();
                else ans += 1;
            }
        }

        System.out.println(ans);
    }
}
