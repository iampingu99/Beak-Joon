import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str; // str.length ≤ 100

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        int length = str.replaceAll("((c|dz|s|z)=|[cd]-|[ln]j)", " ").length();
        System.out.println(length);
    }
}
