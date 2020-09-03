public class Postfix{

    public static double evaluate(String[] expression)throws StackException{
        Stack<String> stack = new Stack();
        double num1;
        double num2;
        for (String token: expression){
                double total;
                if (token.equals("+")){
                    num1 = Double.parseDouble(stack.pop());
                    num2 = Double.parseDouble(stack.pop());
                    total = num1 + num2;
                    stack.push(Double.toString(total));
                } else if (token.equals("-")){
                    num1 = Double.parseDouble(stack.pop());
                    num2 = Double.parseDouble(stack.pop());
                    total = num2 - num1;
                    stack.push(Double.toString(total));
                } else if (token.equals("/")){
                    num1 = Double.parseDouble(stack.pop());
                    num2 = Double.parseDouble(stack.pop());
                    total = num2 / num1;
                    stack.push(Double.toString(total));
                } else if (token.equals("*")){
                    num1 = Double.parseDouble(stack.pop());
                    num2 = Double.parseDouble(stack.pop());
                    total = num1 * num2;
                    stack.push(Double.toString(total));
                } else {
                    stack.push(token);
                }
          }
          return Double.parseDouble(stack.pop());
      }

    public static void main(String[] args)throws StackException{
        String[] expression = new String[]{"1", "2","5","6", "7", "8", "+", "3", "4", "+", "/"};
        System.out.println("The expression is: (1 + 2 + 5 + 6 + 7 + 8) / (3 + 4)");
        try{
            evaluate(expression);
        } catch (StackException e){
            System.out.println("The size of the stack is:" + e.getSize());
        } finally { //evaluated when the try block exits; includes after any exceptions are caught
            System.out.println("Evaluation Complete");
        }
    }
}
