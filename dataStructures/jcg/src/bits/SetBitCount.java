package bits;

import java.util.Stack;

public class SetBitCount {
    static int setBits(int N) {
        int setBitCount = 0;

        Stack<Integer> stack = new Stack<>();

        while(N > 0) {
            int reminder = N%2;
            stack.push(reminder);
            N /= 2;

            if(reminder > 0) {
                setBitCount++;
            }
        }

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }

        System.out.println("=================  = ==============");

        return setBitCount;
    }

    public static void main(String[] args) {
        System.out.println(setBits(787897));
    }
}
