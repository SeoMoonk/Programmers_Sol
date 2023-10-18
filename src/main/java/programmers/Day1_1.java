package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day1_1 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String data1 = "people";
        String data2 = "We are the world";

        String solution1 = sol.solution(data1);
        String solution2 = sol.solution(data2);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }

    // 문자열 my_string이 매개변수로 주어집니다.
    // my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
    public static class Solution {
        public String solution(String my_string) {

            ArrayList<Character> charList = new ArrayList<>();
            StringBuilder answerBuilder = new StringBuilder();

            for(int i=0; i<my_string.length(); i++) {

                char c = my_string.charAt(i);
                
                if(!charList.contains(c)){
                    charList.add(c);
                    answerBuilder.append(c);
                }
            }

            String answer = answerBuilder.toString();
            return answer;
        }
    }

}
