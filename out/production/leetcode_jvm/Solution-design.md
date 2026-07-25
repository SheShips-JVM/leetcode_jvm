# Design Document – Two Sum

## Problem

The goal is to find the indices of two numbers in an array that add up to a given target value. The problem guarantees that there is exactly one valid answer, and the same element cannot be used twice.

## My Approach

My first thought was the brute-force solution, where every number is compared with every other number until a matching pair is found. While that works, it requires checking many unnecessary combinations and has a time complexity of O(n²).

A better approach is to use a `HashMap`. As I iterate through the array, I keep track of the numbers I've already seen along with their indices. For each current number, I calculate the value I would need to reach the target (`target - nums[i]`). If that value already exists in the map, I've found the answer and can immediately return the two indices.

If it doesn't exist, I simply store the current number and continue to the next element.

One important detail is that I check the map **before** inserting the current number. This prevents an element from being paired with itself, while still correctly handling duplicate values such as `[3, 3]`.

## Why I Chose a HashMap

A `HashMap<Integer, Integer>` is a good fit because it provides average-case O(1) lookups and insertions. This allows the solution to find the answer in a single pass through the array instead of repeatedly searching through previously visited elements.

## Algorithm

1. Create an empty `HashMap`.
2. Iterate through the array.
3. For each number, calculate its complement (`target - currentNumber`).
4. Check whether the complement already exists in the map.
5. If it does, return the stored index together with the current index.
6. Otherwise, store the current number and its index in the map.
7. If no pair is found, throw an exception. Although the problem guarantees a solution, this acts as a safeguard.

## Complexity

* **Time Complexity:** O(n), since the array is traversed only once.
* **Space Complexity:** O(n), because in the worst case every element is stored in the `HashMap`.

## Comparison with the Brute-Force Solution

The brute-force approach compares every possible pair of numbers, resulting in O(n²) time complexity. While it uses very little extra memory, it becomes inefficient as the input size grows.

Using a `HashMap` reduces the running time to O(n) by trading additional memory for much faster lookups. For larger inputs, this is a much more efficient solution.

## Edge Cases

While testing the solution, I considered a few common edge cases:

* Arrays containing duplicate values, such as `[3, 3]`.
* Arrays containing negative numbers.
* Negative target values.
* Cases where the matching numbers are not adjacent.

The solution handles all of these correctly without requiring any special logic.
