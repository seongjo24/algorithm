package programmers.TOSS;

public class ModeratelyDifficultProblem {

    public int solution(int[] levels) {
        int answer = 0;
        if (levels.length < 4) return -1;
        int num = levels.length - (int) (Math.floor(levels.length / 4.0));
        answer = levels[num];

        return answer;
    }
}
