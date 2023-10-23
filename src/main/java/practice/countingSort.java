package practice;

import java.util.Arrays;

public class countingSort {

    static int[] nums = {4, 4, 2, 3, 5, 5, 1, 1, 5};
    static int[] count;
    static int[] sortedNums;

    public static void main(String[] args) {

        //배열의 값을 하나씩 다 읽으면서, 최대 값을 구하여 대입
        int maxNum = Arrays.stream(nums).max().getAsInt();

        //집계 배열의 크기는 최댓값으로
        count = new int[maxNum+1];

        //정렬 배열의 크기는 원본과 같도록
        sortedNums = new int[nums.length];

        //집계하기
        for(int num : nums) {
            count[num] += 1;
        }

        // 누적합 구하기
        // => 안정 정렬을 위해, 해당 값이 어디까지 들어갈 수 있는지 인덱스를 구하기 위함
        for(int i=1; i<maxNum+1; i++) {
            count[i] = count[i] + count[i-1];
        }

        //뒤에서부터 깎아서 정렬
        for(int j=nums.length-1; j > -1; j--) {
            sortedNums[count[nums[j]]-1] = nums[j];
            count[nums[j]] -= 1;
        }

        //1은 0번부터, 2는 2번부터, 3은 3번부터, 4는 4번부터, 5는 6번 인덱스 부터 들어갈 수 있다.
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(sortedNums));
    }

}
