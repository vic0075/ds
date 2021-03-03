package linkedList;

// { Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class RemoveLoop
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            System.out.println("n::"+n);

            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;

            System.out.println("n::"+n);
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
                System.out.println("next item");
            }

            int pos = sc.nextInt();
            makeLoop(head, pos);

            solver x = new solver();
            x.removeLoop(head);

            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}
// } Driver Code Ends

class solver
{
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes

        if(head == null || head.next == null) {
            return;
        }

        Node node1 = head;
        Node node2 = head;

        boolean loop = false;

        while(node2 !=null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;

            if(node1 == node2) {
                loop = true;
                break;
            }
        }

        if(loop) {
            node2 = head; //reset one of the references to head of list

            //until both the references are one short of the common element which is the start of the loop
            while(node2.next != node1.next)
            {
                node2 = node2.next;
                node1 = node1.next;
            }

            Node start = node2.next;

            //PART III - Eliminate the loop by setting the 'next' pointer
            //of the last element to null
            node2 = start;
            while(node2.next != start)
            {
                node2 = node2.next;
            }

            node2.next = null; //break the loop
        }

    }
}
