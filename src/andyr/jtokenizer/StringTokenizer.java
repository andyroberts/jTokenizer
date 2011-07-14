package andyr.jtokenizer;

/**
 * The StringTokenizer class uses a standard <code>StringTokenizer</code> to find each word in the input.
 * <p>
 * The following is one example of the use of the tokenizer. The code:
 * <blockquote><pre>
 *     StringTokenizer st = new StringTokenizer("the cat sat on the mat");
 *     while (st.hasMoreTokens()) {
 *         System.out.println(st.nextToken());
 *     }
 * </pre></blockquote>
 * <p>
 * prints the following output:
 * <blockquote><pre>
 *     the
 *     sat
 *     on
 *     the
 *     mat
 * </pre></blockquote>
 *
 * @author Andrew Roberts
 * @version 2.0 (16-Jul-2006)
 */


public class StringTokenizer extends Tokenizer {
    
    /**
     * Creates a <code>StringTokenizer</code> that tokenizes the input according the specified delimiter(s). Each character in <code>delim</code>
     * is considered a delimiter for separating tokens.
     *
     * If the <code>returnDelims</code> flag is true, then the delimiter characters are
     * also returned as tokens. Each delimiter is returned as a string of
     * length one. If the flag is <code>false</code>, the delimiter characters are
     * skipped and only serve as separators between tokens.
     *
     * Note that if <code>delim</code> is <code>null</code>, this constructor does not throw an
     * exception. However, trying to invoke other methods on the resulting
     * StringTokenizer may result in a <code>NullPointerException</code>.
     *
     * @param input a string from which the tokens will be extracted.
     * @param delim the delimiters
     * @param keepDelim flag indicating whether to return the delimiters as tokens.
     */
    public StringTokenizer(String input, String delim, boolean keepDelim) {
        super();
        
        java.util.StringTokenizer st = new java.util.StringTokenizer(input, delim,
                keepDelim);
        
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
    }
    
    /**
     * Creates a StringTokenizer that tokenizes the input according the specified delimiter(s). Each character in <code>delim</code>
     * is considered a delimiter for separating tokens. Delimiter characters themselves will not be treated as tokens.
     *
     * Note that if <code>delim</code> is <code>null</code>, this constructor does not throw an
     * exception. However, trying to invoke other methods on the resulting
     * StringTokenizer may result in a <code>NullPointerException</code>.
     *
     * @param input a string from which the tokens will be extracted.
     * @param delim the delimiters
     */
    
    public StringTokenizer(String input, String delim) {
        this(input, delim, false);
    }
    
    /**
     * Creates a StringTokenizer that tokenizes the input. The tokenizer
     * uses the default delimiter set, which is
     * <code>"&#92;t&#92;n&#92;r&#92;f"</code>: the space character, the
     * tab character, the newline character, the carriage-return character,
     * and the form-feed character. Delimiter characters themselves will
     * not be treated as tokens.
     *
     * @param input a string from which the tokens will be extracted.
     */
    public StringTokenizer(String input) {
        this(input, " \t\n\r\f", false);
    }
    
}
