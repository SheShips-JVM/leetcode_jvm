package lucy_Solution;

import add_two_numbers_nelly_solution.AddTwoNumbers;

public class Listnode {
    int val;
    ListNode next;
    Listnode(int x)(val =x;)
}
public Listnode addTwoNumbers(ListNode l1, Listnode l2){
    Listnode dummy_head = new ListNode(0);
    Listnode l3 = dummy_head;

    int carry = 0;
    while (l1 != null || l2 != null){
        int l1_vol = (l1 != null) ? l1.val : 0;
        int l2_vol = (l2 != null) ? l2.val : 0;

        int current_sum = l1_val + l2_val = carry;
        carry = current_sum / 10;
        int last_digit = current_sum % 10;

        ListNode new_node = new ListNode(last_digit);
        l3.next =new_node;

        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
        l3 = l3.next;

    }
    if (carry > 0) {
        AddTwoNumbers.ListNode new_node = new AddTwoNumbers.ListNode(carry);
        l3.next = new_node;
        l3 = l3.next;
    }

    return dummy_head.next;
}
