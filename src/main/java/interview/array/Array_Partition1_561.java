package interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Array_Partition1_561 {

    //n개의 페어를 이용한 min(a, b)의 합으로 만들 수 있는 가장 큰 수를 출력하라.

    static List<Integer> numList = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2};

        Arrays.sort(nums);

        for(int num : nums) {

            numList.add(num);

            if(numList.size() == 2) {
                sum += Collections.min(numList);
                numList.clear();
            }
        }

        System.out.println(sum);
    }
}
