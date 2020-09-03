public class BTNode<T extends Comparable<T>>{
  private T data;
  private BTNode<T> left;
  private BTNode<T> right;

  public BTNode(T data){this.data = data;}

  public BTNode<T> getLeft() { return left; }
  public BTNode<T> getRight() { return right; }
  public T getData() { return data; }

  public void setLeft(BTNode<T> l) { left = l; }
  public void setRight(BTNode<T> r) { right = r; }
  public void setData(T d) { data = d; }

  public boolean equals(BTNode<T> o){
      boolean isEqualLeft = false;
      boolean isEqualRight = false;
      if (o != null && this.data.equals(o.getData())){
          if (this.getLeft() == null && o.getLeft() == null){
              if (this.getRight() == null && o.getRight() == null){
                  return true;
              }
          }
          if (this.getLeft() != null && o.getLeft() != null){
              isEqualLeft = this.getLeft().equals(o.getLeft());
          }
          if (this.getRight() != null && o.getRight() != null){
              isEqualRight = this.getRight().equals(o.getRight());
          }
          if (isEqualRight && isEqualLeft){return true;}
      }
      return false;
  } // your code here

  public static int countData(BTNode t){
      if (t == null){
          return 0;
      }
      else {
          return countData(t.getLeft()) + countData(t.getRight()) + 1;
      }
  }

  public static void main(String[] args){
      BTNode<Integer> t0 = new BTNode<Integer>(0);
      BTNode<Integer> t1 = new BTNode<Integer>(0);
      BTNode<Integer> t2 = new BTNode<Integer>(1);
      BTNode<Integer> t3 = new BTNode<Integer>(2);
      BTNode<Integer> t12 = new BTNode<Integer>(1);
      BTNode<Integer> t13 = new BTNode<Integer>(2);
      BTNode<Integer> t4 = new BTNode<Integer>(3);
      BTNode<Integer> t5 = new BTNode<Integer>(4);
      BTNode<Integer> t6 = new BTNode<Integer>(5);
      BTNode<Integer> t7 = new BTNode<Integer>(6);
      BTNode<Integer> t8 = new BTNode<Integer>(7);
      t0.setLeft(t2);
      t0.setRight(t3);
      t2.setLeft(t4);
      t2.setRight(t5);
      t3.setLeft(t6);
      t3.setRight(t7);
      t1.setRight(t13);
      t13.setRight(t8);
      t7.setRight(t7);
      System.out.println(t0.equals(t1));
  }
}
