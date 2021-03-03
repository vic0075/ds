package strings;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverse("i.like.this.program.very.much.ab"));
    }

    public static String reverse(String s) {
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '.') {
                while (!stack.empty()) {
                    result.append(stack.pop());
                }
                result.append('.');
            } else {
                stack.push(c);
            }
        }

        if(!stack.empty()) {
            while (!stack.empty()) {
                result.append(stack.pop());
            }
        }

        return result.toString();
    }
}
