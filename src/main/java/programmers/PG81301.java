package programmers;

import java.util.*;

public class PG81301 {

    public static void main(String[] args) {

        Solution sol = new Solution();

//        String input1 = "one4oneseveneight";
        String input2 = "23four5six7";
        String input3 = "2three45sixseven";
        String input4 = "123";

//        int solution = sol.solution(input1);
        int solution1 = sol.solution2(input2);
        int solution2 = sol.solution2(input3);
        int solution3 = sol.solution2(input4);

//        System.out.println("solution = " + solution);
        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);

    }

    //네오와 프로도가 숫자놀이를 하고 있습니다.
    // 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면
    // 프로도는 원래 숫자를 찾는 게임입니다.
    public static class Solution {
        public int solution(String s) {

            StringBuilder sb = new StringBuilder();

            Map<String, String> engToNumMap = new HashMap<>();

            engToNumMap.put("zero", "0");
            engToNumMap.put("one", "1");
            engToNumMap.put("two", "2");
            engToNumMap.put("three", "3");
            engToNumMap.put("four", "4");
            engToNumMap.put("five", "5");
            engToNumMap.put("six", "6");
            engToNumMap.put("seven", "7");
            engToNumMap.put("eight", "8");
            engToNumMap.put("nine", "9");

            String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            // "무언가를" 찾았다. "어디에서"
            ArrayList<Integer> indexArr = new ArrayList<>();
            ArrayList<String> stringArr = new ArrayList<>();

            //문자열을 쭉 읽으면서, 각 문자들 혹은 숫자가 몇번째 인덱스에 있는지 확인한다.
            //이 때 중요한 점은 문자와 숫자를 동시에 탐색한다는 것이다.
            //어짜피 for문은 0~9까지 무조건 돌아간다.
            for (int i = 0; i < strArr.length; i++) {

                //영어로된 숫자를 찾았을 경우
                if (s.contains(strArr[i])) {
                    indexArr.add(s.indexOf(strArr[i]));
                    stringArr.add(strArr[i]);
                }

                if (s.contains(String.valueOf(i))) {
                    indexArr.add(s.indexOf(String.valueOf(i)));
                    stringArr.add(String.valueOf(i));
                }

            }

            for (int i = 0; i < stringArr.size(); i++) {

                if (engToNumMap.get(stringArr.get(i)) != null) {
                    sb.append(engToNumMap.get(stringArr.get(i)));
                } else {
                    sb.append(stringArr.get(i));
                }

            }

            int answer = Integer.parseInt(sb.toString());

            return answer;
        }

        public int solution2(String s) {

            //영단어를 담는 String 타입의 배열 생성
            //영단어와 배열의 인덱스값이 동일하다.
            String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            //반복문을 사용해 배열 안의 모든 영단어를 검사한다.
            //문자열 s에 영단어가 있다면 replace를 사용해 변환한다.
            for (int i = 0; i < arr.length; i++) {
                if (s.contains(arr[i])) {
                    s = s.replace(arr[i], Integer.toString(i));
                }
            }
            return Integer.parseInt(s);
        }
    }
}


