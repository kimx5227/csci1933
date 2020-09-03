public class BTNGen<T extends Comparable<T>> {  // constructor
    public BTNGen(T d, BTNGen<T> l, BTNGen<T> r)
    {        data = d;        left = l;        right = r;    }
      // getters and setters
      // selectors
      public BTNGen<T> getLeft()   { return left; }
      public BTNGen<T> getRight()  { return right; }
      public T getData()   { return data; }

      // modifiers
      public void setLeft(BTNGen<T> l)   { left = l; }
      public void setRight(BTNGen<T> r)  { right = r; }
      public void setData(T d)   { data = d; }

      // instance variables
      private T data;
      private BTNGen<T> left;
      private BTNGen<T> right;

      public static int countData(BTNGen t){
          if (t == null){
              return 0;
          }
          else {
              return countData(t.getLeft()) + countData(t.getRight()) + 1;
          }
      }

      public static BTNGen addLeft(BTNGen t, Object item){
          if (t.getLeft() == null){
              t.setLeft(new BTNGen((Comparable)item, null, null));
              return t;
          }
          addLeft(t.getLeft(), item);
          return t;
      }

      public void printPreorder(BTNGen<T> root){
          printPreorderHelper(root);
      }
      private void printPreorderHelper(BTNGen<T> node) {
        if (node == null)
            return;
        System.out.println(node.getData());
        printPreorderHelper(node.getLeft());
        printPreorderHelper(node.getRight());
      }

      public static void main(String[] args){
          BTNGen<Integer> t0 = new BTNGen<Integer>(0, new BTNGen<Integer>(1, null, new BTNGen<Integer>(3, null, null)), new BTNGen<Integer>(2, null, null));
          System.out.println(countData(t0));
          addLeft(t0, 5);
          t0.printPreorder(t0);
      }

      public int longestChain(){
          int longest = 0;
          int chainCount = 0;
          for (int i = 0; i < t.length; i++){
              if (t[i] != null){
                  NGen<T> ptr = t[i];
                  while (ptr != null){
                      ptr = ptr.getNext();
                      chainCount++;
                  }
                  if (chainCount > longest){
                      longest = chainCount;
                  }
                  chainCount = 0;
              }
          }
          return longest;
      }

}  // BTNGen.java
