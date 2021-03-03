package strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>(s.length());
        int i = 0;
        int j = 0;

        while(i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                max = Math.max(max, j-i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("PRAKRITI"));
    }
}
