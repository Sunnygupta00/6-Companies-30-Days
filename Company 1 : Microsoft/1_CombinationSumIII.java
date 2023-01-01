class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(ans, new ArrayList<>(), k, n, 0, 1);
        return ans;
    }
    public void rec (List<List<Integer>>ans, List<Integer> temp, int size, int sum, int currSum, int index){
        if(temp.size()>=size || currSum >= sum ){
            if(temp.size()==size && currSum == sum){
                ans.add(new ArrayList<>(temp) );
                return ;
            }else{
                return;
            }
        }
        for(int i =index;i<=9;i++){
            temp.add(i);
            rec(ans, temp, size, sum, currSum+i, i+1);
            temp.remove(temp.size()-1);
         }
    }
}
/*
Time Complexity : O(2^n) + O(2^n)
*/
