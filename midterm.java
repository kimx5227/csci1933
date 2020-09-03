public static int highCount(int[][] a){

    int highest = 0;
    for (int row = 0; row < a.length; row++){
        for (int col = 0; col < a.length; col++){
            if (a[col][row] > highest){
                highest = a[col][row];
            }
        }
    }
    return highest;
}

public IntNode makeList(int n){
    if (n < 1){
        return null;
    } else {
        IntNode ls = new IntNode(1, null);
        IntNode ptr = ls;
        for (int i = 2; i < n + 1; i++){
            ptr.setNext(new IntNode(i,null));
            ptr.getNext();
        }
        return ls;
    }
}

public void pushLow(T item){

    if (isEmpty()){
        push(item);
    } else {
        T poppedItem;
        MyStack<T> tempStack = new MyStack<T>();
        while (!isEmpty()){
            poppedItem = pop();
            tempStack.push(poppedItem);
        }
        push(item);
        while (!tempStack.isEmpty()){
            poppedItem = tempStack.pop();
            push(poppedItem);
        }
    }
}
