public class StackedQueueArray<T> {

    private Stack2 queue;

    public StackedQueueArray(){
        queue = new Stack2();
    }

    public void enqueue(T element){
        queue.push(element);
    }

    public Object dequeue(){
        if (!queue.isEmpty()){
            Stack2 tempQueue = new Stack2();
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
            Stack2 tempQueue = new Stack2();
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
        Stack2 tempQueue = new Stack2();
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
        StackedQueueArray<String> q1 = new StackedQueueArray<String>();
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
