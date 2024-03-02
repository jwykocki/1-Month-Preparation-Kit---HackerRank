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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        if(s.charAt(8)=='P'){
            if(!(s.charAt(0)=='1' && s.charAt(1)=='2')){
                sb.setCharAt(0, (char)  ((int) sb.charAt(0) + 1));
                sb.setCharAt(1, (char)  ((int) sb.charAt(1) + 2));
            }
        }
        else if(s.charAt(8)=='A' && (s.charAt(0)=='1' && s.charAt(1)=='2')){
            sb.setCharAt(0, '0');
            sb.setCharAt(1, '0');
        }
        return sb.substring(0, 8);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
