package interview.linkedlist;

import java.util.ArrayDeque;

public class Palindrome_Linked_List_234 {

    static boolean isPalindrome_v1(ListNode head) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        ListNode node = head;

        while(node != null) {
            stack.addLast(node.val);
            node = node.next;
        }

        while(!stack.isEmpty()) {

            if(head.val != stack.peekLast()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public class ListNode {

        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
