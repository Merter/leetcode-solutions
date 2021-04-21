class Solution {
    
    private static class Interval implements Comparable<Interval> {
        
        private int begin;
        private int end;
        
        public Interval(final int begin, final int end) {
            this.begin = begin;
            this.end = end;
        }        
        
        public Interval(final int[] range) {
            begin = range[0];
            end = range[1];
        }
        
        public int compareTo(final Interval other) {
            if (this.begin == other.begin) {
                if (this.end == other.end) {
                    return 0;
                }
                return this.end<other.end ? -1 : 1;
            }
            return this.begin<other.begin ? -1 : 1;
        }
        
        public int[] toArray() {
            return new int[]{begin, end};
        }
        
        public Interval overlap(final Interval other) {
            if (begin<=other.begin && other.begin<=end) {
                return new Interval(begin, Math.max(end, other.end));
            }
            if (begin<=other.end && other.end<=end) {
                return new Interval(Math.min(begin, other.begin), end);
            }
            return null;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        final List<Interval> sortedIntervals = new ArrayList<>(intervals.length);
        for (final int[] range : intervals) {
            sortedIntervals.add(new Interval(range));
        }
        Collections.sort(sortedIntervals);
        Interval prev = sortedIntervals.get(0);
        List<Interval> mergedIntervals = new ArrayList<>(intervals.length);
        for (int i=1; i<intervals.length; i++) {
            final Interval curr = sortedIntervals.get(i);
            final Interval mergedInterval = prev.overlap(curr);
            if (mergedInterval == null) {
                mergedIntervals.add(prev);
                prev = curr;
            } else {
                prev = mergedInterval;
            }
        }
        mergedIntervals.add(prev);
        final int[][] mergedRanges = new int[mergedIntervals.size()][2];
        int i = 0;
        for (final Interval mergedInterval : mergedIntervals) {
            mergedRanges[i++] = mergedInterval.toArray();
        }
        return mergedRanges;
    }
}
