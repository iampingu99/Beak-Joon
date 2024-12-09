import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void seletTwo() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;
        int sum = 0;
        boolean flag = false;
        int[] arr = new int[N];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i = 0; i<N && !flag; i++){
            for(int j = i+1; j<N; j++){
                if(sum - (arr[i] + arr[j]) == 100){
                    for(int k = 0; k < N; k++){
                        if(k == i || k == j) continue;
                        result.add(arr[k]);
                    }
                    flag = true;
                    break;
                }
            }
        }

        Collections.sort(result);
        result.stream().forEach(e -> System.out.println(e));
    }
    public static void main(String[] args) throws IOException {
        seletTwo();
    }
}
