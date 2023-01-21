class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums)sum+=i;
	    // basic logic
        if(sum%k != 0)return false;
	    // because repeatition is not allowed
        boolean vis[] = new boolean[nums.length];
        return rec(nums, k, sum/k, 0, 0, vis);
    }
    public boolean rec(int []nums, int k, int target, int index, int sum, boolean []vis){
          if(k == 0){
              return true;
          }
           if(sum == target){
		   // if we found one search for another one
               return rec(nums, k-1, target, 0, 0, vis);
           }
           for(int i=index;i<nums.length;i++){
              if (vis[i] || sum + nums[i] > target) continue;
              vis[i] = true;
              if(rec(nums, k, target, i+1, sum+nums[i], vis)){
                  return true;
              }
              vis[i] = false;
           }

           return false;
    }
}
