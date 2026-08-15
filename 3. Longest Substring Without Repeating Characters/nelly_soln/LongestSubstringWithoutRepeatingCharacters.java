import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;


class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    String example1 = "pwwkew";
        System.out.println("Longest " + longestSubstringWithTreeMap(example1));
        System.out.println("Longest " + longestSubstringWithoutDuplicateCharacters(example1));
    }

    //Treemap attempt
    private static String longestSubstringWithTreeMap(String phrase) {
        if (phrase == null || phrase.isEmpty()) return "";

        // TreeMap automatically sorts keys  from smallest to largest
        TreeMap<Integer, String> checker = new TreeMap<>();
        String currentSub = "";

        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            int duplicateIndex = currentSub.indexOf(c);

            if (duplicateIndex != -1) {
                // save the valid substring we found before resetting
                checker.put(currentSub.length(), currentSub);

                // remove everything up to the duplicate character.
                currentSub = currentSub.substring(duplicateIndex + 1);
            }

            currentSub += c;
        }

        // save the very last substring remaining after the loop ends
        checker.put(currentSub.length(), currentSub);

        // return the value of the largest key bcz its the highest length
        return checker.lastEntry().getValue();
    }



    //sliding window is the recomended approach
    private static String longestSubstringWithoutDuplicateCharacters(String phrase) {
        if (phrase == null || phrase.isEmpty()) return "";

        String longestSub = "";
        int start = 0;
        Set<Character> seen = new HashSet<>();

        // Use a sliding window with two pointers: start and end
        for (int end = 0; end < phrase.length(); end++) {
            char current = phrase.charAt(end);

            // If we see a duplicate, shrink the window from the left
            while (seen.contains(current)) {
                seen.remove(phrase.charAt(start));
                start++;
            }

            // Add the new character to our window
            seen.add(current);

            // Get the current substring inside the window
            String currentSub = phrase.substring(start, end + 1);

            // Update the longest tracking string if the current one is bigger
            if (currentSub.length() > longestSub.length()) {
                longestSub = currentSub;
            }
        }

        return longestSub;
    }

}