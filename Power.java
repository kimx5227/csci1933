public class Power{

    public static int powerK(int k, int n){
        if (k == 1){
            return n;
        } else {
            return powerK(k-1, n) * n;
        }
    }

    public static void main(String[] args){
        System.out.println(powerK(2,3));
    }
}
