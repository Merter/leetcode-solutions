/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    private static final int EOF_MARKER = -1;
    private static final int INTERNAL_BUFFER_SIZE = 4;
    
    private final char[] bufferCache = new char[INTERNAL_BUFFER_SIZE];
    private int exclusiveCacheIndex = 0;
    private int exclusiveEofCacheIndex = EOF_MARKER;
    
    public int read(final char[] buf, final int n) {
        if (exclusiveEofCacheIndex != EOF_MARKER) {
            if (exclusiveCacheIndex == 0) {
                return 0;
            }
            final int readChars = Math.min(exclusiveEofCacheIndex-exclusiveCacheIndex, n);
            for (int i=0; i<readChars; i++) {
                buf[i] = bufferCache[exclusiveCacheIndex++];
            }
            return readChars;
        }
        if (exclusiveCacheIndex == 0) {
            // no buffer, so read directly from the file
            return readNToBufferStartingFrom(buf, n, 0);
        }
        // a buffer exists
        if (n+exclusiveCacheIndex <= INTERNAL_BUFFER_SIZE) {
            // no need to call read4(), buffer is enough
            for (int i=0; i<n; i++) {
                buf[i] = bufferCache[exclusiveCacheIndex++];
            }
            if (exclusiveCacheIndex == bufferCache.length) {
                // clear the bufferCache
                exclusiveCacheIndex = 0;
            }
            return n;
        }
        // buffer is not enough
        // first, consume the whole buffer
        int readChars = 0;
        final int remainingCharsInBuffer = INTERNAL_BUFFER_SIZE-exclusiveCacheIndex;
        while (readChars < remainingCharsInBuffer) {
            buf[readChars++] = bufferCache[exclusiveCacheIndex++];
        }
        // last, fill the remaining buffer from file
        return readNToBufferStartingFrom(buf, n, readChars);
    }
    
    private int readNToBufferStartingFrom(final char[] buf, final int n, final int offset) {
        int readCharsWithOffset = offset;
        int read4Result = 0;
        while (readCharsWithOffset < n) {
            exclusiveCacheIndex = 0;
            read4Result = read4(bufferCache);
            while (exclusiveCacheIndex < read4Result) {
                buf[readCharsWithOffset++] = bufferCache[exclusiveCacheIndex++];
                if (readCharsWithOffset == n) {
                    // the given buffer is full
                    break;
                }
            }
            if (read4Result < 4) {
                // eof
                exclusiveEofCacheIndex = read4Result;
                break;
            }
        }
        if (exclusiveCacheIndex == read4Result) {
            // clear the bufferCache
            exclusiveCacheIndex = 0;
        }
        return readCharsWithOffset;
    }
}
