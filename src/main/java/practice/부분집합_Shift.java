package practice;

import java.util.ArrayList;

public class 부분집합_Shift {

    static String[] letters = {"a", "b", "c", "d"};

    public static void main(String[] args) {

        for(int i=0; i < 1 << letters.length; i++) {

            ArrayList<String> selected = new ArrayList<>();

            for(int j=0; j < letters.length; j++) {

                if( (i & (1 << j)) != 0 ) {
                    selected.add(letters[j]);
                }

            }

            System.out.println(selected);
        }

    }

}
