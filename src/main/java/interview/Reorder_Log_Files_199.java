package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reorder_Log_Files_199 {


    public static void main(String[] args) {

        String[] logs = {"id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero"};

        String[] answer = reorderLogFiles(logs);

        System.out.println(Arrays.toString(answer));
    }

    /*
        로그를 재정렬하라. 기준은 다음과 같다.
        1. 로그의 가장 앞 부분은 식별자로서, 순서에 영향을 끼치지 않는다.
        2. 문자로 구성된 로그가 숫자 로그보다 앞에 오며, 문자 로그는 사전순으로 한다.
        3. 문자가 동일할 경우에는 식별자순으로 한다.
        4. 숫자 로그는 입력 순서대로 한다.
    */

    static String[] reorderLogFiles(String[] logs) {

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {

            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);

            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
}