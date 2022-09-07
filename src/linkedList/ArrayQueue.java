package linkedList;

import java.util.zip.Inflater;

/**
 * Created by Jason Tan on 2022-09-06 15:55
 */
public class ArrayQueue {

    public static void main(String[] args) {
        Queue q = new Queue(7);
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(6);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(10);
        q.push(11);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }

    public static class Queue {
        private int[] queue;
        private int push_index;
        private int pop_index;
        private int total;
        private final int limit;

        public Queue(int size){
            queue = new int[size];
            push_index = pop_index = total = 0;
            limit = size;
        }

        public void push(int value){
            if (total == limit){
                System.out.println("Queue is full");
                return;
            }
            queue[push_index] = value;
            if (push_index == limit-1){
                push_index = 0;
            } else {
                push_index += 1;
            }
            total += 1;
        }

        public int pop(){
            if (total == 0){
                return -1;
            }
            int return_value = queue[pop_index];
            if (pop_index == limit-1){
                pop_index = 0;
            } else {
                pop_index += 1;
            }
            total -= 1;
            return return_value;
        }
    }
}
