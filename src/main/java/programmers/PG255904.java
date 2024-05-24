package programmers;

import java.util.Arrays;

public class PG255904 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int d = 0;

    static int x = 0;
    static int y = 0;

    public static int[] solution(String command) {

        char[] commands = command.toCharArray();

        for(char input : commands) {

            if(input == 'R') {
                d++;
                d = d % 4;
            } else if(input == 'L') {
                d--;
                if(d < 0) {
                    d = d+4;
                }
            } else if(input == 'G') {
                x = x + dx[d];
                y = y + dy[d];
            } else if(input == 'B') {
                x = x - dx[d];
                y = y - dy[d];
            }
        }

        int[] answer = {x, y};

        return answer;
    }

    public static void main(String[] args) {

        String command = "GRGLGRG";
        int[] answer = solution(command);

        System.out.println(Arrays.toString(answer));
    }
}
