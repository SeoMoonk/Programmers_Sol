package programmers;

import java.io.*;
import java.util.*;

//피로도
public class PG87946 {

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};

        Solution sol = new Solution();

        int solution = sol.solution(k, dungeons);
        System.out.println("solution = " + solution);
    }

    static class Solution {

        static int[][] dungeonArr;
        static int[] check;
        static int answer = -1;

        public int solution(int k, int[][] dungeons) {

            dungeonArr = dungeons;
            check = new int[dungeons.length];

            perm(0, k);

            return answer;
        }

        public void perm(int depth, int k) {

            if (answer < depth) {
                answer = depth;
            }

            if(depth == dungeonArr.length) {
                return;
            }

            for(int i=0; i< dungeonArr.length; i++) {

                if(check[i] == 0) {
                    check[i] = 1;

                    if(k >= dungeonArr[i][0]) {
                        perm(depth+1, k - dungeonArr[i][1]);
                    }

                    check[i] = 0;
                }
            }
        }
    }
}
