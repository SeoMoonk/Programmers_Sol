package interview.array;

import java.util.*;

public class Sum3_15 {

    //배열을 입력받아 합으로 0을 만들 수 있는 3개의 엘리먼트를 출력하라.
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -5};

        List<List<Integer>> answer1 = threeSum1(nums);
        List<List<Integer>> answer2 = threeSum2(nums);

        System.out.println(answer1.toString());
        System.out.println(answer2.toString());
    }

    static List<List<Integer>> threeSum1(int[] nums) {

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
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return results;
    }

    static List<List<Integer>> threeSum2(int[] nums) {

        int left, right, sum;

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            //중복된 값 건너뛰기
            if(i>0 && nums[i] == nums[i-1])
                continue;

            //간격을 좁혀가며 합 sum 계산
            left = i + 1;
            right = nums.length - 1;

            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if(sum < 0) {
                    //합이 0보다 작다면 왼쪽 포인터 이동
                    left++;
                }
                else if(sum > 0) {
                    //합이 0보다 크다면 오른쪽 포인터 이동
                    right--;
                } else {
                    //합이 0인 경우, 정답으로 처리
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 누 번 나올 수 있다.
                    while(left < right && nums[left] == nums[left + 1])
                        left++;
                    while(left < right && nums[right] == nums[right - 1])
                        right--;

                    //정답이 나왔으므로, 투 포인터 모두 한 칸씩 이동.
                    //합이 0인 상황이므로, 양쪽 모두 이동해야 한다.
                    left++;
                    right--;
                }
            }
        }
        return results;
    }
}
