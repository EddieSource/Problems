import java.util.*; 
public class _0252_MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		return a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : 0; 
        	}
        }); 
        // if it is not monotonically increasing return false
        for(int i = 0; i < intervals.length - 1; i++) {
        	if(intervals[i][1] > intervals[i+1][0]) {
        		return false; 
        	}
        }
        return true; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
