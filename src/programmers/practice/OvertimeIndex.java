package programmers.practice;

import java.util.Collections;
import java.util.PriorityQueue;

class OvertimeIndex {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            overtime.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int max = (int) overtime.poll();
            if (max <= 0) break;
            overtime.offer(max - 1);
        }

        return sumPow(overtime);
    }

    long sumPow(PriorityQueue<Integer> works) {
        long sum = 0;
        while (!works.isEmpty()) {
            sum += Math.pow(works.poll(), 2);
        }
        return sum;
    }

}