//O(2^n) runtime?
//O(n) space
//NP-complete problem
//java function pass primitive type by value ,  pass class type by reference

public class Solution {
    public int totalNQueens(int n) {
        List<Integer> res= new ArrayList<Integer>();
        res.add(0);
        if(n<=0){
            return 0;
        }
        helper(n,0,new int[n],res);
        return res.get(0);
        
    }
    private void helper(int n,int row, int[] coloumIndexRow,List<Integer> res){
        if(n==row){
            res.set(0,res.get(0)+1);
            return;
            
        }
        
        for(int i=0;i<n;i++){
            coloumIndexRow[row]=i;
            if(isValid(row,coloumIndexRow)){
                helper(n,row+1,coloumIndexRow,res);
            }        
        }
    }
    
    private boolean isValid(int row,int[] coloumIndexRow){
        for(int i=0;i<row;i++){
            if((coloumIndexRow[i]==coloumIndexRow[row])||(Math.abs((coloumIndexRow[i]-coloumIndexRow[row]))==row-i)){
                return false;
            }
        }
        return true;
    }
}