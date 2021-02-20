package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14629 {
    private static int[] nums = {0,1,2,3,4,5,6,7,8,9};
    private static boolean[] visited = new boolean[10];
    private static String tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tmp = br.readLine();
        if(tmp.length() > 10) System.out.println("9876543210");
        else {
            int number = Integer.parseInt(tmp);
            int size = tmp.length();

            int diff = 987654321, answer = 987654321;
            do {
                int num = arrayToInt(nums, size);
                if (Math.abs(number - num) < diff) {
                    diff = Math.abs(number - num);
                    answer = num;
                } else if (Math.abs(number - num) == diff) answer = Math.min(answer, num);
            } while (next_permutation(nums));

            System.out.println(answer);
        }

    }

    private static boolean next_permutation(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while(i > 0 && arr[i-1] >= arr[i]) --i;
        if(i == 0) return false;

        while(arr[i-1] > arr[j]) --j;
        int tmp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = tmp;

        j = arr.length - 1;
        for(; i < j; ++i, --j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return true;
    }

    private static int arrayToInt(int[] array, int size) {
        int num = 0;
        for(int i = 0; i < size; i++) {
            num += array[i] * Math.pow(10, size-i-1);
        }

        return num;
    }
}
