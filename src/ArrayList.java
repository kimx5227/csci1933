//Written by kimx5227
public class ArrayList<T extends Comparable<T>> implements List<T> {

    private T[] ls;
    private boolean isSorted;
    private int size;

    public ArrayList(){
        ls = (T[]) new Comparable[2];
        isSorted = true;
        size = 0;
    }

    //resizes array to double the length of previous array and copies it over
    //to new array
    private void resize(){
        T[] newLs = (T[]) new Comparable[2*ls.length];
        for (int i = 0; i < size; i++){
            newLs[i] = ls[i];
        }
        ls = newLs;
    }

    //adds to end of list if list has spots to be filled
    public boolean add(T element){
        if (element != null){
            if (size == ls.length){//resizes array if full
                resize();
            }
            ls[size] = element;
            isSorted = false;
            size ++;
            return true;
        } else {
            return false;
        }
    }

    public boolean add(int index, T element){
        if (element != null){
            if (index >= 0 && index < size) {
                if (size == ls.length){//resizes array if full
                    resize();
                }
                for (int i = size; i > index; i--){
                    ls[i] = ls[i - 1]; // shifts elements ahead of index forward one position
                }
                ls[index] = element;
                isSorted = false;
                size ++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public void clear(){
        ls = (T[]) new Comparable[2];
        size = 0;
    }

    public boolean contains(T element){
        if (element != null){
            for (int i = 0; i < size; i++){
                if (ls[i].equals(element)){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    public T get(int index){
        if (index >= 0 && index < size){
            return ls[index];
        } else {
            return null;
        }
    }


    public int indexOf(T element){
        if (element != null){
            for (int i = 0; i < size; i++){
                if (ls[i].equals(element)){
                    return i;
                }
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


    public int lastIndexOf(T element){
        int lastIndex = -1; //keeps track of index of last element
        if (element != null){
            for (int i = 0; i < size; i++){
                if (ls[i].equals(element)){
                    lastIndex = i;
                }
            }
            return lastIndex;
        } else {
            return lastIndex;
        }
    }


    public T set(int index, T element){
        if (element != null){
            if (index >= 0 && index < size) {
                T value = ls[index];
                ls[index] = element;
                return value;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public int size(){return size;}

    //use bubble sort to sort the array accordingly
    public void sort(boolean order){
        T temp; //allows us to swap the indexes accordingly

        if (order == true) {
            if (isSorted != true){
                for (int i = 0; i < size - 1; i++){
                    for (int j = 0; j < size - i - 1; j++){
                        if (ls[j].compareTo(ls[j + 1]) > 0){
                            temp = ls[j + 1]; //swaps data at indices
                            ls[j + 1] = ls[j];
                            ls[j] = temp;
                        }
                    }
                }
                isSorted = true;
            }
        } else {
            for (int i = 0; i < size - 1; i++){
                for (int j = 0; j < size - i - 1; j++){
                    if (ls[j].compareTo(ls[j + 1]) < 0){
                        temp = ls[j + 1];
                        ls[j + 1] = ls[j];
                        ls[j] = temp;
                    }
                }
            }
        }
    }

    public boolean remove(T element){
        T value;
        if (element != null){
            for (int i = 0; i < size; i++){
                if (ls[i].equals(element)){
                    for (int j = i; j < size-1; j++){
                        ls[j] = ls[j + 1]; //shifts all elements ahead of index down 1 position
                    }
                    ls[size - 1] = null;
                    size --;
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }


    public T remove(int index){
        if (index >= 0 && index < size){
            T value = ls[index];
            for (int i = index; i < size - 1; i++){
                ls[i] = ls[i + 1]; //shifts all element ahead of index down 1 position
            }
            ls[size - 1] = null;
            size --;
            return value;
        } else {
            return null;
        }
    }


    public String toString(){
        String str = "";
        for (int i = 0; i < size - 1; i++ ){
            str = str + ls[i] + "\n";
        }
        str = str + ls[size - 1]; //last line doesn't get newline character
        return str;
    }


}
