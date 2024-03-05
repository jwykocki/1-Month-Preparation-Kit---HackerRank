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
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */
     
    static boolean isPowerOfTwo(long n) {
        return n != 0 && ((n & (n - 1)) == 0);
    }

    public static String counterGame(long n) {
    
        int count = 0;
        
        while(n!=1){
            
            if(isPowerOfTwo(n)){
                n /=2;
            }
            else{
                long largestPowerOfTwo = 1L << (64 - Long.numberOfLeadingZeros(n) - 1);
                n -= largestPowerOfTwo;
            }
            
            count++;
            
        }
        
        if (count % 2 == 0) {
            return "Richard";
        } else {
            return "Louise";
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
