import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = Arrays.stream(br.readLine().split("-"))
                .mapToInt(str -> Arrays.stream(str.split("\\+"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .reduce((a, b) -> a - b).orElse(0);

        System.out.println(answer);
    }
}
