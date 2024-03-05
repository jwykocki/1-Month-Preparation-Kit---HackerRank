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
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */
     

    public static List<String> bomberMan(int n, List<String> grid) {
        
        //just 1 second - nothing happens
        if(n == 1){
        return grid;
        }
        
        //all bombs are set
        if(n % 2 == 0){
            List<String> ans = new ArrayList<>();
            for(int i = 0;i<grid.size();i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<grid.get(0).length();j++){
                    sb.append('O');
                }
                ans.add(sb.toString());
            }
            return ans;
        }
        
        if(n % 4 == 1){
            return bombMap(bombMap(grid));
        }

        // n % 4 == 3
        return bombMap(grid);

    }
    //simulate detonating bombs
    private static List<String> bombMap(List<String> grid){
        List<String> ans = new ArrayList<>();
        for(int i = 0;i<grid.size();i++){
            String row = grid.get(i);
            StringBuilder sb = new StringBuilder();

            for(int j = 0;j<row.length();j++){

                if(row.charAt(j) == 'O'){
                    sb.append('.');
                    continue;
                }

                if(checkBomb(grid,i,j)){
                    sb.append('.');
                }else{
                    sb.append('O');
                }
            }
            ans.add(sb.toString());
        }

        return ans;
    }
    
    //check if there is bomb near this index
    private static boolean checkBomb(List<String> grid,int i,int j){
        if(i - 1 >= 0 && grid.get(i-1).charAt(j) == 'O'){
            return true;
        }

        if(i + 1 < grid.size() && grid.get(i+1).charAt(j) == 'O'){
            return true;
        }
        if(j - 1 >= 0 && grid.get(i).charAt(j-1) == 'O'){
            return true;
        }

        int len = grid.get(0).length();
        if(j + 1 < len && grid.get(i).charAt(j+1) == 'O'){
            return true;
        }

        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
