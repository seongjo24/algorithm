package programmers.practice;

import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {
    int ticketSize;
    String[][] tickets;
    ArrayList<String> answerList;
    boolean[] visit;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ticketSize = tickets.length;
        this.tickets = tickets;
        visit = new boolean[ticketSize];
        answerList = new ArrayList<>();
        dfs("ICN", "", 0);
        Collections.sort(answerList);

        answer = answerList.get(0).split(" ");
        return answer;
    }

    public void dfs(String now, String strAnswer, int cnt) {
        strAnswer += (now + " ");
        if (cnt == ticketSize) {
            answerList.add(strAnswer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && tickets[i][0].equals(now)) {
                visit[i] = true;
                dfs(tickets[i][1], strAnswer, cnt + 1);
                visit[i] = false;
            }

        }


    }
}
