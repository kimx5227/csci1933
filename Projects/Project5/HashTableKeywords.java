//Written by kimx5227
import java.lang.*;
import java.util.*;

public class HashTableKeywords<T>{

    private NGen[] table;
    private int items = 0;

    public HashTableKeywords(int size){table = new NGen[size];}

    private int hash(T key){
        String keyStr = (String) key;
        char firstLetter = keyStr.charAt(0);
        char secondLetter = keyStr.charAt(1);

        //multiplies values of the second and first letter plus last letter
        //(.getNumericValue() takes values 0 - 35, where 0-9 is the associated numerical values,
        //10-35 is the in-order alphabetical values, and any special character is 35.
        if (keyStr.length() > 6){
            return (Character.getNumericValue(secondLetter) * Character.getNumericValue(firstLetter)) + Character.getNumericValue(keyStr.charAt(keyStr.length()-1));
        }
        //adds second and first letter plus 2 subtracted by last letter
        if (keyStr.length() == 4){
            return (Character.getNumericValue(secondLetter) + Character.getNumericValue(firstLetter)) - Character.getNumericValue(keyStr.charAt(keyStr.length()-1)) + 2;
        }
        //multiplies first and thirdLetter plus the second times last
        if (keyStr.length() > 2){
            char thirdLetter = keyStr.charAt(2);
            return (Character.getNumericValue(firstLetter) * (Character.getNumericValue(thirdLetter))) + (Character.getNumericValue(secondLetter) * Character.getNumericValue(keyStr.charAt(keyStr.length()-1))) ;
        }
        return Character.getNumericValue(firstLetter) * Character.getNumericValue(secondLetter);
    }

    private void addList(T element, int pos){
        NGen<T> ptr = table[pos];
        T data = null;
        boolean inList = false;

        //checks chain to make sure there is no duplicate,
        //otherwise it adds item to end of the chain
        while (ptr.getNext() != null){
            ptr = ptr.getNext();
            data = ptr.getData();
            if (data.equals(element)){
                inList = true;
                break;
            }
        }
        if (!inList ) {
            NGen<T> newNode = new NGen<T>(element, null);
            ptr.setNext(newNode);
        }
    }

    //impliments hash function and creates start of chain or adds to existing chain
    public void add(T item){
        if (item != null){
            int pos = hash(item) % table.length;
            if (table[pos] == null) {table[pos] = new NGen<T>(null,null);}
            addList(item, pos);
            items ++;
        }
    }

    private int chainLength(int pos){
        NGen<T> ptr = table[pos];
        int length = 0;
        while (ptr.getNext() != null){
            ptr = ptr.getNext();
            length++;
        }
        return length;
    }

    //findMedian function from geeksforgeeks.org
    //Link Accessed 5/2/2020: https://www.geeksforgeeks.org/median/
    public static double findMedian(int a[], int n){
       // First we sort the array
       Arrays.sort(a);

       // check for even case
       if (n % 2 != 0)
           return (double)a[n / 2];

       return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
     }

    public void display(){
        int largestChain, smallestChain, indexLength, emptyChains, averageChain, median;
        int[] chainLength = new int[table.length];

        largestChain = smallestChain = emptyChains = averageChain = median = 0;
        for (int i = 0; i < table.length; i++){

          //case where table is empty
            if (table[i] == null) {
                emptyChains ++;
                chainLength[i] = 0;
                continue;
            }
            //else block calculates the chain Length, adds it to the average,
            //prints the chain, and compares its length to extreme lengths
            else {
              indexLength = chainLength(i);
              averageChain = averageChain + indexLength;
            }
            System.out.println("Index Position: " + i + ", Chain Length: " + indexLength);
            printChain(i);
            chainLength[i] = indexLength;
            if (indexLength > largestChain){largestChain = indexLength;}
            if (smallestChain == 0 && indexLength > 0) {smallestChain = indexLength;}
            else if (indexLength < smallestChain && indexLength > 0) {smallestChain = indexLength;}
        }
        System.out.println("Largest Chain: " + largestChain + ", Smallest Chain: " + smallestChain);
        System.out.println();
        System.out.println("Total amount of items in HashTable: " + items);
        System.out.println();
        System.out.println("# of Empty Chains out of " + table.length + " total chains: " + emptyChains);
        System.out.println();
        System.out.println("Average Length of Chain: " + averageChain / table.length);
        System.out.println();
        System.out.println("The median chain is: " + findMedian(chainLength, table.length));
    }

    private void printChain(int pos){
        NGen<T> ptr = table[pos];
        String chain = "";

        //iterates through chian and adds to output string until it reaches null
        while (ptr.getNext() != null){
            ptr = ptr.getNext();
            if (ptr.getNext() == null){
                chain = chain + ptr.getData();
            } else {
                chain = chain + ptr.getData() + " -> ";
            }
        }
        System.out.println("Chain from start to finish:");
        System.out.println(chain);
        System.out.println();
    }
}
