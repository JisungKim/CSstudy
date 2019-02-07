import java.util.Scanner;

public class StackArray {
    int[] data;
    int top;
    int size;

    public StackArray(int size) {
        data = new int[size];   
        top = -1; // 현재 위치
        this.size = size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StackArray sArray = new StackArray(n);
    }

    public void push(int n) {
        if (top > size) {
            System.out.println("오버플로우");
            throw new IndexOutOfBoundsException();
        } 
        data[++top] = n;
    }

    public int pop() {
        if (top < 0) {
            System.out.println("언더플로우");
            throw new IndexOutOfBoundsException();
        }
        return data[top--]; 
    }
    
    public int top() {
        return data[top];    
    }

    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    //현재 스택에 저장된 자료의 개수
    public int size() {
        return top+1;
    }
}
