package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 * @author yutian
 * @since Dec 27, 2015
 */
public class MeetingRooms {
	// Time O(nlogn) space O(n)
	public static boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null) return true;
//		Arrays.sort(intervals, new Comparator<Interval>(){
//			@Override
//			public int compare(Interval o1, Interval o2) {
//				return o1.start - o2.start;
//			}
//		});
		
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Interval[] t = new Interval[3];
		t[0] = new Interval(0, 30);
		t[1] = new Interval(5, 10);
		t[2] = new Interval(15, 20);

		System.out.println(canAttendMeetings(t));
	}

	public static class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
	}

}
