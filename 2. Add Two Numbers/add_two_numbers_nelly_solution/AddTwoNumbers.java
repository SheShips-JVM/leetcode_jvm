package add_two_numbers_nelly_solution;

import java.util.Scanner;
import java.lang.Math.*;
import java.util.LinkedList;

class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the first linked list:");
        int l1size = sc.nextInt();
        int[] l1 = new int[l1size];
        ListNode a1 = new ListNode(0);
        ListNode current1 = a1;
        for (int i=0; i< l1size; i++) {
            System.out.println("l1[" + i + "]");
            int input =  sc.nextInt();
            l1[(l1size-i) - 1] = input;

            current1.next = new ListNode(input);
            current1 = current1.next;
        }


        System.out.println("Enter the size of the second linked list:");
        int l2size = sc.nextInt();
        int[] l2 = new int[l2size];
        ListNode a2 = new ListNode(0);
        ListNode current2 = a2;
        for (int i=0; i< l2size; i++) {
            System.out.println("l2[" + i + "]");
            int input =  sc.nextInt();
            l2[(l2size-i) - 1] = input;

            current2.next = new ListNode(input);
            current2 = current2.next;
        }

        soln1(l1, l2);

        //dummys
        ListNode t1 = a1.next;
        ListNode t2 =a2.next ; //new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = addTwoNumbers(t1, t2);
        printList(result);

    }

    static void printList(ListNode head) {
        System.out.println("Printing List Nodes");
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }

    /**
     * Time = O(max(m,n))
     * Space = O(m+n)
     * where
     * m = length of first list
     * n = length of second list
     *
     * @param l1
     * @param l2
     */
    static  void soln1 (int[] l1, int[] l2) {

        //find larger
        int measure = Math.max(l1.length, l2.length);
        int[] sums = new int[measure + 1];
        int carry = 0;

        for (int i = 0; i < measure; i++) {
            int num1 = (i < l1.length) ? l1[i] : 0;
            int num2 = (i < l2.length) ? l2[i] : 0;

            int total = num1 + num2 + carry;
            int digit = total % 10;
            carry = total /10;
            sums[i] = digit;
            System.out.println("digit for sum of ["+num1+","+num2+"] is "+ digit +" for index "+ i + " carry "+ carry);
        }

        if (carry > 0) {
            System.out.println("Digit: " + carry);
        }
    }


    // 1. Definition for singly-linked list (Exactly how LeetCode defines it)
    //
    //eg if we have a list 2 -> 4 -> 3 -> null

    /**
     * Definition for singly-linked list (Exactly how LeetCode defines it)
     * Means  every node stores  a digit and pointer tto the next node
     *
     * eg if we have a list 2 -> 4 -> 3 -> null it actually is
     * +---------+      +---------+      +---------+
     * | val = 2 | ---> | val = 4 | ---> | val = 3 | ---> null
     * | next ---|      | next ---|      | next ---|
     * +---------+      +---------+      +---------+
     *
     * so the l1 will be
     *      l1
     *      |
     *      ▼
     *    *----*
     *    | 2  |
     *    *----*
     *    l1 is not actually the number 2, it is a reference (pointer) to the first node
     *
     * LinkedList doesnt have indexes, instead it moves node by node
     *       l1
     *        ↓
     *        2 -> 4 -> 3
     *
     *    after one step
     *
     *       l1
     *        ↓
     *   2 -> 4 -> 3
     *
     *   after another
     *
     *            l1
     *             ↓
     *   2 -> 4 -> 3
     *
     *   to move you use l1 = l1.next
     *
     *  The dummy is the initial node with 0, its like an anchor
     *                dummy
     *                  ↓
     *                +---+
     *                | 0 |
     *                +---+
     *
     *  FIRST ITERATION
     *  suppose:
     *    l1
     *    2 -> 4 -> 3
     *   l2
     *    5 -> 6 -> 4
     *
     *    For first iteration
     *      carry = 0
     *      compute = 3 + 4 +0 = 7
     *      creates = new ListNode(7)
     *      dummy will be
     *             dummy
     *               ↓
     *               0 ---> 7
     *                      ▲
     *                      │
     *                      current
     *       dummy never moves only current moves
     *    Second iteration
     *      carry = 0
     *      compute = 4 + 6 + 0 = 10, gives digit 0 and carry 1
     *      so current will be
     *                dummy
     *                  ↓
     *                  0 ---> 7  ---> 0
     *                                 ▲
     *                                 │
     *                                 current
     *    Third iteration & last
     *      carry = 1
     *      compute = 2 + 5 + 1 = 8
     *      so current will be
     *                dummy
     *                  ↓
     *                  0 ---> 7  ---> 0  ---> 8
     *                                         ▲
     *                                         │
     *                                         current
     *    loop ends
     *    the list is now 0 -> 7 -> 0 -> 8
     *    but the first 0 is fake hence return dummy.next;
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Time = O(max(m, n)
     * Space = 0(1)
     *
     * where
     * m = length of first list
     * n = length of second list
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while ((l1 != null) || (l2 != null) || (carry != 0) ) {
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;

            int sum =  x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;
    }


    /**
     * comparing the two solutions
     * | Array Solution         | Linked List Solution            |
     * | ---------------------- | ------------------------------- |
     * | Move using `i`         | Move using `node = node.next`   |
     * | Store digits in arrays | Read digits directly from nodes |
     * | Need array allocation  | No extra data structure         |
     * | Access with `l1[i]`    | Access with `l1.val`            |
     * | Increment `i++`        | Advance `l1 = l1.next`          |
     * | Return array           | Return head of linked list      |
     */
}