import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int YEAR = 543;
    static int Y; // 1000 ≤ y ≤ 3000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Y = Integer.parseInt(br.readLine());
        System.out.println(Y - YEAR);
    }
}
