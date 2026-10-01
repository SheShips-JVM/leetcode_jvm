// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 1. Interleave: Insert cloned nodes directly after original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. Connect random pointers: A'.random = A.random.next
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Unweave: Separate original list and cloned list
        curr = head;
        Node dummyHead = new Node(0);
        Node copyCurr = dummyHead;

        while (curr != null) {
            Node copy = curr.next;

            // Restore original list link
            curr.next = copy.next;

            // Build cloned list link
            copyCurr.next = copy;
            copyCurr = copy;

            // Advance to next original node
            curr = curr.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        // Create sample list: Node(7) -> Node(13) -> Node(11)
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);

        n1.next = n2;
        n2.next = n3;

        // Set random pointers
        n1.random = null;
        n2.random = n1; // Node 13 points to Node 7
        n3.random = n3; // Node 11 points to itself

        Solution solution = new Solution();
        Node clonedHead = solution.copyRandomList(n1);

        // This one prints and verifies the cloned linked list
        Node curr = clonedHead;
        System.out.println("Cloned List Result");
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node Val: " + curr.val + " | Random Target Val: " + (randomVal == -1 ? "null" : randomVal));
            curr = curr.next;
        }
    }
}