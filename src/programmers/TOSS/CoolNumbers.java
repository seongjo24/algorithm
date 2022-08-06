package programmers.TOSS;

public class CoolNumbers {
    public int solution(String s) {
        int answer = -1;
        char c = ' ';
        int cnt = 1;
        for (int i = 0; i < s.length(); i++) {

            if (c == s.charAt(i)) cnt++;
            else cnt = 1;

            if (cnt == 3) answer = Math.max(answer, Character.getNumericValue(c) * 111);

            c = s.charAt(i);
        }
        return answer;
    }
}
