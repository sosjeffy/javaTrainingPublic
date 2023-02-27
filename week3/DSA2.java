package week3;

import week3.Node;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class DSA2 {
    private static int strLength(String str){
//        int count = 0;
//        try{
//            for (int i = 0; i < Integer.MAX_VALUE; i++){
//                str.charAt(i);
//                count++;
//            }
//            return count;
//        }
//        catch(Exception e){
//            return count;
//        }
        return (int) str.chars().count();
    }

    private static void removeDupes(Node node){
        Node copy = node;
        Node prev = null;
        HashMap<Integer, Integer> intFreq = new HashMap<>();

        while (copy != null){
            if (intFreq.containsKey(copy.getValue())){
                // we need to remove this node.
                prev.setNext(copy.getNext());
                copy = copy.getNext();
            }
            else{
                intFreq.put(copy.getValue(), 1);
                prev = copy;
                copy = copy.next;
            }
        }
    }

    public static void printLeafNodes(BinaryTree bt){
        Deque<BinaryTree> stack = new ArrayDeque<>();
        stack.push(bt);
        while (!stack.isEmpty()){
            BinaryTree top = stack.pop();
            if (top.getLeft() != null){
                stack.push(top.getLeft());
            }
            if (top.getRight() != null){
                stack.push(top.getRight());
            }
            if (top.getLeft() == null && top.getRight() == null){
                System.out.println("Leaf node found: " + top.getValue());
            }
        }
    }

    public static int findTargetIndex(int[] arr, int target){
        int startIdx = 0;
        int endIdx = arr.length - 1;
        int pivot, middle;
        while (startIdx <= endIdx){
            pivot = startIdx + (endIdx - startIdx) / 2;
            middle = arr[pivot];
            if (target == middle){
                return pivot;
            }
            else if (target > middle){
                startIdx = middle + 1;
            }
            else{
                endIdx = middle - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Input 'cat in the hat' has length: " + strLength("cat in the hat"));
        System.out.println();

        Node node = new Node(15, new Node(12, new Node(12, new Node(12, new Node(10)))));
        System.out.print("Before removing dupes: ");
        node.printAllConnected();
        System.out.print("After removing dupes: ");
        removeDupes(node);
        node.printAllConnected();
        System.out.println();

        BinaryTree start = new BinaryTree(10);
        start.insert(3);
        start.insert(2);
        start.insert(5);
        start.insert(12);
        System.out.print("BinaryTree: ");
        System.out.println(start);
        printLeafNodes(start);
        System.out.println();

        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 2, 4, 5};
        int[] arr3 = new int[]{1};
        System.out.print("Search in arr1: " + Arrays.toString(arr1));
        System.out.println(" || Target: 5 || Found at index: " + findTargetIndex(arr1, 5));

        System.out.print("Search in arr2: " + Arrays.toString(arr2));
        System.out.println(" || Target: 2 || Found at index: " + findTargetIndex(arr2, 2));

        System.out.print("Search in arr3: " + Arrays.toString(arr3));
        System.out.println(" || Target: 5 || Found at index: " + findTargetIndex(arr3, 5));
    }
}
