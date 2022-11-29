package programmers.practice;

import java.util.Stack;

public class CourierBox {
    public int solution(int[] wantOrder) {
        int answer = 0;

        Stack<Integer> saveOrder = new Stack<Integer>();

        int defaultOrder = 1;
        int wantOrderIdx = 0;

        while (true) {
            if (!saveOrder.isEmpty() && wantOrder[wantOrderIdx] == saveOrder.peek()) {
                answer++;

                wantOrderIdx++;
                saveOrder.pop();

                continue;
            }

            if (defaultOrder > wantOrder.length)
                break;

            if (wantOrder[wantOrderIdx] == defaultOrder) {
                answer++;

                wantOrderIdx++;
                defaultOrder++;

                continue;
            }

            saveOrder.push(defaultOrder);
            defaultOrder++;
        }

        return answer;
    }
}
