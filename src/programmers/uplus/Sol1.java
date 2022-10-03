package programmers.uplus;

import java.util.*;

public class Sol1 {
    public int solution(int[] arr) {
        Set<List<String>> set = new HashSet<>();
        for (int item : arr) {
            List<String> list = Arrays.asList(String.valueOf(item).split(""));
            Collections.sort(list);
            set.add(list);
        }
        return set.size();
    }
}
