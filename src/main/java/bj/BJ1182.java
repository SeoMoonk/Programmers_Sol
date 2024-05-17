package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i < 1 << arr.length; i++) {

            int temp = 0;

            for(int j=0; j<arr.length; j++) {
                
                //부분 집합 포함 여부 ★★★
                if ( ( i & ( 1 << j ) ) != 0) {
                    temp += arr[j];
                }
            }

            //이번 부분집합의 합이 S와 동일하다면, count를 증가시킨다.
            if(temp == S) {
                count++;
            }
        }

        //단, S가 0인 경우에는 count를 하나 제거한다. (빈 집합 제외)
        if(S == 0) {
            count--;
        }

        System.out.println(count);
    }
}
