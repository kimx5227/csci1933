//Written by kimx5227
public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head; //LinkedList is a headed list
    private boolean isSorted;
    private int size;

    public LinkedList(){
        head = new Node<T>(null);
        isSorted = true;
        size = 0;
    }


    public boolean add(T element){
        Node<T> ptr = head;   //used to find end of list and add node, if non-empty
        if (element != null){
            Node<T> newNode = new Node<T>(element);
            if (ptr == null){ //if list is empty adds node to head
                head.setNext(newNode);
            } else {
                while (ptr.getNext() != null){ //iterates through list until it reaches the last node
                    ptr = ptr.getNext();
                }
                ptr.setNext(newNode);
            }
            isSorted = false;
            size ++;
            return true;
        } else {
            return false;
        }
    }

    public boolean add(int index, T element){
        Node<T> ptr = head.getNext();     //ptr keeps track node ahead of added, if any
        Node<T> trailer = head; //Keeps track of previous node, so it can point to added node
        Node<T> newNode; //added node

        if (element == null){return false;}
        if (index >= 0 && index < size){
            if (size == 0){ //case: list is empty
                newNode = new Node<T>(element, null);
                ptr.setNext(newNode);
            }
            int counter = 0;
            while (counter < index){
                ptr = ptr.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            newNode = new Node<T>(element, ptr);  //Instantiates node so the previous and next nodes
            trailer.setNext(newNode);             //are between the added node.
        } else {
            return false;
        }
        isSorted = false;
        size ++;
        return true;
    }

    public void clear(){
        head.setNext(null);
        size = 0;
    }

    public boolean contains(T element){
        int nodeIndex = 0;
        Node<T> ptr = head.getNext();
        T value = null; //keeps track of data of node

        while (nodeIndex < size){
            value = ptr.getData();
            if (value.equals(element)){
                return true;
            }
            ptr = ptr.getNext();
            nodeIndex ++;
        }
        return false;
    }

    //iterates through the list to find data at node, if index is valid
    public T get(int index){
        Node<T> ptr = head.getNext();
        if (index >= 0 && index < size){
            int counter = 0;
            while (counter < index){
                ptr = ptr.getNext();
                counter++;
            }
            return ptr.getData();
        } else {
            return null;
        }
    }

    //if element is valid, it iterates until it finds the index of the element
    //else it returns -1
    public int indexOf(T element){
        int counter = 0;
        Node<T> ptr = head.getNext();
        T value = null;
        if (element != null){
            while (counter < size){
                value = ptr.getData();
                if (value.equals(element)){
                    return counter;
                }
                ptr = ptr.getNext();
                counter ++;
            }
            return -1;
        } else {
            return -1;
        }
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        } else {
            return false;
        }
    }

    //iterates through entire list and returns last instance of element, if any
    public int lastIndexOf(T element){
        if (element != null){
            Node<T> ptr = head;
            int lastIndex = -1;
            int counter = 0;
            T nodeData = null;
            while (counter < size){
                ptr = ptr.getNext();
                nodeData = ptr.getData();
                if (nodeData.equals(element)){
                    lastIndex = counter;
                }
                counter ++;
            }
            return lastIndex;
        } else {
            return -1;
        }
    }

    //finds the index and replaces it accordingly
    public T set(int index, T element){
        Node<T> setNode = head;
        Node<T> trailer = head;
        Node<T> newNode;
        T lastValue;

        if (element == null){return null;}
        if (index >= 0 && index < size){
            int counter = 0;
            setNode = setNode.getNext();
            while (counter < index){
                setNode = setNode.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            lastValue = setNode.getData();
            setNode = setNode.getNext();
            newNode = new Node<T>(element, setNode);
            trailer.setNext(newNode);
            isSorted = false;
            return lastValue;
        } else {
            return null;
        }
    }

    public int size(){return size;}

    //uses bubble sort to sort the list in order desired
    public void sort(boolean order){
        if (order == true) {
            if (isSorted != true){

                //tempNode allows us to swap the previous and next nodes so that
                //the list can iterate correctly, compareNode and nextNode are neighbor nodes
                //that are compared to each other, and trailerNode keeps track of the nodes
                //behind the compared ones so if they are swapped, they can be ordered correctly.
                Node<T> tempNode, compareNode, nextNode, trailerNode;
                T compareData, nextData;

                compareNode = trailerNode = tempNode = head;
                nextNode = head.getNext();
                for (int i = 0; i < size - 1; i++){
                    for (int j = 0; j < size - i - 1; j++){
                        compareNode = nextNode;
                        nextNode = nextNode.getNext();
                        compareData = compareNode.getData();
                        nextData = nextNode.getData();
                        if (compareData.compareTo(nextData) > 0){ //swaps neighbor nodes in correct order
                            compareNode.setNext(nextNode.getNext());
                            nextNode.setNext(compareNode);
                            trailerNode.setNext(nextNode);
                            tempNode = nextNode; //since nodes are swapped, position in comparison must be swapped
                            nextNode = compareNode;
                            compareNode = tempNode;
                        }
                        trailerNode = trailerNode.getNext();
                    }
                    compareNode = trailerNode = head; //resets nodes at start;
                    nextNode = head.getNext();
                }
                isSorted = true;
            }
        } else {
            //same as first conditional except it swaps in reverse order
            Node<T> tempNode, compareNode, nextNode, trailerNode;
            T compareData, nextData;

            compareNode = trailerNode = tempNode = head;
            nextNode = head.getNext();
            for (int i = 0; i < size - 1; i++){
                for (int j = 0; j < size - i - 1; j++){
                    compareNode = nextNode;
                    nextNode = nextNode.getNext();
                    compareData = compareNode.getData();
                    nextData = nextNode.getData();
                    if (compareData.compareTo(nextData) < 0){ //swaps in reverse order
                        compareNode.setNext(nextNode.getNext());
                        nextNode.setNext(compareNode);
                        trailerNode.setNext(nextNode);
                        tempNode = nextNode;
                        nextNode = compareNode;
                        compareNode = tempNode;
                    }
                    trailerNode = trailerNode.getNext();
                }
                compareNode = trailerNode = head;
                nextNode = head.getNext();
            }
        }
    }

    //iterates until it finds the element and sets previous node's next pointer
    //to the node after the removed node, if any
    public boolean remove(T element){
        if (element == null){
            return false;
        } else {
            int counter = 0;
            Node<T> trailer = head;
            Node<T> nextNode = head.getNext();
            T remove;

            while (counter < size){
                remove = nextNode.getData();
                if (remove.equals(element)){
                    nextNode = nextNode.getNext();
                    trailer.setNext(nextNode);
                    size--;
                    return true;
                }
                nextNode = nextNode.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            return false;
        }
    }

    //Iterates until it finds the index and sets previous index to next node
    //after removed index.
    public T remove(int index){
        Node<T> nextNode = head;
        Node<T> trailer = head;
        T removedValue = null;

        if (index >= 0 && index < size){
            int counter = 0;
            nextNode = nextNode.getNext();
            while (counter < index){
                nextNode = nextNode.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            removedValue = nextNode.getData();
            nextNode = nextNode.getNext();
            trailer.setNext(nextNode);
            size --;
            return removedValue;
        } else {
            return removedValue;
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
                if (node == null){
                    output = output + data.toString(); //if last element, don't add newline character
                } else {
                    output = output + data.toString() + "\n";
                }
            }
            return output;
        }
    }

    public void removeEvery(int n){
        if (n != 0  && n < size()){
            Node<T> ptr = head.getNext();
            Node<T> trailer = head;
            int counter = 1;
            while (ptr != null){
                ptr = ptr.getNext();
                if (counter == n){
                    trailer.setNext(ptr);
                    counter = 1;
                } else {
                    trailer = trailer.getNext();
                    counter ++;
                }
            }
        }
    }

    public LinkedList<LinkedList<T>> extractGroupsOf(int n){
        if (n > 0){
            LinkedList<LinkedList<T>> ls= new LinkedList<LinkedList<T>>();
            LinkedList<T> linkedls = new LinkedList<T>();
            Node<T> ptr = head.getNext();
            int counter = 1;
            while (ptr != null){
                linkedls.add(ptr.getData());
                ptr = ptr.getNext();
                if (counter == n){
                    ls.add(linkedls);
                    linkedls = new LinkedList<T>();
                    counter = 1;
                } else {
                    counter ++;
                }
            }
            if (counter != 1){
                ls.add(linkedls);
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args){
      LinkedList<LinkedList<String>> ls = new LinkedList<LinkedList<String>>();
      LinkedList<String> arr= new LinkedList<String>();
      arr.add("A");
      arr.add("B");
      arr.add("C");
      arr.add("D");
      arr.add("E");
      ls = arr.extractGroupsOf(2);
      System.out.println(ls);
    }

}
