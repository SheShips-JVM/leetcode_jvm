# Solution Design Document

## Problem

**LeetCode #2 – Add Two Numbers**

Given two non-empty linked lists representing two non-negative integers, where the digits are stored in reverse order, return their sum as a linked list in the same reversed format.

### Example

**Input**

```text
l1 = [2,4,3]
l2 = [5,6,4]
```

The lists represent the numbers:

```text
342
465
```

Their sum is:

```text
807
```

Therefore, the output is:

```text
[7,0,8]
```

---

## Approach

The solution traverses both linked lists simultaneously while performing digit-by-digit addition, similar to the manual addition process taught in arithmetic.

A `carry` variable is maintained to store any value carried over when the sum of two digits exceeds 9.

Since the linked lists may have different lengths, if one list reaches the end before the other, its value is treated as `0`.

A dummy head node is used to simplify construction of the resulting linked list. New nodes containing each computed digit are appended to the result list until both input lists have been completely traversed and there is no remaining carry.

Finally, the method returns the node following the dummy head, which represents the actual result.

---

## Algorithm

1. Create a dummy head node for the result list.
2. Initialize a pointer (`current`) to the dummy node.
3. Initialize `carry` to `0`.
4. While either linked list still contains nodes or a carry exists:
    - Read the current value from each list (or `0` if the list has ended).
    - Compute the sum of both values and the carry.
    - Update the carry using integer division (`sum / 10`).
    - Create a new node containing `sum % 10`.
    - Append the new node to the result list.
    - Move to the next nodes in both input lists.
5. Return `dummy.next`.

---

## Correctness

The algorithm processes one digit from each linked list during every iteration.

At each step:

- The correct digit is calculated using `(digit1 + digit2 + carry) % 10`.
- The carry is updated using integer division (`sum / 10`).
- The resulting digit is appended to the output list.

Since every digit is processed exactly once and any remaining carry is added after both lists end, the resulting linked list correctly represents the sum of the two integers.

---

## Time Complexity

**O(n)**

where **n** is the length of the longer linked list.

Each node is visited exactly once.

---

## Space Complexity

**O(n)**

A new linked list is created to store the result, containing at most one more node than the longer input list.

---

## Key Concepts Used

- Singly Linked Lists
- Pointer Traversal
- Dummy Head Node
- Carry Propagation
- Modulo (`%`) and Integer Division (`/`)
- Iterative Algorithm

---

## Lessons Learned

This problem demonstrates how linked lists can represent numbers and how arithmetic operations can be performed without converting the lists into integers.

Using a dummy head node greatly simplifies linked list construction by eliminating special cases for the first node.

The solution also reinforces the importance of handling different list lengths and managing carry values correctly during iterative processing.