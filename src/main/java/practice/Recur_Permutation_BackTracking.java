package practice;

import java.util.Arrays;

public class Recur_Permutation_BackTracking {

    static String[] arr = {"A", "B", "C"};
    static String[] sel = new String[3];
    static int[] check = new int[3];

    static void perm(int depth) {

        if(depth == 3) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        for (int i=0; i<3; i++) {
            if(check[i] == 0) {
                check[i] = 1;
                sel[depth] = arr[i];
                perm(depth + 1);
                check[i] = 0;
            }
        }
    }


    public static void main(String[] args) {
        perm(0);
    }


}
