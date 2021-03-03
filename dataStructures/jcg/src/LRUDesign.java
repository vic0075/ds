// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    static Map<Integer, Node> cache;

    static int capacity;
    static int count;

    static Node head;
    static Node tail;

    LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
        cache = new HashMap<>();
        this.capacity = cap;
    }

    public static void addToHead(Node node) {
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head.next;
        if(head.next != null) {
            head.next.pre = node;
        }

        node.pre = head;
        head.next = node;
    }

    public static void removeNode(Node node) {
        if(node.pre != null) {
            node.pre.next = node.next;
        }
        if(node.next != null) {
            node.next.pre = node.pre;
        }
    }

    // This method works in O(1)
    public static int get(int key)
    {
        // your code here
        Node object = cache.get(key);

        if(object == null) {
            return -1;
        }

        removeNode(object);
        addToHead(object);

        return object.value;

    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        // your code here

        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
            return;
        }

        if(capacity < count) {
            removeNode(tail);
            tail = tail.pre;
        }

        Node node = new Node(key, value);

        cache.put(key, node);
        addToHead(node);
        count++;
    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
