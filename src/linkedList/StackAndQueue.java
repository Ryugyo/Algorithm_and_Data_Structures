package linkedList;

/**
 * Created by Jason Tan on 2022-09-06 14:55
 */
public class StackAndQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println('\n');

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static class Node<T> {
        public T value;
        public Node<T> prev;
        public Node<T> next;

        public Node(T value){
            this.value = value;
        }
    }

    public static class Queue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void add(T value){
            Node<T> node = new Node<T>(value);
            if (head == null){
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public T pop(){
            if (tail == null){
                return null;
            }
            T return_value = tail.value;
            if (head == tail){
                head = null;
                tail = null;
            } else {
                Node<T> prev = tail.prev;
                prev.next = null;
                tail.prev = null;
                tail = prev;
            }
            return return_value;
        }
    }

    public static class Stack<T> {
        Node<T> head;
        Node<T> tail;

        public void add(T value){
            Node<T> node = new Node<>(value);
            if (head == null){
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public T pop(){
            if (head == null){
                return null;
            }
            T return_value = head.value;
            if (head == tail){
                head = null;
                tail = null;
            } else {
                Node<T> new_head = head.next;
                head.next = null;
                new_head.prev = null;
                head = new_head;
            }
            return return_value;
        }
    }
}
