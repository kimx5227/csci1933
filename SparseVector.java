public class SparseVector {

	private Node head;
	private int length;

	public SparseVector(int len){
		head = null;
		length = len;
	}

	public int getLength(){return length;}
	public Node getHead(){return head;}

	// Prints out a sparse vector (including zeros)
	public String toString(){

		String result = "";
		Node currNode = head;
		int currIndex = 0;
		while( currNode != null ){
			int idx = currNode.getIndex();

			// Pad the space between nodes with zero
			while( currIndex < idx ){
				result += "0, ";
				currIndex++;
			}
			result += currNode;
			currNode = currNode.getNext();
			currIndex++;

			// Only add a comma if this isn't the last element
			if( currNode != null ){ result += ", "; }
		}
		return result;
	}

	// TODO: Implement me for milestone 1
	public void addElement(int index, double value){
		Node ptr, newNode, trailer;

			if (index < length && index > -1){
					newNode = new Node(index, value);
					if (head == null){
							head = newNode;
					} else if (head.getNext() == null){
							head.setNext(newNode);
					} else {
							trailer = head;
							ptr = head.getNext();
							while (ptr != null){
									trailer = ptr;
									ptr = ptr.getNext();
							}
							if (trailer.getIndex() > index){
								System.out.println(index + " isn't a vaild index");
							} else{
									trailer.setNext(newNode);
							}
					}
			} else {
					System.out.println(index + " isn't a valid index");
			}
	}

 // TODO: Implement me for milestone 2
	public static double dot( SparseVector x, SparseVector y ){
		double result = 0.0;
		Node xNode,yNode;
		if (x.getLength() == y.getLength()){
				if (x.getHead() != null & y.getHead()!= null){
						xNode = x.getHead();
						yNode = y.getHead();
						while (xNode != null & yNode != null){
								if (xNode.getIndex() == yNode.getIndex()){
										result = result + xNode.getValue() * yNode.getValue();
										xNode = xNode.getNext();
										yNode = yNode.getNext();
								} else if (xNode.getIndex() > yNode.getIndex()){
										yNode = yNode.getNext();
								} else {
										xNode = xNode.getNext();
								}
						}
						return result;
				} else {
						return 0.0;
				}
		}
		return 0.0;
	}

	/*public void removeElement(int index){

	}*/

	// TODO: Test out your code here!
	public static void main(String[] args) {
		SparseVector vec = new SparseVector(6);
		vec.addElement(0, 10.0);
		vec.addElement(3, -1.1);
		vec.addElement(5, 32.0);
		System.out.println(vec);
		System.out.println("Since we assume that the node is added for increasingly larger");
		System.out.println("indices, the 1st and 10th indexes won't be added to the list");
		vec.addElement(1, 1.0);
		vec.addElement(10, 2.0);
		System.out.println(vec);
		SparseVector x = new SparseVector(100000000);
		x.addElement(0, 1.0);
		x.addElement(10000000, 3.0);
		x.addElement(10000001, -2.0);
		SparseVector y = new SparseVector(100000000);
		y.addElement(0, 2.0);
		y.addElement(10000001, -4.0);
		double result = dot(x, y);
		System.out.println("x dot y is "+ result);
		SparseVector a = new SparseVector(3);
		a.addElement(0, 1.0);
		a.addElement(1, 3.0);
		a.addElement(2, -2.0);
		SparseVector b = new SparseVector(2);
		b.addElement(0, 1.0);
		b.addElement(1, 3.0);
		SparseVector c = new SparseVector(3);
		result = dot(a,b);
		System.out.println("a dot b is " + result);
		result = dot(a,c);
		System.out.println("a dot b is " + result);
	}
}
