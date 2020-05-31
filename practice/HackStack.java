public class HackStack<T>{

    private Stack1 stack;
    private int size;

    public HackStack(){
      stack = new Stack1();
      size = 0;
    }

    public void push(T element){
        stack.push(element);
        size ++;
    }

    public T pop(){
        size --;
        return (T) stack.pop();
    }

    public T pop(int n){
      if (n < size){
        Stack1 temp = new Stack1();
        T popped;
        for (int i = 0; i < n - 1; i++){
            temp.push(stack.pop());
        }
        popped = (T) stack.pop();
        for (int i = 0; i < n - 1; i++){
            stack.push(temp.pop());
        }
        size --;
        return popped;
      } else return null;
    }

    public T peek(){
        return (T) stack.top();
    }

    public String toString(){
        String str = "";
        Stack1 tempStack = new Stack1();
        Object poppedElm;
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        while (!tempStack.isEmpty()){
            poppedElm = tempStack.pop();
            str = str + "\n" + poppedElm;
            stack.push(poppedElm);
        }
        return str;
    }

    public static void main(String[] args){
        HackStack<String> newStack = new HackStack<String>();
        newStack.push("A");
        newStack.push("B");
        newStack.push("C");
        System.out.println(newStack);
        System.out.println("");
        newStack.pop(2);
        System.out.println(newStack);
        System.out.println("");
        newStack.pop();
        System.out.println(newStack);
        System.out.println("");
    }
}
