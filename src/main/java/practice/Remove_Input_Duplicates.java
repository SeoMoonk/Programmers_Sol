package practice;

import java.util.Arrays;
import java.util.HashSet;

public class Remove_Input_Duplicates {

    //String input의 중복을 제거하는 방법
    public static void main(String[] args) {

        String[] arr = {"hi", "hello", "hi", "hello", "alex"};

        //HashSet으로 만듦으로써 중복이 제거됨.
        HashSet<String> a = new HashSet<>(Arrays.asList(arr));
        System.out.println("a = " + a);

        //HashSet을 다시 Array로 만들어줌. (중요한 것 : .toArray(new String[0]);
        String[] exclusive = a.toArray(new String[0]);
        System.out.println("exclusive = " + Arrays.deepToString(exclusive));

    }

}
