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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        
        char[] ca = s.toCharArray();
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> cbrackets = new HashMap<>();
        cbrackets.put(')', '(');
        cbrackets.put('}', '{');
        cbrackets.put(']', '[');
        
        for(char c : ca){
            if(cbrackets.containsValue(c)){
                brackets.push(c);
            }else{
                if(brackets.isEmpty()){
                    return "NO";
                }
                char b = brackets.pop();
                if(b != cbrackets.get(c)){
                    return "NO";
                }
            }    
        }
        
        if(brackets.size()>0){
            return "NO";
        }
        
        return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

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
