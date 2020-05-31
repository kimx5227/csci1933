public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private Boolean isSorted;

    public LinkedList(){
        head = new Node<T>(null);
        isSorted = true;
    }

    public Boolean getIsSorted(){return isSorted;} // delete later

    public boolean add(T element){
        Node<T> ptr = head;
        if (element != null){
            Node<T> newNode = new Node<T>(element);
            if (ptr == null){
                head.setNext(newNode);
            } else {
                while (ptr.getNext() != null){
                    ptr = ptr.getNext();
                }
                ptr.setNext(newNode);
            }
            isSorted = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean add(int index, T element){
        Node<T> ptr = head;
        Node<T> trailer = head;
        Node<T> newNode;

        if (element == null){return false;}
        if (index >= 0 && index < size()){
            if (size() == 0){
                newNode = new Node<T>(element, null);
                ptr.setNext(newNode);
            }
            int counter = 0;
            ptr = ptr.getNext();
            while (counter < index){
                ptr = ptr.getNext();
                trailer = trailer.getNext();
                counter ++;
            }
            newNode = new Node<T>(element, ptr);
            trailer.setNext(newNode);
        } else {
            return false;
        }
        isSorted = false;
        return true;
    }

    public void clear(){head.setNext(null);}

    public boolean contains(T element){
        return true;
    }

    public T get(int index){
        Node<T> ptr = head;
        T value = null;
        if (index >= 0 && index < size()){
            int counter = 0;
            ptr = ptr.getNext();
            while (counter < index){
                ptr = ptr.getNext();
                counter++;
            }
            value = ptr.getData();
        }
        return value;
    }

    public int indexOf(T element){
        return 0;
    }

    public boolean isEmpty(){
        if (head.getData() == null){
            return true;
        } else {
            return false;
        }
    }

    public int lastIndexOf(T element){
        return 0;
    }

    public T set(int index, T element){
        return null;
    }

    public int size(){
        Node<T> ptr = head;
        int count = 0;
        while (ptr.getNext() != null){
            ptr = ptr.getNext();
            count++;
        }
        return count;
    }

    public void sort(boolean order){

    }

    public boolean remove(T element){
        return true;
    }

    public T remove(int index){
        return null;
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

    public static void  main(String[] args){
        LinkedList<String> ls1 = new LinkedList<>();
        ls1.add("dog");
        ls1.add("cat");
        ls1.add("mouse");
        System.out.println(ls1);
    }
}
