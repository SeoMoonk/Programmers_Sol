package practice;

import java.util.Arrays;

public class CountingSort {

    static int[] nums = {4, 4, 2, 3, 5, 5, 1, 1, 5};
    static int[] count;             //갯수 집계 배열
    static int[] sortedNums;        //정렬된 배열

    public static void main(String[] args) {
        
        int maxNum = Arrays.stream(nums).max().getAsInt();      // 최대 값 구하기
        count = new int[maxNum+1];      //0이 빠지므로 1 더 크게
        sortedNums = new int[nums.length];
        
        //1. 집계하기 => 몇 개가 있어야 하는지 카운트 (단순 정렬은 이미 완료됨.)
        for(int num : nums) {
            count[num] += 1;
        }

        //2. 누적합 구하기 => 몇 개가 있는 지에 추가적으로, 몇 번 인덱스까지 작성되어야 하는지를 저장 
        // 1번의 결과가 [0, 2, 1, 1, 2, 3] => 11 2 3 44 555 라는 의미였다면
        // 2번의 결과인 [0, 2, 3, 4, 6, 9] => 1은 0~1에, 2는 2에, 3은 3에, 4는 4~5에, 5는 6~8에 있어야 함을 의미
        for(int i=1; i<maxNum+1; i++) {
            count[i] = count[i] + count[i-1];
        }

        // 위와 같은 결과를 "원본 배열의 뒤에서 부터 깎아서 넣음"
        for(int j = nums.length-1; j > -1; j--) {
            sortedNums[count[nums[j]]-1] = nums[j];     //5가 튀어나오면 5의 위치에 뒤부터 삽입
            count[nums[j]] -=1;                         //위치 인덱스 하나 깎음
        }
    }

}
