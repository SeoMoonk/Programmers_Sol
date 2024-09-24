package interview.string_processing_6;

import java.util.*;

public class Most_Common_Word_204 {

    public static void main(String[] args) {

        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit";
        String[] banned = {"hit"};

        String answer = mostCommonWord(paragraph, banned);

        System.out.println(answer);
    }


    /*
    금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라.
    대소문자를 구분하지 않으며, 구두점(마침표, 쉼표 등) 또한 무시한다.
     */
    static String mostCommonWord(String p, String[] banned) {

        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        // \W+ -> 연속적으로(+) 단어 문자(Word Character)가 아닌 것을 지정하는 정규식 -> 공백으로 치환(replaceAll)
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for (String w : words) {
            if (!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }

        //Map(Key-Value)에서 가장 큰 값을 찾는다. 기준은 값(Value)으로. 최종적으로 Key(단어)를 반환한다.
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
