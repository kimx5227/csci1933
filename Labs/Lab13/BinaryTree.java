import java.util.Arrays;
import java.lang.Math;
public class BinaryTree {

    public static boolean isValid(int[] arr) {
        if (arr[0] == -1){
            int k = 1;
            while (Math.pow(2,k) < arr.length){
                k++;
            }
            if (Math.pow(2,k) == arr.length){
                int root = arr[1];
                for (int i = 1; i < Math.pow(2,k - 1); i++){
                    if (i == 1){
                        if (arr[2] > arr[i]){
                          return false;
                        }
                        if (arr[3] < arr[i]){
                            return false;
                        }
                        continue;
                    }
                    if (arr[i] > root){
                        if (arr[2*i] > arr[i] || arr[2*i] <= root){
                            return false;
                        }
                        if (arr[2*i + 1] < arr[i] || arr[2*i + 1] <= root){
                            return false;
                        }
                    } else {
                          if (arr[2*i] > arr[i] || arr[2*i] > root){
                              return false;
                          }
                          if (arr[2*i + 1] < arr[i] || arr[2*i + 1] > root){
                              return false;
                          }
                    }
                }
                return true;
            } else return false;
        } else return false;
    }

    public static void main (String args[]) {
      // milestone 1
      int[] arr1 = new int[]{-1,7,4,10,3,6,8,15};
      int[] arr2 = new int[]{-1,20,12,32,5,18,25,38};
      int[] arr3 = new int[]{-1,11,3,33,2,8,10,44};
      int[] arr4 = new int[]{-1,55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};

      System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
      System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
      System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
      System.out.println("arr4 valid: " + isValid(arr4));  // expected: false
    }
}
