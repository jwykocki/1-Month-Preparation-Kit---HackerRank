import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        

        Map<Character,Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        TreeMap<Integer,Integer> freqFreq = new TreeMap<>();

        for(int i : freq.values()){
            freqFreq.put(i,freqFreq.getOrDefault(i,0)+1);
        }
    
        if(freqFreq.size() == 1){
            return "YES";
        }else if(freqFreq.size() == 2){
            int key1 = freqFreq.firstKey();
            int key2 = freqFreq.lastKey();
            int value1 = freqFreq.get(key1);
            int value2 = freqFreq.get(key2);

            if((key1 == 1 && value1 == 1) ||
            (key2 - key1 == 1 && value2 == 1)){
                return "YES";
            }
        }
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
