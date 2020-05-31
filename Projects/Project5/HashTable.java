//Written by kimx5227
import java.lang.*;
import java.util.*;

public class HashTable<T>{

    private NGen[] table;
    private int items = 0;

    public HashTable(int size){
        table = new NGen[size];
    }

    private int hash(T key){


        //Below are some of the Hash Functions that I've tried to impliment
        //Each hash function is separatted by two space gap

        /*
        String keyStr = key.toString();
        char firstLetter = keyStr.charAt(0);
        int multiplier = 1;
        if (keyStr.length() == 1){
            return Math.abs(Character.getNumericValue(firstLetter)) * items;
        } else {
          char secondLetter = keyStr.charAt(1);
          if (Character.isUpperCase(firstLetter)){
              multiplier = 2;
          }
          if (keyStr.length() > 6){
            char fourthLetter = keyStr.charAt(3);
            int total = 0;
              for (int i = 0; i < keyStr.length(); i++){
                  total = total + Character.getNumericValue(keyStr.charAt(i));
              }
              return Math.abs(total);
          }
          if (keyStr.length() > 2){
              char thirdLetter = keyStr.charAt(2);
              return items * Math.abs((Character.getNumericValue(firstLetter) * Character.getNumericValue(thirdLetter))
              - (Character.getNumericValue(secondLetter) * Character.getNumericValue(keyStr.charAt(keyStr.length()-1))));
          }
          return  items * Math.abs(Character.getNumericValue(secondLetter) * Character.getNumericValue(firstLetter)) ;
        }


        /*
        String keyStr = key.toString();
        int charTotal = 0;
        char letter;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        boolean notVowel = false;

        for (int i = 0; i < keyStr.length(); i++){
            letter = keyStr.charAt(i);
            for (int j = 0; j < vowels.length; j++){
                if (letter == vowels[j]){
                    charTotal = charTotal + Character.getNumericValue(letter);
                    notVowel = true;
                }
            }
            if (notVowel)
                charTotal = charTotal + 2 * Character.getNumericValue(letter);
            notVowel = false;
        }
        return items * Math.abs(charTotal);*/


        /*
        String keyStr = key.toString();
        char firstLetter = keyStr.charAt(0);
        int charTotal = 0;
        for (int i = 0; i < keyStr.length(); i++){
            charTotal = charTotal + Character.getNumericValue(keyStr.charAt(i));
        }
        return items * Math.abs(charTotal);*/

        /*
        String keyStr = key.toString();
        char firstLetter = keyStr.charAt(0);
        if (keyStr.length() == 1){
            return Math.abs(Character.getNumericValue(firstLetter))* items;
        } else {
          char secondLetter = keyStr.charAt(1);
          if (keyStr.length() > 6){
            char fourthLetter = keyStr.charAt(3);
              return items * Math.abs(Character.getNumericValue(firstLetter) +
              (Character.getNumericValue(fourthLetter) + Character.getNumericValue(keyStr.charAt(keyStr.length()-1))));
          }
          if (keyStr.length() > 3){
              char thirdLetter = keyStr.charAt(2);
              return items * Math.abs(Character.getNumericValue(firstLetter) + Character.getNumericValue(thirdLetter)
              + (Character.getNumericValue(secondLetter) + Character.getNumericValue(keyStr.charAt(keyStr.length()-1))));
          }
          return  items * Math.abs(Character.getNumericValue(secondLetter) + Character.getNumericValue(firstLetter))+ 1 ;
        }*/


        /*
        String keyStr = key.toString();
        char firstLetter = keyStr.charAt(0);
        if (keyStr.length() == 1){
            return Math.abs((int) firstLetter);
        } else {
          char secondLetter = keyStr.charAt(1);
          if (keyStr.length() > 6){
            char thirdLetter = keyStr.charAt(2);
            char fifthLetter = keyStr.charAt(4);
              return Math.abs((int) firstLetter + (int)fifthLetter + (int) thirdLetter + (int) keyStr.charAt(keyStr.length()-1));
          }
          if (keyStr.length() > 3){
              char thirdLetter = keyStr.charAt(2);
              return Math.abs((int) firstLetter + (int)secondLetter + (int) thirdLetter + (int) keyStr.charAt(keyStr.length()-1));
          }
          return  Math.abs(Character.getNumericValue(secondLetter) * Character.getNumericValue(firstLetter)) ;
        }*/


        //Second Best Hash Function
        /*char firstLetter = keyStr.charAt(0);
        if (keyStr.length() == 1){
            return Math.abs((int)firstLetter);
        } else {
          char secondLetter = keyStr.charAt(1);

          //Block calculates integer for strings greater than OR equal to 7.
          //Moreover, it takes the first, fourth and last letter and returns int value (0-35)
          if (keyStr.length() > 4){
              int total = 0;
              for (int i = 0; i < keyStr.length(); i++){
                  if (i % 2 == 0)
                      total = total + (int)keyStr.charAt(i) ;
                  else total = total * (int)keyStr.charAt(i);
              }
              return Math.abs(total);
          }

          //Block calculates integer for strings greater than OR equal to 7.
          //Moreover, it takes the multiple of the integer values of the first and third,
          //as well as the multiple of the integer of the third and last letter and sums them together
          if (keyStr.length() > 2){
              char thirdLetter = keyStr.charAt(2);
              return Math.abs(((int)firstLetter)
              +  (int) keyStr.charAt(keyStr.length()-1) + (int) thirdLetter);
          }

          return Math.abs((int)firstLetter * (int)secondLetter);
        }*/


        //Best Hash Function
        String keyStr = key.toString();
        char firstLetter = keyStr.charAt(0);

        if (keyStr.length() == 1){
            return Math.abs((int)firstLetter);
        } else {
          char secondLetter = keyStr.charAt(1);

          //Block calculates integer for strings greater than OR equal to 7.
          //Moreover, it takes the first, fourth and last letter and returns unicode value
          if (keyStr.length() > 6){
              int total = 0;
              for (int i = 0; i < keyStr.length(); i++){
                  if (i % 2 == 0)
                      total = total + (int)keyStr.charAt(i);
                  else total = total * (int)keyStr.charAt(i);
              }
              return Math.abs(total);
          }

          //Block calculates unicode for strings greater than OR equal to 7.
          //Moreover, it takes the multiple of the unicode values of the first and third,
          //as well as the multiple of the unicode of the third and last letter and sums them together
          if (keyStr.length() > 2){
              char thirdLetter = keyStr.charAt(2);
              return Math.abs(((int)firstLetter)
              * (int) keyStr.charAt(keyStr.length()-1) * (int) secondLetter);
          }

          return Math.abs((int)firstLetter * (int)secondLetter);
        }
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
            //and compares its length to extreme lengths
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
