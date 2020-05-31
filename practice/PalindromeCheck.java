public class PalindromeCheck{

    public static boolean palindromeTest(String word){
        Q2Gen forward = new Q2Gen();
        Q2Gen backwards = new Q2Gen();
        for (int i = 0; i < word.length(); i++){
            forward.add(word.charAt(i));
            backwards.add(word.charAt(word.length()-i-1));
        }
        for (int i = 0; i < word.length(); i++){
            if (!forward.remove().equals(backwards.remove())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(palindromeTest("racecar"));
        System.out.println(palindromeTest("scooter"));
    }

}
