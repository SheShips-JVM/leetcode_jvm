 Longest Substring Without Repeating Characters - Solution Guide

## Problem

Given a string `s`, find the length of the longest substring without repeating characters.

- A substring is a contiguous sequence of characters within a string.

**Example**
Use code with caution.s = "abcabcbb"The longest substring without repeating characters is "abc", with length 3.
---

## Thought Process

The brute-force way to solve this is to check every possible substring, which takes O(n³) or O(n²) time. This is too slow for long strings.

To optimize, we use the **Sliding Window technique** with two pointers (`leftPointer` and `rightPointer`) and a **Hash Set**:

1. **Expand the Window**: Move `rightPointer` forward to explore new characters.
2. **Detect Duplicates**: Check if the character at `rightPointer` is already in our `HashSet`.
3. **Shrink the Window**: If it is a duplicate, we have a violation. We continuously remove characters from the left (`leftPointer`) and move `leftPointer` forward until the duplicate character is gone.
4. **Update Max Length**: Once the window is valid (no duplicates), we calculate its current size:
   length = rightPointer - leftPointer + 1We track the largest window size seen so far in `maxLength`.

By using a `HashSet`, lookups and deletions take O(1) time on average, allowing us to scan the string efficiently.

---

## Dry Run

l = "abcabcbb"subString = {}leftPointer = 0, maxLength = 0rightPointer=0, l='a' -> Not in set. Add 'a'.  subString={'a'}.       Length = 0-0+1 = 1. maxLength = 1rightPointer=1, l='b' -> Not in set. Add 'b'.  subString={'a','b'}.   Length = 1-0+1 = 2. maxLength = 2rightPointer=2, l='c' -> Not in set. Add 'c'.  subString={'a','b','c'}.Length = 2-0+1 = 3. maxLength = 3rightPointer=3, l='a' -> DUPLICATE DETECTED ('a' is in set)Loop: Remove l ('a'), leftPointer becomes 1. subString={'b','c'}'a' is no longer in set. Exit loop.Add 'a'. subString={'b','c','a'}. Length = 3-1+1 = 3. maxLength = 3rightPointer=4, l='b' -> DUPLICATE DETECTED ('b' is in set)Loop: Remove l ('b'), leftPointer becomes 2. subString={'c','a'}'b' is no longer in set. Exit loop.Add 'b'. subString={'c','a','b'}. Length = 4-2+1 = 3. maxLength = 3
---

## Complexity

| | Complexity | Why |
|---|---|---|
| **Time** | O(n) | Each character is visited at most twice (once by `rightPointer` and once by `leftPointer`) |
| **Space** | O(min(m, n)) | The size of the `HashSet` is bounded by the size of the string ($n$) or the size of the alphabet ($m$) |

---

## Edge Cases to Keep in Mind

- **Empty String** (`""`) → The loop never runs; returns `maxLength = 0` correctly.
- **All Identical Characters** (`"bbbbb"`) → The window keeps shrinking immediately; max length stays `1`.
- **String with No Repeats** (`"abcdef"`) → The window never shrinks; returns the total length of the string.
- **Case Sensitivity** (`"pP"`) → `HashSet` treats `'p'` and `'P'` as different characters; returns `2`.
