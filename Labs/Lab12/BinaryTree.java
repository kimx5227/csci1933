public class BinaryTree<V extends Comparable<V>> {
    private Node<V> root;
    private int index = 0;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public Node<V> getRoot() {
        return this.root;
    }

    public void printInOrder() {
        printInOrderHelper(root);
    }
    private void printInOrderHelper(Node<V> node) {
        if (node == null)
            return;
        printInOrderHelper(node.getLeft());
        System.out.println(node.getValue());
        printInOrderHelper(node.getRight());
    }

    public void printPreorder(){
        printPreorderHelper(root);
    }
    private void printPreorderHelper(Node<V> node) {
      if (node == null)
          return;
      System.out.println(node.getValue());
      printPreorderHelper(node.getLeft());
      printPreorderHelper(node.getRight());
    }

    public void printPostorder() {
        printPostorderHelper(root);
    }
    private void printPostorderHelper(Node<V> node) {
        if (node == null)
            return;
        printPostorderHelper(node.getLeft());
        printPostorderHelper(node.getRight());
        System.out.println(node.getValue());
    }

    private int size(Node<V> node) {
      if (node == null)
          return 0;
      else
          return(size(node.getLeft()) + 1 + size(node.getRight()));
    }

    public V[] toArray() {
        V[] result = (V[]) new Comparable[size(root)];
        toArrayHelp(root, result);
        return result;
    }

    private void toArrayHelp(Node<V> ref, V[] result) {
        if (ref == null) {
            return;
        }
        result[index] = ref.getValue();
        index ++;
        toArrayHelp(ref.getLeft(), result);
        toArrayHelp(ref.getRight(), result);
    }

    public V[] flatten() {
        V[] arr = (V[]) toArray();
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j].compareTo(arr[j+1]) > 0)
                {
                    V temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public boolean isSubtree(Node<V> root1, Node<V> root2){
        if (root1 == null && root2 == null)
              return true;
          if (root1 == null || root2 == null)
              return false;
          return (root1.getValue() == root2.getValue()
                  && isSubtree(root1.getLeft(), root2.getLeft())
                  && isSubtree(root1.getRight(), root2.getRight()));
    }

    public boolean containsSubtree(BinaryTree<V> other) {
        if (other == null){
            return true;
        }
        if (isSubtree(root, other.getRoot()))
            return true;
        return isSubtree(root.getLeft(), other.getRoot())
                || isSubtree(root.getRight(), other.getRoot());

    }

    public static void main (String args[]) {
        // Tree given for testing on
        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
            new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)),
            new Node<Integer>(3, null, null)));

        // Milestone 1
        p1Tree.printInOrder();      // expected output: 4 2 5 1 3
        System.out.println();
        p1Tree.printPreorder();     // expected output: 1 2 4 5 3
        System.out.println();
        p1Tree.printPostorder();    // expected output: 4 5 2 3 1
        System.out.println();
        // Milestone 2 -- expected output: 1 2 3 4 5
        Comparable[] array_representation = p1Tree.flatten();
        for (int i = 0; i < array_representation.length; i++) {
            System.out.print(array_representation[i] + " ");
        }
        System.out.println();

        // Milestone 3
        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)));
        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2, null, null),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p4Tree = null;

        System.out.println(p1Tree.containsSubtree(p2Tree)); // expected output: true
        System.out.println(p1Tree.containsSubtree(p3Tree)); // expected output: false
        System.out.println(p1Tree.containsSubtree(p4Tree)); // expected output: true
    }
}
