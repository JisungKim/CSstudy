class StackLinkedList{
    // top
    private Node topNode;
    private Node hNode;
    //노드의 갯수
    private int size = 0; 

    public StackLinkedList() {
        topNode = new Node(null);
    }

    public static void main(String[] args) {
        StackLinkedList sLinkedList = new StackLinkedList();
        //푸쉬
        sLinkedList.push(1);
        System.out.println(sLinkedList.pop()+"");
        sLinkedList.push(2);
        sLinkedList.push(3);             
        //팝
        System.out.println(sLinkedList.pop()+"");
        System.out.println(sLinkedList.pop()+"");
        System.out.println(sLinkedList.pop()+"");
        //isEmpty
        System.out.println(sLinkedList.isEmpty());
        //top 값
        System.out.println(sLinkedList.top());
        // 현재 스택 size 
        System.out.println(sLinkedList.getSize());
    }

    public int getSize() {
        return size;
    }

    public Object top() {
        if (topNode != null)
            return topNode.data;
         return -1;   
    }

    public boolean isEmpty() {
        return (topNode == null);
    }

    public void push(Object data) {
        Node node = new Node(data); 
        size++;   
        if (hNode == null) {
            hNode = node;
            topNode = hNode;
            return;
        }
        topNode.next = node;
        topNode = node;
    }

    public Object pop() {
        if (isEmpty()) { 
            System.out.println("언더플로우");
            throw new ArrayIndexOutOfBoundsException();
        }
        //탑노드의 데이터를 팝하고
        Object data = topNode.data;
        //탑노드를 변경해준다.
        if (hNode == topNode) {
            hNode=topNode=null;
        } else {
            Node head = hNode;
            while(head.next != topNode) {
                head = head.next;
            }
            topNode = head;
        }
        size--;
        return data;
    }

    //inner class
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        } 
    }

}

