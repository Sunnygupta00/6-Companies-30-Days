class Solution {
    List<Integer> result = new ArrayList<Integer>();
    int[] cache;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        cache = new int[nums.length];
        Arrays.fill(cache, -1);
        backtracking(nums, 0, new ArrayList<Integer>(), 1);
        return result;
    }
    
    private void backtracking(int[] nums, int index, ArrayList<Integer> curr, int prev){
        if (curr.size() > result.size())
            result = new ArrayList<Integer>(curr);
        
        for (int i = index; i < nums.length; i++){
            if (curr.size() > cache[i] && nums[i] % prev == 0){
                cache[i] = curr.size();
                curr.add(nums[i]);
                backtracking(nums, i+1, curr, nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
