package interview.string_processing_6;

import java.util.*;

public class Group_Anagrams_208 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "ant", "cat"};

        List<List<String>> answer = groupAnagrams(strs);

        System.out.println(answer.toString());
    }

    static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> results = new HashMap<>();

        for(String s : strs) {

            //문자열을 문자 배열로 변환
            char[] chars = s.toCharArray();

            //문자 배열 정렬
            Arrays.sort(chars);

            //문자 배열을 키로 하기 위해 다시 문자열로 변환
            String key = String.valueOf(chars);

            //만약 기존에 없던 키라면 빈 리스트를 삽입
            if(!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }

            //키에 해당하는 리스트에 추가
            results.get(key).add(s);
        }

        //문제에서 요구하는 출력값 형태로 변경
        return new ArrayList<>(results.values());
    }
}
