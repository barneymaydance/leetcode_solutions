//O(nlog(n)) runtime
//O(1) extra space
// first merge sort the intervals by the start, then merge the intervals one by one

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 // use a anonymous  comparator class, use the method  int compart()
 // use the Collections.sort() method
 public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval> ();
        if(intervals==null||intervals.size()==0){
            return res;
        }
        Comparator <Interval> comp=new Comparator<Interval>(){
            public int compare(Interval inter1,Interval inter2){
                if(inter1.start==inter2.start){
                    return inter1.end-inter2.end;
                }
                return inter1.start-inter2.start;
            }
        };
        Collections.sort(intervals,comp);
        Interval prev=intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start>prev.end){
                res.add(prev);
                prev=intervals.get(i);
            }
            else{
                int prevEnd=intervals.get(i).end>prev.end?intervals.get(i).end:prev.end;
                prev=new Interval(prev.start,prevEnd);
            }
        }
        res.add(prev);
        return res;
    }
}

//implement the merge sort 
//
 
 
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval> (intervals);
        if(intervals==null||intervals.size()==0){
            return res;
        }
        sortByStart(intervals,res,0,intervals.size()-1);
        Interval prev=intervals.get(0);
        res.clear();
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start>prev.end){
                res.add(prev);
                prev=intervals.get(i);
            }
            else{
                int prevEnd=intervals.get(i).end>prev.end?intervals.get(i).end:prev.end;
                prev=new Interval(prev.start,prevEnd);
            }
        }
        res.add(prev);
        return res;
        
    }
    
    private void sortByStart(List<Interval> intervals,List<Interval>temp, int left, int right){
        if(left==right){
            return;
        }
        int mid=(right+left)/2;
        sortByStart(intervals,temp,left,mid);
        sortByStart(intervals,temp,mid+1,right);
        mergeList(intervals,temp,left,mid,right);
    }
    
    private void mergeList(List<Interval> intervals,List<Interval>temp, int left,int leftEnd, int rightEnd){
        int right=leftEnd+1;
        int k=left;
        int num=rightEnd-left+1;
        while(left<=leftEnd&&right<=rightEnd){
            if(intervals.get(left).start<intervals.get(right).start){
                int s=intervals.get(left).start;
                int e=intervals.get(left).end;
                temp.set(k,new Interval(s,e));
                k++;
                left++;
            }
            else{
                int s=intervals.get(right).start;
                int e=intervals.get(right).end;
                temp.set(k,new Interval(s,e));
                k++;
                right++;
            }
        }
        while(left<=leftEnd){
            int s=intervals.get(left).start;
            int e=intervals.get(left).end;
            temp.set(k,new Interval(s,e));
            left++;
            k++;
        }
        while(right<=rightEnd){
            int s=intervals.get(right).start;
            int e=intervals.get(right).end;
            temp.set(k,new Interval(s,e));
            right++;
            k++;
        }
        for(int i=0;i<num;i++,rightEnd--){
            intervals.set(rightEnd,temp.get(rightEnd));
        }
    }
}
