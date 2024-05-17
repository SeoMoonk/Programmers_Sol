package practice;

import java.util.Arrays;

public class 순열 {

    static String[] arr = {"A", "B", "C"};
    static String[] sel;
    static int[] check;
    static int length;


    public static void main(String[] args) {

        length = arr.length;
        sel = new String[length];
        check = new int[length];

        //순열을 만드는 3가지 방법

        //1. for문 순열
        forPermutation();
        System.out.println("---".repeat(10));

        //2. 재귀 순열
        recurPermutation(0);
        System.out.println("---".repeat(10));

        //3. 중복 순열
        repetitionPermutation(0);

    }

    //방법 1. for문 순열
    static void forPermutation() {

        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++) {
                for(int k=0; k<length; k++) {
                    //i, j, k의 인덱스가 모두 다를때만 출력하도록
                    if(i!=j && j!=k && k!=i) {
                        System.out.println("%s %s %s".formatted(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
    }

    //방법 2. 재귀 순열
    static void recurPermutation(int depth) {

        //자리가 다 찼으면 출력하고 return
        if(depth == length) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        for(int i=0; i<length; i++) {

            //비어있는 공간이라면.
            if(check[i] == 0) {
                check[i] = 1;                       //사용한다고 기록하고
                sel[depth] = arr[i];                //현재 i가 가리키고 있는 문자를 select 에 집어넣은 뒤
                recurPermutation(depth + 1); //다음 재귀로 이동함.
                check[i] = 0;                      //빠져나오면서, 다음 재귀를 위해 선택 내역을 초기화를 시켜줌
            }
        }
    }

    //방법 3. 중복 순열
    static void repetitionPermutation(int depth) {

        if(depth == length) {
            System.out.println(Arrays.toString(sel));
            return;
        }

        //재귀 순열에서, 중복을 허용하기 때문에 check[] 를 사용하지 않고 순회함.
        for(int i=0; i<3; i++) {
            sel[depth] = arr[i];
            repetitionPermutation(depth + 1);
        }
    }
}
