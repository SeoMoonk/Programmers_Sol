package interview.array;

import java.util.ArrayDeque;

public class Trapping_Rain_Water_42 {

    //높이를 입력받아 비 온 후 얼마나 많은 물이 쌓일 수 있는지 계산하라.
    public static void main(String[] args) {

        int[] height = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int answer = trap1(height);     //투 포인터 방식 풀이
        int answer2 = trap2(height);    //스택 방식 풀이

        System.out.println("answer = " + answer);
        System.out.println("answer2 = " + answer2);
    }

    public static int trap1(int[] height) {

        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        //투 포인터가 서로 겹칠 때까지 반복
        // -> 좌우 어느 쪽이든 낮은 쪽은 높은 쪽을 향해서 포인터가 가운데로 점점 이동한다.
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

    static int trap2(int[] height) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for(int i=0; i<height.length; i++) {
            //변곡점을 만나는 경우(더 큰 것을 만나는 경우)
            while(!stack.isEmpty() && height[i] > height[stack.getLast()]) {
                //스택에서 꺼낸다(pop)
                Integer top = stack.removeLast();

                if(stack.isEmpty())
                    break;

                //스택의 마지막 위치까지를 거리로 계산
                int distance = i - stack.getLast() - 1;
                //현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값에 방금 꺼낸 높이의 차이를 물 높이로 지정
                int waters = Math.min(height[i], height[stack.getLast()]) - height[top];
                //물이 쌓이는 양은 거리와 물 높이의 곱
                volume += distance * waters;
            }

            //진행하면서 현재 위치를 스택에 삽입
            stack.addLast(i);
        }

        return volume;
    }
}
