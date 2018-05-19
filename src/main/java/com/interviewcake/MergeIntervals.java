package com.interviewcake;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	private static List<Interval> merge(List<Interval> intervals) {

		intervals.sort((Interval a, Interval b) -> a.start < b.start ? -1 : a.start == b.start ? 0 : 1);

		LinkedList<Interval> merged = new LinkedList<Interval>();

		int index = 0;
		for (int i = 0; i < intervals.size(); i++) {
			if (index != 0 && intervals.get(index - 1).start <= intervals.get(i).end) {
				while (index != 0 && intervals.get(index - 1).start <= intervals.get(i).end) {
					intervals.get(index - 1).end = Math.max(intervals.get(index - 1).end, intervals.get(i).end);
					intervals.get(index - 1).start = Math.max(intervals.get(index - 1).start, intervals.get(i).start);
					index--;
				}
			} else {
				intervals.set(index, intervals.get(i));
			}
			// // if the list of merged intervals is empty or if the current
			// // interval does not overlap with the previous, simply append it.
			// if (merged.isEmpty() || merged.getLast().end < interval.start) {
			// merged.add(interval);
			// }
			// // otherwise, there is overlap, so we merge the current and previous
			// // intervals.
			// else {
			// merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			// }
			index++;
		}

		return intervals;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));

		System.out.println("Interval merged = " + merge(intervals));

	}

	static class Interval {
		private int start;
		private int end;

		@Override
		public String toString() {
			return "start=" + start + ",end=" + end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

}
