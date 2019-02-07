import java.util.Scanner;

class Queue { 
    //현재 위치 노드
    private Node topNode;
    private Node headNode;
    private int size = 0;

    public Queue() {
        topNode = new Node(0);
        headNode = new Node(0);
    }
    
    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(); 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0; i < n; i++) {
            String s = sc.nextLine();
            String[] input = s.split(" ");
            if (input[0].equals("push")) {
                queue.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop")) {
               System.out.println(queue.pop());
            } else if (input[0].equals("size")) {
                System.out.println(queue.getSize());
            } else if (input[0].equals("empty")) {
                System.out.println(queue.isEmpty());
            } else if (input[0].equals("front")) {
                System.out.println(queue.getFront());
            } else if (input[0].equals("back")) {
                System.out.println(queue.getBack());
            }
        }
        sc.close();
    }

    public void push(int data) {
        Node node = new Node(data);
        if (isEmpty() == 1) {
            topNode = node;
            headNode = node;
        } else {
            topNode.next = node;
            topNode = node;
        }
        size++;
    }

    public int pop() {
        if (isEmpty()==1) return -1;
        int data = headNode.data;
        //노드 위치 수정
        headNode = headNode.next; 
        if (headNode == null)
            topNode = null;
        size--;
        return data;
    }   
    
    public int isEmpty() {
        return (size == 0)? 1 : 0;  
    }

    public int getSize() {
        return size;
    }

    public int getFront() {
        if(headNode == null)
            return -1;
        return headNode.data;
    }

    public int getBack() {
        if(topNode == null)
            return -1;
        return topNode.data;
    }

    private class Node {
        private int data;
        private Node next; // 이전 노드의 값
 
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}