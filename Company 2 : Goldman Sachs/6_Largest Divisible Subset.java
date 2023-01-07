/*

Time Complexity : O(n) + O(n);

1)The right answer must satisfy two conditions:

2)the large rectangle area should be equal to the sum of small rectangles
count of all the points should be even, and that of all the four corner points should be one

*/


class Solution {
    public boolean isRectangleCover(int[][] rect) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = rect.length;
        int m = rect[0].length;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        HashSet <String> hs = new HashSet<>();
        int area = 0;
        for(int i=0;i<n;i++){
            int a = rect[i][0];
            int b = rect[i][1];
            int x = rect[i][2];
            int y = rect[i][3];
            x1 = Math.min(a, x1);
            y1 = Math.min(b, y1);
            x2 = Math.max(x, x2);
            y2 = Math.max(y, y2);
            area += (x-a)*(y-b);
            String pair1 = a+" "+b;
            String pair2 = x+" "+y;
            String pair3 = a+" "+y;
            String pair4 = x+" "+b;
            if(!hs.add(pair1))hs.remove(pair1);
            if(!hs.add(pair2))hs.remove(pair2);
            if(!hs.add(pair3))hs.remove(pair3);
            if(!hs.add(pair4))hs.remove(pair4);
        }
        int temp = (x2-x1)*(y2-y1);
        if( !hs.contains(x1+" "+y1) || !hs.contains(x2+" "+y2) || !hs.contains(x1+" "+y2) || !hs.contains(x2+" "+y1) || hs.size()!=4 )return false;

        return area == temp;
    }
}
