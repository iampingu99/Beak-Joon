import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        long one = Arrays.stream(str.split("0"))
                .filter(i -> !i.isEmpty())
                .count();
        long zero = Arrays.stream(str.split("1"))
                .filter(i -> !i.isEmpty())
                .count();

        System.out.println(Math.min(one, zero));
    }
}
