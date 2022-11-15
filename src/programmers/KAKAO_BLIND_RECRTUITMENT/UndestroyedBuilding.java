package programmers.KAKAO_BLIND_RECRTUITMENT;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/92344
public class UndestroyedBuilding {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int gb = 0;
        int[][] tmp = new int[board.length + 1][board[0].length + 1];
        Arrays.asList(tmp).forEach(i -> Arrays.fill(i, 0));
        // Arrays.asList(tmp).forEach(ints -> System.out.println(Arrays.toString(ints)));
        for (int i = 0; i < skill.length; i++) {
            gb = (skill[i][0] == 1) ? -1 : 1;
            tmp[skill[i][1]][skill[i][2]] = tmp[skill[i][1]][skill[i][2]] + (skill[i][5] * gb);
            tmp[skill[i][1]][skill[i][4] + 1] = tmp[skill[i][1]][skill[i][4] + 1] + (skill[i][5] * gb * -1);
            tmp[skill[i][3] + 1][skill[i][2]] = tmp[skill[i][3] + 1][skill[i][2]] + (skill[i][5] * gb * -1);
            tmp[skill[i][3] + 1][skill[i][4] + 1] = tmp[skill[i][3] + 1][skill[i][4] + 1] + (skill[i][5] * gb);

        }

        for (int i = 0; i < tmp.length - 1; i++) {
            for (int j = 0; j < tmp.length; j++) {
                tmp[i + 1][j] = tmp[i + 1][j] + tmp[i][j];
            }
        }
        // Arrays.asList(tmp).forEach(ints -> System.out.println(Arrays.toString(ints)));
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp.length - 1; j++) {
                tmp[i][j + 1] = tmp[i][j + 1] + tmp[i][j];
            }
        }
        //  Arrays.asList(tmp).forEach(ints -> System.out.println(Arrays.toString(ints)));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] + tmp[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
