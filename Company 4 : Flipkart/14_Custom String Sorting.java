class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hs = new HashMap<>();
        for(char  a : s.toCharArray()){
            hs.put(a, hs.getOrDefault(a,0)+1);
        }
        StringBuilder sb = new StringBuilder();

       for(char a : order.toCharArray()){
           if(hs.containsKey(a)){
               int i = hs.get(a);
               while(i>0){
                   sb.append(a);  
                   i--;
               }
               hs.remove(a);
           }
       }
       hs.clear();
       for(char a : sb.toString().toCharArray()){
            hs.put(a, hs.getOrDefault(a,0)+1);
       }
       for(char a : s.toCharArray()){
           if(!hs.containsKey(a)){
               sb.append(a);
           }
       }
       return sb.toString();
        
    }
}


/// Same approach but in shorter version  --> time O(n) + O(26);
class Solution {
    public String customSortString(String order, String s) {
        int hs[] = new int[26];
        for(char a : s.toCharArray()){
            hs[a-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char a : order.toCharArray()){
            while(hs[a-'a']-->0){
                sb.append(a);
            }
        }
        for( char i ='a';i<='z';i++){
            while(hs[i-'a']-->0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
