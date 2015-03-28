//O(nlog(n)+n^2) =O(n^2) runtime, O(n) space 
//first sort the array, Arrays.sort(), is QuickSort, then use two pointers left and right

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num==null||num.length<3){
            return res;
        }
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i!=0&&num[i]==num[i-1])
                continue;
            int l=i+1;
            int r=num.length-1;
            while(l<r){
                if(num[l]+num[r]+num[i]==0){
                    List<Integer> temp=new ArrayList<Integer>();
                    temp.add(num[i]);
                    temp.add(num[l]);
                    temp.add(num[r]);
                    res.add(temp);
                    l++;
                    r--;
                    while(l<r&&num[l]==num[l-1])
                        l++;
                    while(l<r&&num[r]==num[r+1])
                        r--;
                }
                else if (num[l]+num[r]+num[i]>0){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return res;
    }
}