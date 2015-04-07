//O(n) time
//O(n) space

public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0){
            return 0;
        }
        int[] candys = new int[ratings.length];
        candys[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candys[i]=candys[i-1]+1;
            }
            else{
                candys[i]=1;
            }
        }
        int res=candys[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--){
            int rightCandy=1;
            if(ratings[i]>ratings[i+1]){
                rightCandy=candys[i+1]+1;
            }
            res+=Math.max(candys[i],rightCandy);
            candys[i]=rightCandy;
        }
        return res;
    }
}