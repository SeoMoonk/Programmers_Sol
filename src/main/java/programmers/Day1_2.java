package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1_2 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};

        String[] participant2 = {"mariana", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "mariana", "nikola"};

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        String solution1 = sol.solution3(participant1, completion1);
        String solution2 = sol.solution3(participant2, completion2);
        String solution3 = sol.solution3(participant3, completion3);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);

    }

    //수많은 마라톤 선수들이 마라톤에 참여하였습니다.
    // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    //마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
    // 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    // 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

    public static class Solution {

        //효율성 X ArrayList
        public String solution(String[] participant, String[] completion) {

            ArrayList<String> arr = new ArrayList<>();

            for(int i=0; i<participant.length; i++) {
                arr.add(participant[i]);
            }

            for(int i=0; i<completion.length; i++) {
                arr.remove(completion[i]);
            }

            String answer = arr.get(0);
            return answer;
        }

        public String solution2(String[] participant, String[] completion) {

            String answer = "";

            List<String> list = Arrays.stream(completion).toList();

            //돔명이인 처리 불가
            for(String s : participant) {
                if(!list.contains(s)){
                    answer = s;
                    break;
                }
            }

            return answer;
        }

        public String solution3(String[] participant, String[] completion) {

            String answer = "";

            ArrayList<String> compList = new ArrayList<>(Arrays.asList(completion));

            for(String p : participant) {
                //못지운다 => 완주를 못했다
                if(!compList.remove(p)){
                    answer = p;
                }
            }
            return answer;
        }
    }


}
