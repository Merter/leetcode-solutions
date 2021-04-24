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
    public int read(final char[] buf, final int n) {
        int readChars = 0;
        do {
            final char[] buf4 = new char[4];
            final int read4Result = read4(buf4);
            for (int i=0; i<read4Result; i++) {
                if (readChars == n) {
                    // this case occurs when the file has more than n chars
                    return readChars;
                }
                buf[readChars++] = buf4[i];
            }
            if (read4Result < 4) {
                // eof
                break;
            }
        } while (true);
        return readChars;
    }
}
