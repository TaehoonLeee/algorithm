import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        int[] answer = new int[] {1, 3, 2};

        List<Integer> tmp = Arrays.stream(answer).boxed().collect(Collectors.toList());

        tmp.remove(Integer.valueOf(3));
        System.out.println(tmp);
    }

    /*
    연속된 숫자로 조를 묶기 때문에, 최소 값을 구하려면 가장 큰 differ가 나타나는 것을 제외하고 나머지 differ를 합하면 됨.
     */
    private static void problem2() {
        int[] scores = new int[] {1, 2,12,14,15};
        int k = 2;
        List<Integer> differs = new ArrayList<>();

        differs.add(0);
        for(int i = 1; i < scores.length; i++) {
            differs.add(scores[i]-scores[i-1]);
        }

        differs.sort(Comparator.reverseOrder());

        int answer = 0;
        for(int i = k-1; i < differs.size(); i++) {
            answer += differs.get(i);
        }

        System.out.println(answer);
    }

    private static void problem1() {
        String[] card_numbers = new String[]{"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245"};

        for(int i = 0; i < card_numbers.length; i++) {
            if(card_numbers[i].contains("-")) {
                if(card_numbers[i].length() == 19 && isRightPattern(card_numbers[i])) {
                    card_numbers[i] = card_numbers[i].replaceAll("-", "");
                }
                else card_numbers[i] = "0";
            }
            else {
                if( !(card_numbers[i].length() == 16) ) card_numbers[i] = "0";
            }
        }

        int even = 0, odd = 0;
        for(int i = 0; i < card_numbers.length; i++) {
            if(card_numbers[i].length() > 1) {
                for (int j = 0; j < card_numbers[i].length(); j++) {
                    int num = card_numbers[i].charAt(j) - '0';

                    if (j % 2 == 0) {
                        if (num >= 5) even += 1 + 2 * (num - 5);
                        else even += 2 * num;
                    } else {
                        odd += num;
                    }
                }
                if ((even + odd) % 10 == 0) card_numbers[i] = "1";
                else card_numbers[i] = "0";
            }
        }

        for(int i = 0; i <card_numbers.length; i++) {
            System.out.println(card_numbers[i]);
        }

    }

    private static boolean isRightPattern(String cardNumbers) {
        boolean ret = false;

        for(int i = 1; i < 4; i++) {
            if( !(cardNumbers.charAt(5*i-1) == '-') ) {
                break;
            }
            if( i == 3 ) ret = true;
        }

        return ret;
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
}
