package programmers.practice;
import java.util.*;
public class PickingTangerines {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for( int i : tangerine){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for(Integer x : list){
            k -= map.get(x);
            answer++;
            if(k <= 0){
                break;
            }
        }

        return answer;
    }
}
