import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    static Map<Character, Integer> freq;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        freq = new HashMap<>();
        String str = br.readLine();

        // 1. 문자열 등장 횟수 세기: 맵
        // 소문자일 경우 대문자로 변경
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) c -= 32;
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 1-1. 등장 횟수 오름차순으로 정렬
        List<Entry<Character, Integer>> sort = freq.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toList());

        // 1-2. 유일한 최대값
        // 2. 출력
        if (sort.size() > 1 && sort.get(sort.size() - 1).getValue().equals(sort.get(sort.size() - 2).getValue()))
            System.out.println("?");
        else System.out.println(sort.get(sort.size() - 1).getKey());
    }
}
