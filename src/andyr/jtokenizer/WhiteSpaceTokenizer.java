package andyr.jtokenizer;

import java.util.StringTokenizer;

/**
 * The WhiteSpaceTokenizer class a basic tokenizer that uses whitespace to separate tokens from the input string.
 * Whitespace characters are <code>"&#92;t&#92;n&#92;r&#92;f"</code>: the space character, the
 * tab character, the newline character, the carriage-return character,
 * and the form-feed character.
 * <p>
 * The following is one example of the use of the tokenizer. The code:
 * <blockquote><pre>
 *     WhiteSpaceTokenizer wst = new WhiteSpaceTokenizer("the cat sat on the mat");
 *     while (wst.hasMoreTokens()) {
 *         System.out.println(wst.nextToken());
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


public class WhiteSpaceTokenizer extends Tokenizer {
    
    //List tokens;
    //int currentTokenPosition = 0;
    
    /**
     * Creates a WhiteSpaceTokenizer that tokenizes the input. The tokenizer
     * uses the default delimiter set, which is
     * <code>"&#92;t&#92;n&#92;r&#92;f"</code>: the space character, the
     * tab character, the newline character, the carriage-return character,
     * and the form-feed character. Delimiter characters themselves will
     * not be treated as tokens.
     *
     * @param input a string from which the tokens will be extracted.
     */
    public WhiteSpaceTokenizer(String input) {
        
        super();
        
        StringTokenizer st = new StringTokenizer(input);
        
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
    }
    
}
