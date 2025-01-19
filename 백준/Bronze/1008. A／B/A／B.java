import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        double a = Double.parseDouble(param[0]);
        double b = Double.parseDouble(param[1]);

        System.out.println(a / b);
    }
}
