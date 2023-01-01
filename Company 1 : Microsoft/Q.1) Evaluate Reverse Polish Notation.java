class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String>stack = new Stack <>();
         int ans =Integer.valueOf(tokens[0]);
        for(String s : tokens){
            if(s.equals("+")){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                ans = a+b;
                stack.push(Integer.toString(ans));
            }else if(s.equals("-")){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                ans = a-b;
                  stack.push(Integer.toString(ans));
            }else if(s.equals("*")){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                ans = a*b;
                  stack.push(Integer.toString(ans));
            }else if(s.equals("/")){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                ans = a/b;
                  stack.push(Integer.toString(ans));
            }else{
                stack.push(s);
            }
        }
        return ans;
    }
}
/* TimeComplexity
 O(n) + O(n) */
