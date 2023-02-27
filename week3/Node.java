package week3;
public class Node {
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