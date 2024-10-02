package interview.array;

import java.util.Arrays;

public class Product_of_Array_Except_Self_238 {

    //배열을 입력받아 output[i]가 자신을 제외한 나머지 모든 엘리먼트의 곱셈 결과가 되도록 출력하라.

    public static void main(String[] args) {

        int[] nums = new int[]{1, 3, 5, 7};
        int[] answer = productExceptSelf(nums);

        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        //왼쪽 곱셈
        int p = 1;
        for(int i=0; i<nums.length; i++) {
            result[i] = p;
            //왼쪽 곱셈 결과
            p *= nums[i];
        }

        //오른쪽 곱셈, 왼쪽 곱셈 결과에 차례대로 곱하기
        p = 1;
        for(int i=nums.length -1; i>=0; i--) {
            result[i] *= p;
            //오른쪽 곱셈 결과
            p *= nums[i];
        }

        return result;
    }
}
