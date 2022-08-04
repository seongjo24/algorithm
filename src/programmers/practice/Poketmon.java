package programmers.practice;

import java.util.HashSet;

public class Poketmon {
    public int solution(int[] nums) {
        int answer = 0;
        int num = nums.length / 2;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        if (num < hashSet.size()) answer = num;
        else answer = hashSet.size();
        return answer;
    }
}
