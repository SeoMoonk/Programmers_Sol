package interview.array;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_225 {

    public static void main(String[] args) throws IOException {

        int[] nums = {2, 6, 11, 15};
        int target = 8;

        int[] answer1 = sum1(nums, target);
        int[] answer2 = sum2(nums, target);
        int[] answer3 = sum3(nums,target);
        int[] answer4 = sum4(nums, target);

        System.out.println("answer1 = " + Arrays.toString(answer1));
        System.out.println("answer2 = " + Arrays.toString(answer2));
        System.out.println("answer3 = " + Arrays.toString(answer3));
        System.out.println("answer4 = " + Arrays.toString(answer4));
    }

    //덧셈하여 타겟을 만들 수 있는 배열의 두 숫자 인덱스를 리턴하라.
    //1. 부르트 포스로 계산
    static int[] sum1(int[] nums, int target) {

        for(int i=0; i<nums.length; i++) {

            int standard = nums[i];

            for(int j=i+1; j<nums.length; j++) {
                int sum = standard + nums[j];

                if(sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //2. 첫 번재 수를 뺀 결과 키 조회
    static int[] sum2(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            if(numsMap.containsKey(target - nums[i]) && i != numsMap.get(target - nums[i])) {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }

        return null;
    }

    //3. 조회 구조 개선
    static int[] sum3(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }

        return null;
    }

    //4. 투 포인터 이용
    static int[] sum4(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left != right) {
            if(nums[left] + nums[right] < target) {
                left += 1;
            } else if(nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }

        return null;
    }
}
