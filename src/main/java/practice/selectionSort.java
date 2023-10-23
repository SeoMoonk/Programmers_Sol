package practice;

import java.util.Arrays;

public class selectionSort {

    static int[] nums = {10, 15, 2, 19, 6, 14};

    static void swap(int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {

        // 맨 앞 인덱스부터 순회하면서, 해당 인덱스의 뒷 부분들을 비교하며
        // 가장 작은 값을 대입함으로써 배열을 완성시키는 방법.
        for(int i=0; i<nums.length-1; i++) {
            int minIdx = i;

            for(int j=i+1; j<nums.length; j++) {

                if(nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }

        System.out.println(Arrays.toString(nums));
    }

}
