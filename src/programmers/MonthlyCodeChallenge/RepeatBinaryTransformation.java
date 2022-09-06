package programmers.MonthlyCodeChallenge;

class RepeatBinaryTransformation {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int try_count = 0;
        int zero_count = 0;
        while (!s.equals("1")) {
            try_count++;
            String temp = s.replaceAll("0", "");
            int zero_temp = 0;
            zero_temp = s.length() - temp.length();
            zero_count += zero_temp;

            s = Integer.toBinaryString(temp.length());
        }
        answer[0] = try_count;
        answer[1] = zero_count;

        return answer;
    }
}