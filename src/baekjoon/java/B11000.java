package baekjoon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(lectures[0].end);

        for(int i = 1; i < n; i++) {
            if(priorityQueue.peek() <= lectures[i].start) priorityQueue.poll();
            priorityQueue.offer(lectures[i].end);
        }

        System.out.println(priorityQueue.size());
    }

    static class Lecture {
        int start;
        int end;

        public Lecture(int _start, int _end) {
            this.start = _start;
            this.end = _end;
        }
    }
}
