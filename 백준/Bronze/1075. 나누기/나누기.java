import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		//뒤 두자리 수를 00으로 바꿔주는 과정
		N -= (N % 100);
		
		//무한루프
		while(true) {
			//나누어떨어지면 무한루프 종료
			if(N % F == 0) {
				break;
			}
			N++;
		}
		System.out.format("%02d", (N % 100));
	}

}