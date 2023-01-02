class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int fun =0;
       for(int i=0;i<n;i++){
           sum+= nums[i];
           fun+= nums[i]*i;
       }
       int max = fun;
       int ptr = n-1;
       int function[] = new int[n];
       function[0] = fun;
       for(int i=1;i<n;i++){
          function[i] = function[i-1]+sum -(n*nums[ptr]);
          ptr--;
          max = Math.max(max, function[i]);
       }
      return max;
    }
}
// Time Complexity : O(n) + O(n)
// Simple Equation Based Solution
