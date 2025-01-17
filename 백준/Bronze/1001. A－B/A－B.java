import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        int a = Integer.parseInt(param[0]);
        int b = Integer.parseInt(param[1]);

        System.out.println(a - b);
    }
}
