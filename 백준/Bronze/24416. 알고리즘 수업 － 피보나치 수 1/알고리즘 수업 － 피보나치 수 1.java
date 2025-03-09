import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        
        dp = new int[N+1];
		dp[1]=dp[2]=1;
		for(int i=3;i<=N;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
        
        System.out.println(dp[N]+" "+(N-2));
	}
}