public class StackedQueueNode<T>{

    private Stack1 queue;

    public StackedQueueNode(){queue = new Stack1();}

    public void enqueue(T element){
        queue.push(element);
    }

    public Object dequeue(){
        if (!queue.isEmpty()){
            Stack1 tempQueue = new Stack1();
            Object poppedElm;
            while (!queue.isEmpty()){
                tempQueue.push(queue.pop());
            }
            poppedElm = tempQueue.pop();
            while (!tempQueue.isEmpty()){
                queue.push(tempQueue.pop());
            }
            return poppedElm;
        } else throw new RuntimeException("Tried to pop an empty stack");
    }

    public Object peek(){
        if (queue.isEmpty()){
            return null;
        } else {
            Stack1 tempQueue = new Stack1();
            Object peekElm;
            while (!queue.isEmpty()){
                tempQueue.push(queue.pop());
            }
            peekElm = tempQueue.top();
            while (!tempQueue.isEmpty()){
                queue.push(tempQueue.pop());
            }
            return peekElm;
        }
    }

    public boolean isEmpty(){return queue.isEmpty();}

    public String toString(){
        String str = "";
        Stack1 tempQueue = new Stack1();
        Object poppedElm;
        while (!queue.isEmpty()){
            tempQueue.push(queue.pop());
        }
        while (!tempQueue.isEmpty()){
            poppedElm = tempQueue.pop();
            str = str + "\n" + poppedElm;
            queue.push(poppedElm);
        }
        return str;
    }

    public static void main(String[] args){
        StackedQueueNode<String> q1 = new StackedQueueNode<String>();
        System.out.println(q1.isEmpty());
        q1.enqueue("1");
        q1.enqueue("2");
        q1.enqueue("3");
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
        System.out.println("");
        System.out.println(q1.peek());
    }
}
