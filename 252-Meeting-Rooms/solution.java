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
    public boolean canAttendMeetings(Interval[] intervals) { 
        List<List<Integer>> list = new ArrayList<>();
        
        for(Interval interval : intervals) {
            list.add(Arrays.asList(interval.start, 0));
            list.add(Arrays.asList(interval.end, 1));
        }
        
        Collections.sort(list, new Comparator<List<Integer>>() {
            public int compare(List<Integer> l1, List<Integer> l2) {
                if(l1.get(0).equals(l2.get(0))) {
                    return l2.get(1) - l1.get(1);
                } else {
                    return l1.get(0) - l2.get(0);    
                }
            }
        });
        
        
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            
            if(list.get(i).get(1) == 0) 
                count++;
            else 
                count--;
            if(count > 1)
                return false;
        }
        return true;
    }
    
    public boolean canAttendMeetings2(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i+1].start)
                return false;
        }
        return true;
    }
}