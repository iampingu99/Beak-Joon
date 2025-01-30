import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
 
        long A = Long.parseLong(param[0]);
        long B = Long.parseLong(param[1]);
        long C = Long.parseLong(param[2]);
        System.out.print(A + B + C);
    }
}