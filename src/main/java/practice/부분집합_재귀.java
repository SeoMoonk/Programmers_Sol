package practice;

import java.util.ArrayList;

public class 부분집합_재귀 {

    static String[] arr = {"A", "B", "C"};
    static int[] check;
    static int length;

    public static void main(String[] args) {

        length = arr.length;
        check = new int[length];

        powerset(0);
    }

    static void powerset(int idx) {

        if(idx == length) {
            ArrayList<String> result = new ArrayList<>();

            for(int i=0; i<length; i++) {
                if(check[i] == 1) {
                    result.add(arr[i]);
                }
            }

            if(result.size() != 0) {
                System.out.println(result);
            }

            return;
        }

        //본인을 포함할 때, 포함하지 않을때를 각각 powerset을 돌려 모두 끝까지 재귀 순회
        check[idx] = 0;
        powerset(idx+1);

        check[idx] = 1;
        powerset(idx+1);

    }
}
