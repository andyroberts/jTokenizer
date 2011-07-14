package andyr.jtokenizer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The RegexTokenizer class uses regular expressions to define a word, and
 * tokenizes according to that expression. All matching is performed via Java's
 * <code>Pattern</code> and <code>Matcher</code> classes.
 * <p>
 * The following is one example of the use of the tokenizer. The code:
 * <blockquote>
 *
 * <pre>
 * RegexTokenizer ret = new RegexTokenizer(&quot;the cat sat on the mat&quot;, &quot;\\w+&quot;);
 * while (ret.hasMoreTokens()) {
 *     System.out.println(ret.nextToken());
 * }
 * </pre>
 *
 * </blockquote>
 * <p>
 * prints the following output: <blockquote>
 *
 * <pre>
 *      the
 *      sat
 *      on
 *      the
 *      mat
 * </pre>
 *
 * </blockquote>
 *
 * It is also possible to keep the strings inbetween tokens should it be
 * necessary. By default these are discarded. Note, it won't keep anything
 * before the first match or anything after the last match. For example, take
 * the string "123abc456def789" and the regular expression "\\D+" (one or more
 * non-digits):
 *
 * <blockquote>
 *
 * <pre>
 * RegexTokenizer ret = new RegexTokenizer(&quot;123abc456def789&quot;, &quot;\\D+&quot;);
 * while (ret.hasMoreTokens()) {
 *     System.out.println(ret.nextToken());
 * }
 * </pre>
 *
 * </blockquote>
 * <p>
 * prints the following output: <blockquote>
 *
 * <pre>
 *      abc
 *      456
 *      def
 * </pre>
 *
 * </blockquote>
 *
 * @author Andrew Roberts
 * @version 2.0 (16-Jul-2006)
 */


public class RegexTokenizer extends Tokenizer {
    
    /**
     * Creates a <code>RegexTokenizer</code> that tokenizes the input
     * according a regular expression that defines a "word" or token. If
     * <code>keepDelit</code> is true then all the strings in between the tokens
     * are kept as tokens too.
     * @param input
     *            a string from which the tokens will be extracted.
     * @param regex
     *            the regular expression.
     * @param keepDelim
     *            flag indicating whether to return the delimiters as tokens.
     * @see java.util.regex.Pattern
     */
    public RegexTokenizer(String input, String regex, boolean keepDelim) {
        
        super();
        
        if (keepDelim) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            
            int end = -1;
            while (m.find()) {
                String tmp = "";
                if (end >= 0) {
                    tmp = input.substring(end, m.start());
                    tokens.add(tmp);
                }
                
                tmp = input.substring(m.start(), m.end());
                tokens.add(tmp);
                end = m.end();
            }
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            
            while (m.find()) {
                String tmp = "";
                tmp = input.substring(m.start(), m.end());
                tokens.add(tmp);
            }
        }
    }
    
    /**
     * Creates a <code>RegexTokenizer</code> that tokenizes the input
     * according a regular expression that defines a "word" or token.
     *
     * @param input
     *            a string from which the tokens will be extracted.
     * @param regex
     *            the regular expression.
     * @see java.util.regex.Pattern
     */
    public RegexTokenizer(String input, String regex) {
        
        this(input, regex, false);
        
    }
    
    /**
     * Creates a <code>RegexTokenizer</code> that tokenizes the input.
     *
     * @param input a string from which the tokens will be extracted.
     */
    public RegexTokenizer(String input) {
        
        this(input, "\\S+");
    }
    
}
