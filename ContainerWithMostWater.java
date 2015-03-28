// O(n) runtime, O(1) space
//use two pointers to approach, left and right pointers. 
//greedy algorithm

public class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        int res=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            res=Math.max(res,(r-l)*Math.min(height[r],height[l]));
            if(height[r]>height[l]){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}