package practice;

import java.util.Arrays;

public class Repetation_Permutation {

    //재귀 순열과 중복 순열의 차이점은, 가져갔는지 확인하는
    //check 과정만 뺴버리면 똑같다.

    static String[] arr = {"A", "B", "C"};
    static String[] sel = new String[3];

    static void perm(int depth) {
        if (depth == 3) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i = 0; i < 3; i++) {
            sel[depth] = arr[i];
            perm(depth + 1);
        }
    }

    public static void main(String[] args) {
        perm(0);
    }

}
