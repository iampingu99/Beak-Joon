import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int matrix[][];
    public static int arr[];
    public static boolean visited[];
    public static int MIN_SUB = Integer.MAX_VALUE;

    public static void recursion(int depth, int r){
        if(depth == arr.length){
            MIN_SUB = Math.min(MIN_SUB, teamAbility());
            return;
        }

        for(int i = r; i<N; i++){
            visited[i] = true;
            recursion(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    
    public static int teamAbility(){
        int start[] = new int[N/2];
        int link[] = new int[N/2];
        int sAbility = 0;
        int lAbility = 0;
        int s = 0;
        int l = 0;

        for(int i = 0; i<N; i++){
            if(visited[i]) start[s++] = i;
            else link[l++] = i;
        }

        for(int i = 0; i<N/2; i++){
            for(int j = i; j<N/2; j++){
                sAbility += matrix[start[i]][start[j]] + matrix[start[j]][start[i]];
                lAbility += matrix[link[i]][link[j]] + matrix[link[j]][link[i]];
            }
        }
        return Math.abs((sAbility - lAbility));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        arr = new int[N/2];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0);
        System.out.println(MIN_SUB);
    }
}
