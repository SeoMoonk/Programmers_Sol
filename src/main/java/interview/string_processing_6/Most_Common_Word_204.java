package interview.string_processing_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Most_Common_Word_204 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit";
        String[] banned = {"hit"};

        String answer = mostCommonWord(paragraph, banned);

        System.out.println(answer);
    }

    static String mostCommonWord(String p, String[] banned) {

        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for(String w : words) {
            if(!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) +1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /*
    금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라.
    대소문자를 구분하지 않으며, 구두점(마침표, 쉼표 등) 또한 무시한다.
     */

}
