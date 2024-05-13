package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG92334_V2 {

    static int[] solution(String[] id_list, String[] report, int k) {

        int memberCount = id_list.length;
        int[][] reportGraph = new int[memberCount][memberCount];
        int[] answer = new int[memberCount];


        Map<String, Integer> memberIdMap = new HashMap<>();

        for(int i=0; i<id_list.length; i++) {
            memberIdMap.put(id_list[i], i);
        }

        for(String history : report) {

            String[] splitHistory = history.split(" ");
            String reporter = splitHistory[0];
            String target = splitHistory[1];

            Integer reporterId = memberIdMap.get(reporter);
            Integer targetId = memberIdMap.get(target);

            if(reportGraph[reporterId][targetId] == 0) {
                reportGraph[reporterId][targetId] = 1;
            }
        }

        for(int i=0; i<memberCount; i++) {
            int sum = 0;
            ArrayList<Integer> reporterList = new ArrayList<>();

            for(int j=0; j<memberCount; j++) {
                if(reportGraph[j][i] == 1) {
                    sum++;
                    reporterList.add(j);
                }
            }

            if(sum >= k) {
                for(Integer reporterId : reporterList) {
                    answer[reporterId] ++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        /*
        0,1 = 1
        2,1 = 1
        1,3 = 1
        0,3 = 1
        2,0 = 1

        0 1 0 1
        0 0 0 1
        1 1 0 0
        0 0 0 0

         */

        int[] solution = solution(id_list, report, k);

        System.out.println(Arrays.toString(solution));
    }
}
