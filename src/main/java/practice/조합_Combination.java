package practice;

import java.util.Arrays;

public class 조합_Combination {
    
    static String[] arr = {"A", "B", "C", "D", "E"};
    static String[] sel;
    static int length;

    public static void main(String[] args) {

        length = arr.length;
        sel = new String[length];

        //1. 조합 반복문
        forCombination();

        System.out.println("---".repeat(10));
        
        //2. 중복 조합 반복문
        repetitionCombination(0, 0);
    }
    
    static void forCombination() {

        for(int i=0; i<length; i++) {
            for(int j=i+1; j<length; j++) {
                System.out.println("%s %s".formatted(arr[i], arr[j]));
            }
        }
    }
    
    static void repetitionCombination(int idx, int sidx) {

        if(sidx == 3) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        if(idx == 5) {
            return;
        }

        sel[sidx] = arr[idx];
        repetitionCombination(idx, sidx+1);
        repetitionCombination(idx+1, sidx);
    }
    
}
