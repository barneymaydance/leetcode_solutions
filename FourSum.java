// O(n^3) runtime, O(1) space 
// this solution is not the best solution. it can be better using binary search

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(num==null||num.length<4){
            return res;
        }
        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
            if((i!=0)&&num[i]==num[i-1])
                    continue;
            for(int j=i+1;j<num.length-2;j++){
                if((j!=i+1)&&num[j]==num[j-1])
                    continue;
                int l=j+1;
                int r=num.length-1;
                while(l<r){
                    int sum=num[i]+num[j]+num[l]+num[r];
                    if(sum==target){
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[l]);
                        temp.add(num[r]);
                        res.add(temp);
                        l++;
                        r--;
                        while(l<r&&num[l]==num[l-1]){
                            l++;
                        }
                        while(l<r&&num[r]==num[r+1]){
                            r--;
                        }
                    }
                    else if (target>sum){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return res;
        
    }
}