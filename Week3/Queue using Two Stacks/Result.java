import java.io.*;
import java.util.*;

public class Solution {
    
    public static class MyQueue{
        Stack<Integer> inputs;
        Stack<Integer> outputs;
        
        public MyQueue(){
            inputs = new Stack<>();
            outputs = new Stack<>();
        }
        
        public void enqueue(int e){
            inputs.add(e);
        }
        
        public void printFront(){
            makeOutputFull();
            System.out.println(outputs.peek());
        }
        
        public int dequeue(){
            makeOutputFull();
            return outputs.pop();
        }
        
        private void makeOutputFull(){
            if(outputs.empty()){
                while(!inputs.empty()){
                    outputs.push(inputs.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);
        int n = new Integer(scanner.nextLine());
        MyQueue mq = new MyQueue();

        for(int i=0; i<n; i++){
            String line  = scanner.nextLine();
            char task = line.charAt(0);
            if(task=='1'){
                String[] nums = line.split(" ");
                int toEnqueue = new Integer(nums[1]);
                mq.enqueue(toEnqueue);
            }
            else if (task == '2'){
                //deque
                mq.dequeue();
            }
            else{
                //print front
                mq.printFront();
            }
            
        }
    }
}
