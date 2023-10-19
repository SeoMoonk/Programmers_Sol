package programmers;

import java.util.*;

import static java.util.Collections.swap;

public class Day1_4 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k1 = 2;

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        int[] solution = sol.solution(id_list1, report1, k1);
        int[] solution1 = sol.solution(id_list2, report2, k2);

        System.out.println("solution = " + Arrays.toString(solution));
        System.out.println("solution1 = " + Arrays.toString(solution1));

    }

    public static class Solution {

        /*
        신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다.
        무지가 개발하려는 시스템은 다음과 같습니다.

        각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
        신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
        한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
        k번 이상 신고된 유저는 게시판 이용이 정지되며,
        해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
        유저가 신고한 모든 내용을 취합하여
        마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
         */

        /*
        point 1. 동일 대상에 대한 신고는 한 번만 가능하다.
        point 2. k번 이상 신고당한 유저는 정지 당한다.
        point 3. "나쁜 유저", "당한 횟수" 형식의 HashMap으로 처리 가능? (인접 행렬로도 가능)
        point 4. 유저가 신고한 모든 내용을 취합하여 신고당한 유저가 K번 이상 신고를 당했다면
                 마지막에 한꺼번에 게시판 이용 정지를 시키면서 신고자에게 정지 메일을 발송합니다.
        point 5. 처리 결과 메일을 받은 횟수를 배열에 담아 return (**Result**) => Set 자료구조?
         */

        //인접행렬을 사용하는 방법
        public int[] solution(String[] id_list, String[] report, int k) {

            int[] answer = new int[id_list.length];
            Map<String, HashSet<String>> map = new HashMap<>();
            Map<String, Integer> idxMap = new HashMap<>();

            for (int i = 0; i < id_list.length; i++) {
                String name = id_list[i];
                map.put(name, new HashSet<>());
                idxMap.put(name, i);
            }

            for (String s : report) {
                String[] str = s.split(" ");
                String from = str[0];
                String to = str[1];
                map.get(to).add(from);
            }

            for (int i = 0; i < id_list.length; i++) {
                HashSet<String> send = map.get(id_list[i]);
                if (send.size() >= k) {
                    for (String name : send) {
                        answer[idxMap.get(name)]++;
                    }
                }
            }
            return answer;
        }
    }
}
