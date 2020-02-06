public class Arrays {
        public static void main(String[] args){
                int[] list = new int[3];
                int[] newlist;
                list[1] = 17;
                newlist = list; //changes the object in the heap s.t. list and newlist point to same array
                newlist[1] = 42;
                System.out.println(list);
                System.out.println(newlist); //both are the same array
        }
}
