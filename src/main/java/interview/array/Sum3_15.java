package interview.array;

import java.util.*;

public class Sum3_15 {

    //배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라.

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -5};
    }

    static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            //중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 값이 두 번 나올 수 있다.
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                //중복된 값 건너뛰기
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                for (int k = j + 1; k < nums.length; k++) {
                    //중복된 값 건너뛰기
                    if (k > j + 1 && nums[k] == nums[k - 1])
                        continue;
                    if (nums[i] + nums[j] + nums[k] == 0)
                        results.add(Arrays.asList(nums[i], nums[j], nums[j]));
                }
            }
        }
        return results;
    }

}
