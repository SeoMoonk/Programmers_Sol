package interview.string_processing_6;

import java.io.IOException;
import java.util.Arrays;

public class Reverse_String_196 {

    public static void main(String[] args) throws IOException {

        char[] str = {'r', 'a', 'c', 'e', 'c', 'a', 'R'};

        char[] reverse = reverse(str);

        System.out.println(Arrays.toString(reverse));
    }

    static char[] reverse(char[] s) {

        int start = 0;
        int end = s.length-1;

        while(start < end) {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        return s;
    }
}
