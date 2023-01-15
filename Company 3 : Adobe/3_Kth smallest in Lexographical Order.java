
public class Solution {
    int countNum(int n){
        int i=0;
        while(n>0){
            n/=10;
            i++;
        }
        return i;
    }
    int getFullTreeNum(int depth){
        int sum=0, children=1;
        while(depth>0){
            sum+=children;
            children*=10;
            depth--;
        }
        return sum;
    }
    int getMax(int prefix, int depth){
        while(depth>0){
            prefix*=10;
            prefix+=9;
            depth--;
        }
        return prefix;
    }
    int getMin(int prefix, int depth){
        while(depth>0){
            prefix*=10;
            depth--;
        }
        return prefix;
    }
    int helper(int n, int k, int prefix, int depth){
        int lowNum=getFullTreeNum(depth), highNum=getFullTreeNum(depth-1);
        for(int i=(prefix==0?1:0);i<=9;i++){
            int nodeNum=0;
            if(getMax(prefix*10+i, depth-1)<=n){
                nodeNum=lowNum;
            }
            else if(getMin(prefix*10+i, depth-1)>n){
                nodeNum=highNum;
            }
            else{
                nodeNum=highNum+((n-getMin(prefix*10+i, depth-1))+1);
            }
            k-=nodeNum;
            if(k<=0){
                k+=nodeNum;
                if(k==1){
                    return prefix*10+i;
                }
                else {
                    return helper(n, k-1, prefix*10+i, depth-1);
                }
            }
        }
        return 0;
    }
    
    public int findKthNumber(int n, int k) {
        int depth=countNum(n);
        int index=0;
        return helper(n, k, 0, depth);
    }
}
