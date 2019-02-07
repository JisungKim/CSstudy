import java.util.Scanner;

class Main{
    int[] queue;
    int head = -1;
    int tail = -1;
    int size;

    public Main(int size) {
        this.size = size;
        queue = new int[size];
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Main aQueue = new Main(n);
        for (int i=0; i < n; i++) {
            String s = sc.nextLine();
            String[] input = s.split(" ");
            if (input[0].equals("push")) {
                aQueue.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
               System.out.println(aQueue.pop());
            } else if (input[0].equals("size")) {
                System.out.println(Integer.toString(aQueue.getSize()));
            } else if (input[0].equals("empty")) {
                System.out.println(Integer.toString(aQueue.isEmpty()));
            } else if (input[0].equals("front")) {
                System.out.println(aQueue.getFront());
            } else if (input[0].equals("back")) {
                System.out.println(aQueue.getBack());
            }
        }
        sc.close();
    }

    public void push(int data) {
        queue[++tail] = data;
    }

    public int pop() {
        if (isEmpty()==1)
            return -1;
        return queue[++head];
    }

    public int getSize() {
        return (tail-head);
    }

    public int isEmpty() {
        return (head == tail) ? 1 : 0;
    }

    public int getFront() {
        if (isEmpty()==1)
            return -1;
        return queue[head+1];    
    }

    public int getBack() {
        if (isEmpty()==1)
            return -1;
        return queue[tail];    
    }

}