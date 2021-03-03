package strings;

public class Atoi {

    static int atoi(String str) {
        int ZERO = '0';
        int NINE = '9';

        int result = 0;
        int multiplier = '1';

        for(int i=0; i<str.length(); i++) {

            System.out.println(result);

            char c = str.charAt(i);

            if(i == 0 && (c == '-' || c == '+')) {
                multiplier = c == '-'? -1: 1;
                continue;
            }

            if (c < ZERO || c > NINE) {
                return -1;
            }

            result = (result * 10 + Integer.parseInt(c + ""));
        }

        return result * multiplier;
    }

    public static void main(String[] args) {
        System.out.println(atoi("-12"));
    }
}
