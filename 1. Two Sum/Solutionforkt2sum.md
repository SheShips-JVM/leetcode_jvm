# Design Document – Two Sum (Brute Force Approach)

## Problem

The goal is to find the indices of two numbers in an array that add up to a given target value. The problem guarantees that there is exactly one valid answer, and the same element cannot be used twice.

## My Approach

My approach uses a nested loop system to perform a brute-force check across the entire array. I iterate through the array to select a first number then use a second loop to iterate through the array again to look for a matching companion.

For each pair of elements, I check if the subtraction of the first value from the target matches the second value (`target - v1 == v2`). To ensure that I do not accidentally pair an element with itself, I verify that the two indices are unique (`i1 != i2`).

Once a matching pair satisfying both conditions is found, the algorithm immediately stops and returns their indices in a new integer array.

## Why I Chose the Brute-Force Look

This approach is highly intuitive and straightforward to implement. It directly maps to the core requirement of the problem statement by checking every possible pair combination manually. It does not require initializing any extra data structures or managing complex collections.

## Algorithm

1. Begin an outer loop to iterate through the array, tracking the first index (`i1`) and value (`v1`).
2. Inside, begin an inner loop to iterate through the same array, tracking the second index (`i2`) and value (`v2`).
3. For each combination, evaluate if the current complement match is true (`target - v1 == v2`).
4. Simultaneously verify that the indices are distinct (`i1 != i2`).
5. If both conditions are met, immediately return an array containing `[i1, i2]`.
6. If the loops conclude without finding a pair, throw an `IllegalStateException` as a structural safeguard.

## Complexity

* **Time Complexity:** O(n²), because the nested loops force the algorithm to compare every single element against every other element in the worst case.
* **Space Complexity:** O(1), since the search is conducted entirely in place and requires no auxiliary memory structures.

