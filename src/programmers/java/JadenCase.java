package programmers.java;

class JadenCase {
    public String solution(String s) {
        boolean isCapital = true;
        char[] tmp = s.toCharArray();
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i] == ' ') isCapital = true;
            else if(tmp[i] >= 48 && tmp[i] <= 57) {
                isCapital = false;
            }
            else if(isCapital && !capital(tmp[i])) {
                tmp[i] -= 32;
                isCapital = false;
            }
            else if(isCapital && capital(tmp[i])) {
                isCapital = false;
            }
            else if(tmp[i] >= 65 && tmp[i] <= 90) tmp[i] += 32;
        }
        return String.valueOf(tmp);
    }

    private static boolean capital(char a) {
        return a >= 65 && a <= 90;
    }
}