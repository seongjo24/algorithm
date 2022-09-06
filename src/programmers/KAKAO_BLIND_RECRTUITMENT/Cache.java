package programmers.KAKAO_BLIND_RECRTUITMENT;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/17680
class Cache {

    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5 * cities.length;

        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        for(int i = 0 ; i < cities.length ; ++i){
            String city = cities[i].toUpperCase();


            if(cache.remove(city)){
                cache.addFirst(city);
                answer += CACHE_HIT;
            } else {
                int currentSize = cache.size();

                if(currentSize == cacheSize){
                    cache.pollLast();
                }

                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }
        return answer;
    }
}