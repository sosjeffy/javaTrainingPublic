package week2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Node {
    int value;
    Node next;
    Node(){
        value = 0;
        next = null;
        String s = "cat";
    }
    Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
    Node(int value){
        this.value = value;
        next = null;
    }

    int getValue(){
        return value;
    }

    void setValue(int value){
        this.value = value;
    }

    Node getNext(){
        return next;
    }

    void setNext(Node next){
        this.next = next;
    }

    void printAllConnected(){
        Node temp = next;
        StringBuilder sb = new StringBuilder();
        sb.append(value).append(" -> ");
        while (temp != null){
            sb.append(temp.getValue()).append(" -> ");
            temp = temp.getNext();
        }
        sb.append("null");
        System.out.println(sb);
    }
}

class Stack{
    Node head;
    void push(int value){
        // O(1) time complexity, if we don't include the print function
        Node node = new Node(value);
        if (head == null){
            head = node;
        }
        else{
            Node temp = head;
            head = node;
            head.next = temp;
        }
    }
    int pop(){
        // Time complexity is O(1)
        if (head == null){
            return -1;
        }
        Node temp = head;
        head = head.next;
        return temp.getValue();
    }
    Node getHead(){
        return head;
    }
}
public class DSA{
    static long vowelCounter(String str){
        // Time complexity: O(n), where n is length of the string. We will always iterate through the
        // entire string length to check for any vowels
        long counter;
        final String VOWELS = "aeiouAEIOU";
        counter =  str.chars().filter(ch -> VOWELS.indexOf(ch) != -1).count();
        return counter;
    }

    static int secondLargest(int[] integers){
        // Time complexity is O(n), where n is the length of integers, because worst case we only
        // iterate over the entire length of the array
        if (integers.length <= 1){
            return -1;
        }
        int largestSoFar = Math.max(integers[0], integers[1]);
        int secondLargestSoFar = Math.min(integers[0], integers[1]);
        for (int i = 2; i < integers.length; i ++) {
            if (integers[i] >= largestSoFar) {
                secondLargestSoFar = largestSoFar;
                largestSoFar = integers[i];
            }
            else if (integers[i] > secondLargestSoFar){
                secondLargestSoFar = integers[i];
            }
        }
        return secondLargestSoFar;
    }


    public static void main(String[] args) {
        System.out.print("VowelCounter w/ '': ");
        System.out.println(vowelCounter(""));
        System.out.print("VowelCounter w/ 'aeiou': ");
        System.out.println(vowelCounter("aeiou"));
        System.out.print("VowelCounter w/ 'make a kitten': ");
        System.out.println(vowelCounter("make a kitten"));

        System.out.println();

        System.out.print("Second Largest {1,2,3,4,5,6,7,8,9}: ");
        System.out.println(secondLargest(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.print("Second Largest {8,8,8,8,8}: ");
        System.out.println(secondLargest(new int[]{8,8,8,8,8}));
        System.out.print("Second Largest {}: ");
        System.out.println(secondLargest(new int[]{}));
        System.out.print("Second Largest {9,8}: ");
        System.out.println(secondLargest(new int[]{9,8}));
        System.out.print("Second Largest {15, 12, 20, 18, 18, 13}: ");
        System.out.println(secondLargest(new int[]{15, 12, 20, 18, 18, 13}));

        System.out.println();

        System.out.println("Stack Test: ");
        Stack testStack = new Stack();
        System.out.print("Pushing 5: ");
        testStack.push(5);
        testStack.getHead().printAllConnected();

        System.out.print("Pushing 10: ");
        testStack.push(10);
        testStack.getHead().printAllConnected();

        System.out.println("Popping. Popped off " + testStack.pop());
        System.out.print("Stack after pop: ");
        testStack.getHead().printAllConnected();

        System.out.print("Pushing 15: ");
        testStack.push(15);
        testStack.getHead().printAllConnected();

        System.out.println("Popping. Popped off " + testStack.pop());
        System.out.print("Stack after pop: ");
        testStack.getHead().printAllConnected();

        System.out.println("Popping. Popped off " + testStack.pop());
        System.out.print("Stack after pop: ");
        if (testStack.getHead() == null) {
            System.out.println("null");
        };
    }
}