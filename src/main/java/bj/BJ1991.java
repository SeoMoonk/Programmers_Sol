package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1991 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final String ROOT_NODE = "A";
    static final String NOT_NODE = ".";
    static final int LEFT = 0;
    static final int RIGHT = 1;

    static StringBuilder sb = new StringBuilder();
    static int N;
    static Map<String, String[]> tree = new HashMap<>();


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String[] childNodes = {st.nextToken(), st.nextToken()};

            tree.put(parent, childNodes);
        }

        preorder(ROOT_NODE);
        sb.append("\n");
        inorder(ROOT_NODE);
        sb.append("\n");
        postorder(ROOT_NODE);

        System.out.println(sb.toString());
    }

    static void preorder(String current) {

        if(current.equals(NOT_NODE)) {
            return;
        }

        sb.append(current);
        preorder(tree.get(current)[LEFT]);
        preorder(tree.get(current)[RIGHT]);
    }

    static void inorder(String current) {

        if(current.equals(NOT_NODE)) {
            return;
        }

        inorder(tree.get(current)[LEFT]);
        sb.append(current);
        inorder(tree.get(current)[RIGHT]);
    }

    static void postorder(String current) {

        if(current.equals(NOT_NODE)) {
            return;
        }

        postorder(tree.get(current)[LEFT]);
        postorder(tree.get(current)[RIGHT]);
        sb.append(current);
    }
}
