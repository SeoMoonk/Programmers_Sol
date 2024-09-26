package interview.array;

public class Trapping_Rain_Water_42 {

    //높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
    public static void main(String[] args) {

        int[] height = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int answer = trap1(height);

        System.out.println("answer = " + answer);
    }

    public static int trap1(int[] height) {

        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        //투 포인터가 서로 겹칠 때까지 반복
        while(left < right) {

            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            //더 높은 쪽을 향해 투 포인터 이동
            if(leftMax <= rightMax) {
                //왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left++;
            } else {
                //오른쪽 막대 최대 높이와의 차이를 더하고 오른쪽 포인터 이동
                volume += rightMax - height[right];
                right--;
            }
        }
        return volume;
    }
}
