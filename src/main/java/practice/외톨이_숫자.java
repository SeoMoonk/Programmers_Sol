package practice;

public class 외톨이_숫자 {

    static int[] nums = {1, 2, 3, 2, 1};
    static int[] nums2 = {33, 25, 5, 2, 4, 25, 77, 2, 33, 4, 5};

    public static void main(String[] args) {

        int answer = 0;
        int answer2 = 0;

        for(int num : nums) {
            answer ^= num;
        }

        for(int num : nums2) {
            answer2 ^= num;
        }

        System.out.println(answer);
        System.out.println(answer2);
    }

}
