// Third Question
class Solution {
    public String getHint(String secret, String guess) {
       int hs[] = new int[10];
       
        for(char c : secret.toCharArray()){
            hs[c-'0']++;
        }

        int bull= 0;
        int cows =0;
        for(int i=0;i<secret.length();i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a == b){
                 bull++;
                hs[a-'0']--;
            }   
        }
        for(int i=0;i<secret.length();i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if(a != b && hs[b-'0'] !=0){
                 cows++;
                hs[b-'0']--;
            }   
        }
        return new String(bull+"A"+cows+"B");
    }
}

// Time Complexity : O(2n) + O(1)
