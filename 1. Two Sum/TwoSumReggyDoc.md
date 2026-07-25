# Two Sum - Solution Guide

## Problem

Given an array of integers `nums` and an integer `target`, return the indices
of the two numbers that add up to `target`.

- Exactly one valid answer exists.
- You cannot use the same element twice.
- Order of the two returned indices doesn't matter.

**Example**
```
nums = [2, 7, 11, 15], target = 9
2 + 7 == 9  ->  return [0, 1]
```

---

## Thought Process

The naive way to solve this is to check every possible pair of numbers —
for each `nums[i]`, scan the rest of the array for a `nums[j]` such that
`nums[i] + nums[j] == target`. That works, but it's O(n²): for every
element, you re-scan almost the whole array again.

The key insight: instead of asking *"what number, paired with this one,
gives me the target?"* and searching for it every time, flip the question
around. As you walk through the array once, keep track of every number
you've already seen. For the current number, compute its **complement**:

```
complement = target - nums[i]
```

Then just ask: *"have I already seen this complement?"* Checking
"have I seen this value" is instant if you store seen values in a
**hash map** (average O(1) lookup), instead of scanning the array again.

So the pattern is:
1. Walk through the array once.
2. At each element, check whether its complement is already in the map.
    - If yes → you've found your pair. Return the stored index and the
      current index.
    - If no → store the current number and its index in the map, and move on.

Because we check *before* inserting the current element, we never pair a
number with itself.

---

## Dry Run

```
nums = [2, 7, 11, 15], target = 9
map = {}

i=0, nums[0]=2, complement = 9-2 = 7
  7 not in map -> map = {2:0}

i=1, nums[1]=7, complement = 9-7 = 2
  2 IS in map (index 0) -> return [0, 1]
```

---

## Complexity

| | Complexity | Why |
|---|---|---|
| **Time** | O(n) | Single pass through the array; each hash map lookup/insert is O(1) on average |
| **Space** | O(n) | In the worst case (no early match), you store almost every element in the map |

Compare to the brute-force approach: O(n²) time, O(1) space. The hash map
trades extra memory for a big speed win — worth it for almost any
realistic input size.

---

## Edge Cases to Keep in Mind

- No valid pair exists → decide whether to throw an exception or return
  something like `null` / empty array (depends on requirements).
- Duplicate values in the array, e.g. `nums = [3, 3], target = 6` → still
  works correctly, since by the time you reach the second `3`, the first
  `3`'s index is already in the map.
- Negative numbers → works fine, no special handling needed since we're
  just doing subtraction.