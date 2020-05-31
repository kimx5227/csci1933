public class QueuedStack<T>{

    private Q2Gen stack;

    public QueuedStack(){stack = new Q2Gen();}

    public void push(T element){
        Q2Gen newStack = new Q2Gen<T>();
        newStack.add(element);
        while (stack.length() != 0)
            newStack.add(stack.remove());
        stack = newStack;
    }

    public Object pop(){
      if (stack != null)
          return stack.remove();
      else return null;
    }

    public Object top(){
        if (stack != null){
          Q2Gen newStack = new Q2Gen<T>();
          Object top = stack.remove();
          newStack.add(top);
          while (stack.length() != 0)
              newStack.add(stack.remove());
          stack = newStack;
          return top;
        } else {
            return null;
        }
    }

    public boolean isEmpty(){
        if (stack.length() == 0){
            return true;
        } else return false;
    }

    public String toString(){
        String str = "";
        Object elem;
        Q2Gen newStack = new Q2Gen<T>();
        while (stack.length() != 0){
            elem = stack.remove();
            str = elem + "\n" + str;
            newStack.add(elem);
        }
        stack = newStack;
        return str;
    }

    public static void main(String[] args){
        QueuedStack<String> stack = new QueuedStack<String>();
        System.out.println(stack.isEmpty());
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println("");
        System.out.println(stack.top());
        System.out.println("");
        System.out.println(stack);
    }
}
