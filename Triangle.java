//O(n^2) time
//O(n) space
//bottom to up
public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.size() == 0)
        return 0;
    int[] res = new int[triangle.size()];
    for(int i=0;i<triangle.size();i++)
    {
        res[i] = triangle.get(triangle.size()-1).get(i);
    }
    for(int i=triangle.size()-2;i>=0;i--)
    {
        for(int j=0;j<=i;j++)
        {
            res[j] = Math.min(res[j],res[j+1])+triangle.get(i).get(j); 
        }
    }
    return res[0];
}





//O(n^2) time
//O(n) space
//use top to bottom recursive method, use dynamic programming, use a array to store the min path sum
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        int[] sum=new int[triangle.size()];
        sum[0]=triangle.get(0).get(0);
        for(int j=1;j<triangle.size();j++){
            int num=triangle.get(j).size();
            for(int i=num-1;i>=0;i--){
                if(i==0){
                    sum[i]=triangle.get(j).get(i)+sum[i];
                }
                else if(i==num-1){
                    sum[i]=triangle.get(j).get(i)+sum[i-1];
                }
                else{
                    sum[i]=triangle.get(j).get(i)+Math.min(sum[i],sum[i-1]);
                }
            }
        }
        int min=sum[0];
        for(int i=0;i<sum.length;i++){
            if(sum[i]<min)
                min=sum[i];
        }
        return min; 
    }
}