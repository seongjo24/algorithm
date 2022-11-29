package programmers.kakaoCode2017;
//https://school.programmers.co.kr/learn/courses/30/lessons/1837
class GPS {
    int zero = 0;
    int one = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        backTrack(arr, 0, arr.length-1, 0, arr[0].length-1);
        answer[0] = zero;
        answer[1] = one;

        return answer;
    }

    public void backTrack(int[][] arr, int startX, int endX, int startY, int endY){
        int zeroOrOne = arr[startX][startY];
        boolean allCheck = true;

        loop:
        for(int i = startX; i < endX+1; i++){
            for(int j = startY; j < endY+1; j++){
                if(arr[i][j] != zeroOrOne){
                    allCheck = false;
                    break loop;
                }
            }
        }

        if(allCheck){
            if(zeroOrOne == 0){
                zero++;
            }else{
                one++;
            }
            return;
        }

        backTrack(arr, startX, (startX+endX)/2, startY, (startY+endY)/2);
        backTrack(arr, startX, (startX+endX)/2, (startY+endY)/2+1, endY);
        backTrack(arr, (startX+endX)/2+1, endX, startY, (startY+endY)/2);
        backTrack(arr, (startX+endX)/2+1, endX, (startY+endY)/2+1, endY);

    }
}