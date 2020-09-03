public class IntBTNode {

    public IntBTNode(int d, IntBTNode l, IntBTNode r){
      data = d; left = l; right = r;
    }

    public int getData(){return data;}
    public IntBTNode getRight(){return right;}
    public IntBTNode getLeft(){return left;}
    public void setData(int d) {data = d;}
    public void setLeft(IntBTNode l){ left = l; }
    public void setRight(IntBTNode r) { right = r; }

    private int data;
    private IntBTNode left;
    private IntBTNode right;

    public static int leafSum(IntBTNode t){
        if (t != null){
            if (t.getLeft() == null & t.getRight() == null){
                return t.getData();
            }
            else {
                return leafSum(t.getLeft()) + leafSum(t.getRight());
            }
        }
        return 0;
    }

    public static void main(String[] args){
        IntBTNode tree = new IntBTNode(10, new IntBTNode(20, null, new IntBTNode(4, null, null)), new IntBTNode(200, null, null));
        System.out.println(leafSum(tree));
    }
}
