package practice;

import java.util.Arrays;

public class BubbleSort {

    static int[][] nums = {{4, 4, 16}, {6, 1, 6}, {4, 3, 12}, {1, 12, 12}, {5, 4, 20}, {2, 3, 6}, {3, 4, 12}};

    static void swap(int x, int y) {
        int[] temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    static void BubbleSort(int idx) {
        for (int i = nums.length-1; i > 0; i--) { // 3회 시행
            for (int j = 0; j < i; j++) {
                if (nums[j][idx] > nums[j+1][idx]) {
                    swap(j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {

        //뒤에서부터 버블 정렬
        BubbleSort(2);
        System.out.println(Arrays.deepToString(nums));

        BubbleSort(1);
        System.out.println(Arrays.deepToString(nums));

        BubbleSort(0);
        System.out.println(Arrays.deepToString(nums));
    }

}
