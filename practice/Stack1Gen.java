
// Stack1Gen.java
// The StackGen Interface is implemented using a linked list
// The linked list used is a simple generic node class called NGen.  (See NGen.java)

public class Stack1Gen <T> implements StackGen <T> {

    // constructor

    public Stack1Gen () {}

    // selectors

    public void push(T o) {
        start = new NGen <T> (o, start);
    }

    public T pop() {
        if (start == null)
          throw new RuntimeException("Tried to pop an empty stack");
        else {
          T data = start.getData();
          start = start.getNext();
          return data;
        }
    }

    public T top() {
        if (start == null)
          return null;
        else return start.getData();
    }

    public boolean isEmpty() {
        if (start == null)
          return true;
        else return false;
    }

    public void push(T item, int n){
        if (n <= 0) {
            push(item);
        } else {
            T popped;
            Stack1Gen<T> tempStack = new Stack1Gen<T>();
            for (int i = 0; i < n; i++){
                if (isEmpty()){
                    break;
                }
                popped = pop();
                tempStack.push(popped);
            }
            push(item);
            for (int j = 0; j < n; j++){
                if (tempStack.isEmpty()){
                    break;
                }
                popped = tempStack.pop();
                push(popped);
            }
        }
    }

    public String toString(){
        NGen <T> node = start;
        String output = "";
        T data = null;
        if (node == null){
            return output;
        } else {
            while (node != null){
                data = node.getData();
                node = node.getNext();
                output = output + "\n" + data.toString();
            }
            return output;
        }
    }

    // instance variables

    private NGen <T> start = null;

    public static void main(String[] args){
        Stack1Gen stack = new Stack1Gen();
        stack.push("Cat");
        stack.push("dog");
        stack.push("rat");
        System.out.println(stack);
        stack.push("horse", 2);
        System.out.println();
        System.out.println(stack);
        System.out.println();
        stack.push("fish", 1);
        System.out.print(stack);
    }

}  // Stack1Gen class
