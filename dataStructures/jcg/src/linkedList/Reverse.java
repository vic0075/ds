package linkedList;

public class Reverse {
    public static Node reverseDLL(Node  head)
    {
        Node current = head;
        Node prev = null;

        while(current != null) {
            Node temp = current.next;

            current.next = current.prev;
            current.prev = temp;

            prev = current;
            current = temp;
        }

        if(prev != null) {
            head = prev;
        }

        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(3, new Node(4, new Node(5, null)));
        System.out.println("input");

        print(head);

        print(reverseDLL(head));
    }

    static void print(Node head) {
        Node counter = head;

        while(counter!= null) {
            System.out.print(counter.data);
            counter = counter.next;
            if(counter != null) {
                System.out.print(" <--> ");
            }
        }

        System.out.println();
    }

    static class Node
    {
        int data;
        Node next, prev;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
            if(next != null) {
                this.next.prev = this;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + (next != null? next.data: null) +
                    ", prev=" + (prev !=null? prev.data: null) +
                    '}';
        }
    }
}


