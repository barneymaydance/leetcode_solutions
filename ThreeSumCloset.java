//similar to 3sum
//O(nlog(n)+n^2) =O(n^2) runtime, O(n) space 
//first sort the array, Arrays.sort(), is QuickSort, then use two pointers left and right

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if (num==null||num.length<3){
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int res=0;
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<num.length-2;i++){
            int l=i+1;
            int r=num.length-1;
            while(l<r){
                int sum=num[i]+num[l]+num[r];
                if(sum==target)
                    return target;
                else if(sum>target){
                    r--;
                }
                else{
                    l++;
                }
                if(Math.abs(sum-target)<diff){
                        res=sum;
                        diff=Math.abs(sum-target);
                    }
            }
        }
        return res;
        
    }
}