//pretty prints array separated by comma
public class IntArray {

        public static void main(String[] args){
                int[] numbers;
                numbers = new int[3];
                numbers[0] = 42;
                numbers[1] = 17;
                numbers[2] = 256;
                printValuesinList( numbers );
        }
        static void printValuesinList(int[] list){
              System.out.print('[');
              int i;
              for ( i = 0; i < list.length; i++){
                  if ( i > 0)
                      System.out.print(',');
                  System.out.print(list[i]);
              }
              System.out.println(']');
        }
}
