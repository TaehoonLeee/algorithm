package programmers.java;

import java.util.*;

class PracticeTest {
    private static int[] one = {1, 2, 3, 4, 5};
    private static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answer = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % 5]) answer[0] += 1;
            if(answers[i] == two[i % 8]) answer[1] += 1;
            if(answers[i] == three[i % 10]) answer[2] += 1;
        }

        int win = 0;
        for(int i = 0; i < 3; i++) {
            if(answer[i] > answer[win]) win = i;
        }

        List<Integer> winners = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(answer[i] == answer[win]) winners.add(i+1);
        }

        answer = new int[winners.size()];
        for(int i = 0; i < winners.size(); i++) {
            answer[i] = winners.get(i);
        }

        return answer;
    }
}