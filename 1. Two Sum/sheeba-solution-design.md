# Two Sum - Solution Design

## Problem

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers whose values add up to the target.

The problem guarantees that:
- There is exactly one valid solution.
- The same element cannot be used twice.
- The indices can be returned in any order.

---

## Approach

I solved this problem using a **HashMap** to achieve linear time complexity.

The HashMap stores each number as the key and its index as the value. As I iterate through the array, I calculate the complement required to reach the target using:

```java
complement = target - nums[i];
```

For every number:

1. Calculate the complement.
2. Check whether the complement already exists in the HashMap.
3. If it exists, return the stored index together with the current index.
4. Otherwise, store the current number and its index in the HashMap and continue iterating.

The complement is checked **before** storing the current element. This ensures that the same element is not used twice and correctly handles duplicate values such as `[3, 3]`.

---

## Why a HashMap?

A brute-force solution compares every pair of numbers, resulting in **O(n²)** time complexity.

Using a HashMap allows constant-time (`O(1)`) lookups on average. By storing previously visited numbers, the array only needs to be traversed once, reducing the overall time complexity to **O(n)**.

---

## Time Complexity

- **Time:** O(n)
- **Space:** O(n)

The array is traversed once, and the HashMap stores at most one entry for each element.

---

## Example Walkthrough

Input:

```text
nums = [2, 7, 11, 15]
target = 9
```

Iteration 1:
- Current number = 2
- Complement = 7
- 7 is not in the HashMap
- Store `2 → 0`

Iteration 2:
- Current number = 7
- Complement = 2
- 2 exists in the HashMap at index 0
- Return `[0, 1]`

---

## Key Learning

This problem demonstrated how a HashMap can be used to trade additional memory for faster lookups. Instead of repeatedly searching the array, storing previously seen values enables an efficient one-pass solution that satisfies the follow-up requirement of achieving better than O(n²) time complexity.