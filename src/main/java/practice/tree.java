package practice;

public class tree {

    static int left[] = {2, -1, -1, 5, -1, 1, -1};
    static int right[] = {4, -1, -1, 0, -1, 6, -1};
    static final int ROOT = 3;

    static public void preorder(int current) {

        if(current == -1) {
            return;
        }

        System.out.print(current + " ");
        preorder(left[current]);
        preorder(right[current]);
    }

    static public void inorder(int current) {

        if(current == -1) {
            return;
        }

        inorder(left[current]);
        System.out.print(current + " ");
        inorder(right[current]);
    }

    static public void postorder(int current) {

        if(current == -1) {
            return;
        }

        postorder(left[current]);
        postorder(right[current]);
        System.out.print(current + " ");

    }

    public static void main(String[] args) {

        preorder(ROOT);
        System.out.println("- preorder");
        inorder(ROOT);
        System.out.println("- inorder");
        postorder(ROOT);
        System.out.println("- postorder");

    }


}
