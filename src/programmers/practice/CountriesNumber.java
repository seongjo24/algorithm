package programmers.practice;

public class CountriesNumber {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        String[] num = new String[]{"4", "1", "2"};
        int tmp = 0;
        while (n != 0) {
            tmp = n % 3;
            sb.append(num[tmp]);
            n = n / 3;
            if (tmp == 0) n--;
        }
        return sb.reverse().toString();
    }
}
