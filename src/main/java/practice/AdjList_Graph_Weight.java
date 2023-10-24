package practice;

import java.io.*;
import java.util.*;

public class AdjList_Graph_Weight {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer token;

    static class Node {

        int nextNode;
        int weight;

        public Node(int nextNode, int weight) {
            this.nextNode = nextNode;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException{

        token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        ArrayList<Node>[] adjAcentList = new ArrayList[n+1];    //배열 + 리스트 조합

        //리스트는 일반 배열과 다르게 일일히 초기화 하는 코드가 필요하다.
        for (int i=0; i<n+1; i++) {
            adjAcentList[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {

            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());

            //양방향 그래프, weight 추가
            adjAcentList[start].add(new Node(end, weight));
            adjAcentList[end].add(new Node(start, weight));

        }

        for (int i = 0; i < n + 1; i++) {
            System.out.print(i + " ");

            for (Node node : adjAcentList[i]) {
                System.out.print("[" + node.nextNode + ", " + node.weight + "] ");
            }

            System.out.println();
        }
    }
}
