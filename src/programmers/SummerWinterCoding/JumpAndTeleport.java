package programmers.SummerWinterCoding;
//https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;

        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}