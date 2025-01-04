import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int base[];
    public static int arr[];
    public static boolean visited[];
    public static int MAX = Integer.MIN_VALUE;

    public static void permutation(int depth){
        if(depth == N){
            int sum = 0;
            for(int i = 0; i<N-1; i++){
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            MAX = Math.max(MAX, sum);
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[depth] = base[i];
            permutation(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        base = new int[N];
        arr = new int[N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            base[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(MAX);
    }
}
