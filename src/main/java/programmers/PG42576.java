package programmers;

import java.util.*;

public class PG42576 {

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
                //ArrayList의 remove는 동명이인을 한번에 날려버리지는 않는다.
                arr.remove(completion[i]);
            }

            String answer = arr.get(0);

            return answer;
        }

        public String solution2(String[] participant, String[] completion) {

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

        public String solution3(String[] participant, String[] completion) {

            String answer = "";
            HashMap<String, Integer> myMap = new HashMap<>();

            for(String part : participant) {
                //새로운 인물이라면 디폴트 값인 0으로 넣고, 이미 존재하는 인물은 +1된 값을 맵에 넣음.
                myMap.put(part, myMap.getOrDefault(part, 0)+1);
            }

            for(String comp : completion){
                //remove 혹은 replace를 쓰면 안되는 이유 -> 동명이인 두명이 한 큐에 다 날아가버림.
                myMap.put(comp, myMap.get(comp)-1);
            }

            for (String key : myMap.keySet()) {
                if (myMap.get(key) != 0) {
                    answer = key;
                    break;
                }
            }
            return answer;
        }
    }


}
