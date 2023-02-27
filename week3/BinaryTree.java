package week3;

public class BinaryTree {
    private final int value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(int value){
        BinaryTree nextNode = this;
        BinaryTree prev;
        do{
            prev = nextNode;
            nextNode = nextNode.findNextNodeDirection(value);
        } while(nextNode != null);

        if (value > prev.getValue()){

            prev.setRight(value);
        }
        else{
            prev.setLeft(value);
        }
    }
    public int getValue(){
        return this.value;
    }

    public BinaryTree getLeft(){
        return this.left;
    }

    public BinaryTree getRight(){
        return this.right;
    }

    public void setRight(int value){
        this.right = new BinaryTree(value);
    }

    public void setLeft(int value){
        this.left = new BinaryTree(value);
    }

    private BinaryTree findNextNodeDirection(int value){
        return value > this.value ? right : left;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}