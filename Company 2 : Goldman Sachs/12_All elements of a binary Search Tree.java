
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();    
        inOrder(ans, root1);
        inOrder(ans, root2);
        Collections.sort(ans);
        return ans;
    }
    public void inOrder(List<Integer>ans, TreeNode a){
       if(a == null){
           return;
       }
       inOrder(ans, a.left);
       ans.add(a.val);
       inOrder(ans, a.right);
        
    }
}
