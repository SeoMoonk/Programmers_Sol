package programmers;

import java.util.*;

public class PG92334 {

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

        //인접행렬을 사용하는 방법
        public int[] solution(String[] id_list, String[] report, int k) {

            //repost를 HashSet으로 중복 제거 후 다시 리스트로 만듦.
            report = new HashSet<>(Arrays.asList(report)).toArray(new String[0]);
            int num = id_list.length;

            int[][] user_relation = new int[num][num];

            for (String r : report) {

                String[] users = r.split(" ");

                //신고한 사람의 인접행렬 인덱스
                int reporterIdx = Arrays.asList(id_list).indexOf(users[0]);

                //신고 당한 사람의 인접행렬 인덱스
                int reportedIdx = Arrays.asList(id_list).indexOf(users[1]);

                user_relation[reporterIdx][reportedIdx] = 1;

            }

            int[] answer = new int[num];

            for (int c = 0; c < num; c++ ) {

                int cnt = 0;

                for(int r = 0; r < num; r++) {

                    //신고가 확인되면 +1
                    if(user_relation[r][c] == 1) {
                        cnt++;
                    }

                    //누적 신고횟수에 도달하면 신고한 사람들 answer에 추가하고 브레이크.
                    if(cnt >= k) {

                        for(int r2 = 0; r2 < num; r2++) {
                            answer[r2] += user_relation[r2][c];
                        }
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
