import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Josephus {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        sb.append("<");
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=1; i <= n; i++) {
            queue.offer(i);
        }
        
        for(int i=0; i < n-1; i++) {
            for(int j=0; j < m-1; j++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll() + ", ");
        }
        
        sb.append(queue.poll() + ">");
        System.out.println(sb);
    }
}
