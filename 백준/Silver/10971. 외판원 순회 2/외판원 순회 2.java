import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int matrix[][];
    public static boolean visited[];
    public static int MIN = Integer.MAX_VALUE;

    public static void TSP(int depth, int start, int prev, int sum){
        if(depth == N){
            if(matrix[prev][start] != 0) {
                MIN = Math.min(MIN, sum + matrix[prev][start]);
            }
            return;
        }

        for(int i = 0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if (matrix[prev][i] != 0) {
                TSP(depth + 1, start, i, sum + matrix[prev][i]);
            }
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<N; i++){
            visited[i] = true;
            TSP(1, i, i, 0);
        }

        System.out.println(MIN);
    }
}
