Add Two Numbers (Linked List)
What the problem is asking

You get two numbers, but instead of normal numbers like 342, they're stored as linked lists where each node is just one digit, and the digits are backwards.

So 342 looks like: 2 -> 4 -> 3 And 465 looks like: 5 -> 6 -> 4

We need to add 342 + 465 = 807, and give the answer back in the same backwards format: 7 -> 0 -> 8

How I thought about it

I just thought about how I add numbers by hand on paper — starting from the rightmost digit and moving left, carrying over 1 when a column adds up to more than 9.

Since the lists are already stored backwards (smallest digit first), I don't even need to reverse anything — I can just walk through both lists from the start and add digit by digit, exactly like doing addition by hand.

My steps
Start with an empty "dummy" node. This is just a trick so I always have something to point .next to when I add the very first digit. I throw this dummy node away at the end.
Loop through both lists at the same time. Some numbers are longer than others, so I keep looping as long as either list still has digits left. If one list runs out early, I just treat its digit as 0.
Add the two digits + whatever carry is left over from last time.
sum = digit1 + digit2 + carry
Figure out the new digit and the new carry.
The digit I actually keep is sum % 10 (the ones place)
The new carry is sum / 10 (will be 0 or 1)
Make a new node with that digit and attach it to my result list.
Move both pointers forward (l1 = l1.next, l2 = l2.next) so next loop I look at the next digits.
After the loop ends, if there's still a carry left (like 5 + 5 = 10, carry = 1), I add one more node for it.
Return the result, skipping that dummy node I started with.