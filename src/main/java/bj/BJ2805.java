package bj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ2805 {


    public static void main(String[] args) {

        Node node = new Node(1);


    }

    public static class Node {

        int no;
        ArrayList<Integer> endPointList;
        int edgeValue;

        public Node(int no, ArrayList<Integer> endPointList) {
            this.no = no;
            this.endPointList = endPointList;
        }

        public Node(int no) {
            this.no = no;
            this.endPointList = null;
        }
    }

}
