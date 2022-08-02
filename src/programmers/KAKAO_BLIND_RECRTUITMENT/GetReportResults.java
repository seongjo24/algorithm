package programmers.KAKAO_BLIND_RECRTUITMENT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GetReportResults {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> reportMap = new HashMap<String, HashSet<String>>();
        HashMap<String, HashSet<String>> countMap = new HashMap<String, HashSet<String>>();
        HashSet<String> hs = null;
        HashSet<String> hs2 = null;
        List<String> reportList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < report.length; i++) {
            hs = reportMap.getOrDefault(report[i].split(" ")[0], new HashSet<String>());
            hs.add(report[i].split(" ")[1]);
            reportMap.put(report[i].split(" ")[0], hs);
            hs2 = countMap.getOrDefault(report[i].split(" ")[1], new HashSet<String>());
            hs2.add(report[i].split(" ")[0]);
            countMap.put(report[i].split(" ")[1], hs2);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (countMap.get(id_list[i]) != null && countMap.get(id_list[i]).size() >= k) {
                reportList.add(id_list[i]);
            }
        }
        //System.out.println(countMap);
        // System.out.println(reportMap);
        // System.out.println(reportList);
        for (int i = 0; i < id_list.length; i++) {
            count = 0;
            if (reportMap.get(id_list[i]) != null) {
                for (String name : reportMap.get(id_list[i])) {
                    if (reportList.contains(name)) {
                        count++;
                    }
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
