package gavia;

import java.util.Arrays;

public class Sol1 {
    int[] foods;
    int answer;
    int avg;

    public int solution(int[] foods) {
        answer = 0;
        if ((Arrays.stream(foods).sum()) % 3 != 0 || foods.length < 3) {
            return 0;
        }

        this.foods = foods;
        avg = (Arrays.stream(foods).sum()) / 3;
        feed(0, 0);

        return answer;
    }

    public void feed(int cnt, int x) {
        if (cnt == 3) {
            answer++;
            return;
        }
        int sum = 0;
        for (int i = x; i < foods.length; i++) {
            sum += foods[i];
            if (cnt == 2) {
                if (i == foods.length - 1 && avg == sum) {
                    cnt++;
                    feed(cnt, i + 1);
                    cnt--;
                }
            } else if (avg == sum) {
                cnt++;
                feed(cnt, i + 1);
                cnt--;
            }
        }
    }
}
