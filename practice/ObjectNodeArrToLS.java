// ObjectNode.java
// Similar to IntNode.java except ObjectNode.java uses
// a more general Object data in place of int data
// This implementation allows mixed type data in a
// linked list of ObjectNode, something like Python lists
// March 2019

public class ObjectNodeArrToLS {

    private Object data;
    private ObjectNode next;

    public ObjectNodeArrToLS() {}  // default constructor

    public ObjectNodeArrToLS(Object data, ObjectNode next) {
        this.data = data;
        this.next = next;
    }

    // accessor methods

    public Object getData() {
        return data;
    }

    public ObjectNode getNext() {
        return next;
    }

    public void setData(Object value) {
        data = value;
    }

    public void setNext(ObjectNodeArrToLS ptr) {
        next = ptr;
    }

    public boolean equals(Object anotherObject) {
        // returns true iff both fields of
        // the corresponding nodes are ==

        if (anotherObject instanceof ObjectNode) {
          ObjectNodeArrToLS temp = (ObjectNodeArrToLS) anotherObject;
          if (data == temp.getData() &&
              next == temp.getNext())
            return true;
        }
        return false;
    }

    public String toString() {
        return data.toString();
    }

    public static ObjectNodeArrToLS arrayToList(Object[] a){
        if (a.length > 0){
            ObjectNodeArrToLS linkedLs = new ObjectNodeArrToLS(a[0], null);
            ObjectNodeArrToLS ptr = linkedLs;
            ObjectNodeArrToLS node;
            for (int i = 1; i < a.length; i++){
                node = new ObjectNodeArrToLS(a[i], null);
                ptr.setNext(node);
                ptr = ptr.getNext();
            }
            return linkedLs;
        } else return null;
    }

    public static void main(String[] args) {
        node = new ObjectNodeArrToLS()
    }  // main

}  // ObjectNode
