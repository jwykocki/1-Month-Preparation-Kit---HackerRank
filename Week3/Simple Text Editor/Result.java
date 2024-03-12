import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // Number of operations
        StringBuilder text = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < q; i++) {
            int operation = scanner.nextInt();
            switch (operation) {
                case 1: // Append
                    history.push(text.toString());
                    String appendString = scanner.next();
                    text.append(appendString);
                    break;
                case 2: // Delete
                    history.push(text.toString());
                    int deleteCount = scanner.nextInt();
                    int len = text.length();
                    text.delete(len - deleteCount, len);
                    break;
                case 3: // Print
                    int index = scanner.nextInt() - 1;
                    System.out.println(text.charAt(index));
                    break;
                case 4: // Undo
                    if (!history.isEmpty()) {
                        text = new StringBuilder(history.pop());
                    }
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
