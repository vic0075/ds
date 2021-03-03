package strings;// { Driver Code Starts

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class AnagramChecker {

    public static void main(String[] args) throws IOException {
        System.out.println(Anagram.isAnagram("geeksforgeeks", "forgeeksgeeks"));
    }
}// } Driver Code Ends


class Anagram {
    /*  Function to check if two strings are anagram
     *   a, b: input string
     */
    public static boolean isAnagram(String a, String b) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();

        a.chars().forEach(c -> {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        });

        b.chars().forEach(c -> {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                return;
            }
            int freq = map.get(c) - 1;
            if (freq == 0) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        });

        return map.size() == 0;
    }
}