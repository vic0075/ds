import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class HexRepresentation {
    public static void main(String[] args) {
        System.out.println(new BigInteger(1, "32".getBytes(StandardCharsets.US_ASCII)));
        System.out.printf("%02x%n", new BigInteger(1, "32".getBytes(StandardCharsets.US_ASCII)));
        System.out.printf("------ %02x%n", 32);
        System.out.println(Integer.toHexString(32));
    }
}

