package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MethodSort {

    static int[] nums = {7, 3, 1, 4, 2};
    static Integer[] nums2 = {7, 3, 1, 4, 2};
    static String[] strNums = {"7", "5", "8", "2", "3"};
    static String[] strWords = {"car", "banana", "apple", "box"};

    static ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(3, 6, 1, 2, 4));
    static ArrayList<String> strList = new ArrayList<>(Arrays.asList("7", "14", "1", "3", "5"));
    static ArrayList<String> wordList = new ArrayList<>(Arrays.asList("cat", "apple", "dog", "apex", "cap"));

    static int[][] doubleNums = {{4, 4, 16}, {6, 1, 6}, {4, 3, 12}, {1, 12, 12}, {5, 4, 20}, {2, 3, 6}, {3, 4, 12}};

    public static void main(String[] args) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums2, Collections.reverseOrder());     // 반대 정렬을 원하면 Integer[]로 선언해야함.
        System.out.println(Arrays.toString(nums2));


        Arrays.sort(strNums);
        System.out.println(Arrays.toString(strNums));

        Arrays.sort(strNums, Collections.reverseOrder());
        System.out.println(Arrays.toString(strNums));


        Arrays.sort(strWords);
        System.out.println(Arrays.toString(strWords));

        Arrays.sort(strWords, Collections.reverseOrder());
        System.out.println(Arrays.toString(strWords));

        numList.sort(Comparator.naturalOrder());
        System.out.println(numList);

        strList.sort(Comparator.naturalOrder());
        System.out.println(strList);

        wordList.sort(Comparator.naturalOrder());
        System.out.println(wordList);

        Arrays.sort(doubleNums, ((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));
        System.out.println(Arrays.deepToString(doubleNums));

    }

}
