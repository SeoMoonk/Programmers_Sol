package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> preorder = new ArrayList<>();

    static void traverse(int L, int R) {
        if (L > R) {
            return;
        }

        int mid = R + 1;
        for (int i = L+1; i < R+1; i++) {
            if (preorder.get(L) < preorder.get(i)) {
                mid = i;
                break;
            }
        }

        traverse(L+1, mid-1);
        traverse(mid, R);
        System.out.println(preorder.get(L));

    }

    public static void main(String[] args) throws IOException {
        while (true) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            preorder.add(Integer.parseInt(input));
        }

        traverse(0, preorder.size()-1);
    }
}
