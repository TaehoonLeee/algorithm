package programmers.java;

import java.util.*;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        if(yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
        }
        else {
            for(int i = 1; i <= Math.sqrt(yellow); i++) {
                if(yellow % i == 0) {
                    if((i*2 + (yellow / i)*2 + 4) == brown) {
                        answer[0] = (yellow / i) + 2;
                        answer[1] = i + 2;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
