//runtime O(n) Space O(1)  consider two special cases,     (j-i) -(size-i)
//			a			g			m					nRows=4
//			b		f	h		l	n             
//			c	e		i	k
//			d			j

public class Solution {
    public String convert(String s, int nRows) {
        if(s==null||s.length()==0||nRows<=0){
            return "";
        }
        if(nRows==1){
            return s;
        }
        int size=2*nRows-2;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<nRows;i++){
            for(int j=i;j<s.length();j=j+size){
                if(i==0||i==nRows-1){
                    result.append(s.charAt(j));
                }
                else{
                    result.append(s.charAt(j));
                    if(j+size-2*i<s.length())
                        result.append(s.charAt(j+size-2*i));
                }
            }
        }
        return result.toString();
    }
}