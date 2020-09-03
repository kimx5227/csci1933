public class Stack<T extends Comparable<T>>{

    private Node<T> head;
    private int size;

    public Stack(){
        size = 5;
        head = new Node<T>(null);
    }

    public Stack(int size){
        this.size = size;
        head = new Node<T>(null);
    }

    public T pop(){
        if (size > 0 && head.getNext() != null){
            Node<T> popNode, nextNode;
            popNode = head.getNext();
            nextNode = popNode.getNext();
            head.setNext(nextNode);
            return popNode.getData();
        } else {
            return null;
        }
    }

    public void push(T item){
        try {
                Node<T> ptr = head;
                Node<T> nextNode;
                int elements = 0;
                while (ptr.getNext() != null){
                    ptr = ptr.getNext();
                    elements ++;
                }
                if (elements == size){
                    throw new StackException(size);
                } else {
                    nextNode = head.getNext();
                    head.setNext(new Node(item,nextNode));
                }
        } catch (StackException e){
            System.out.println("The Stack is full.");
            throw new StackException(size);
        }
    }

    public String toString(){
        Node<T> node = head;
        String output = "";
        T data = null;
        if (node.getNext() == null){
            return output;
        } else {
            node = head.getNext();
            while (node != null){
                data = node.getData();
                node = node.getNext();
                output = output + "\n" + data.toString();
            }
            return output;
        }
    }

    public static void main(String[] args){
        Stack<String> stack = new Stack(3);
        stack.push("Cat");
        stack.push("dog");
        stack.push("rat");
        stack.push("dog");
        stack.push("rat");
        stack.push("dog");
        stack.push("rat");
    }
}
