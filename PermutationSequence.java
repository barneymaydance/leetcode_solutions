//O(n^2) runtime
//O(n) space
//k is indexed from 1.
// to decide each digit by dividing (n-1)!, get the index of the left number.
//permutations can be divided into n groups with (n - 1)! elements in each group


public class Solution {
    public String getPermutation(int n, int k) {
        if(n<=0){
            return "";
        }
        int[] factorial=new int[n];
        factorial[0]=1;
        for(int i=1;i<n;i++ ){
            factorial[i]=factorial[i-1]*i;
        }
        LinkedList nums=new LinkedList();
        for(int i=1;i<=n;i++){
            nums.add(i);
        }
        StringBuilder res= new StringBuilder();
        k--;
        for(int i=n;i>0;i--){
            int idx=k/factorial[i-1];
            k=k%factorial[i-1];
            res.append(nums.get(idx));
            nums.remove(idx);
        }
        return res.toString();
        
    }
}