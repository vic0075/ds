package strings;

public class CheckRotation {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        s1 = s1 + s1;

        int i = 0, j = 0;
        int matched = 0;

        s1 = s1 + s1;

        while (j < s2.length() && i < s1.length()) {
            System.out.println("i = "+ i+", j = "+j);
            if (s2.charAt(j) == s1.charAt(i)) {
                System.out.println("matched");
                j++;
                matched++;
            } else {
                System.out.println("not matched");
            }

            i++;
        }

        System.out.println(" -------------  result -----------------");

        return matched == s2.length();
    }

    public static void main(String[] args) {
        System.out.println(areRotations("lyeltaindpqlfuguxznfazrtvqkfimsvmwigyqte", "eltaindpqlfuguxznfazrtvqkfimsfmwigyqtely"));
    }
}
