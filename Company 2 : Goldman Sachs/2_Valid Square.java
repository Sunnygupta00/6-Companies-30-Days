class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
       HashSet<Integer> hs = new HashSet<>(Arrays.asList(dis(p1,p2), dis(p1,p3),dis(p1,p4), dis(p2, p3), dis(p2,p4), dis(p3, p4)));
       if(!hs.contains(0) && hs.size()==2)return true;
       return false;       
    }
    public int dis (int []a, int []b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}

// Time Complexity : constant time complexity
