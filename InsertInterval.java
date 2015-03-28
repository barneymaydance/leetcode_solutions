//O(n) time
//O(n) space, O(1) extra

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        
        int insertPos=0;
        for(Interval inter:intervals){
            if(inter.end<newInterval.start){
                res.add(inter);
                insertPos++;
            }
            else if(inter.start>newInterval.end){
                res.add(inter);
            }
            else{
                newInterval.start=Math.min(newInterval.start,inter.start);
                newInterval.end=Math.max(newInterval.end,inter.end);
            }
        }
        res.add(insertPos,newInterval);
        return res;
        
    }
}