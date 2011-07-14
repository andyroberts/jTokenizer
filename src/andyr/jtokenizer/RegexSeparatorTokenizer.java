package andyr.jtokenizer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The RegexSeparatorTokenizer class uses regular expressions to define the
 * separation between tokens. Whereas RegexTokenizer uses regular expressions to
 * define a "word" or token, RegexSeparator uses regular expressions to define
 * what <em>delimits</em> tokens. All matching is performed via Java's
 * <code>Pattern</code> and <code>Matcher</code> classes.
 * <p>
 * The following is one example of the use of the tokenizer, which refines the
 * token delimeter as one or more whitespace characters. The code:
 * <blockquote>
 * <pre>
 * RegexSeparatorTokenizer rest = new RegexSeparatorTokenizer(
 *         &quot;the cat sat on the mat&quot;, &quot;\\s+&quot;);
 * while (rest.hasMoreTokens()) {
 *     System.out.println(rest.nextToken());
 * }
 * </pre>
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
 * * It is also possible to keep the strings inbetween tokens should it be
 * necessary. By default these are discarded. For example, take
 * the string "abc123def456ghi" and the separator regular expression "\\d+" (one or more
 * digits):
 *
 * <blockquote>
 *
 * <pre>
 * RegexTokenizer ret = new RegexTokenizer(&quot;abc123def456ghi&quot;, &quot;\\d+&quot;);
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
 *      123
 *      def
 *      456
 *      ghi
 * </pre>
 *
 * </blockquote>
 *
 *
 * @author Andrew Roberts
 * @version 2.0 (16-Jul-2006)
 */


public class RegexSeparatorTokenizer extends Tokenizer {
    
    /**
     * Creates a <code>RegexSeparatorTokenizer</code> that tokenizes the input according a
     * regular expression that defines what separates "words" or tokens.
     *
     * @param input
     *            a string from which the tokens will be extracted.
     * @param regex
     *            the regular expression.
     * @param keepDelim
     *            flag indicating whether to return the delimiters as tokens.
     * @see java.util.regex.Pattern
     */
    public RegexSeparatorTokenizer(String input, String regex, boolean keepDelim) {
        
        super();
        
        // invert the regular expression
        String separatorRegex = "[^" + regex + "]+";
        
        if (keepDelim) {
            
            Pattern p = Pattern.compile(separatorRegex);
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
            
            Pattern p = Pattern.compile(separatorRegex);
            Matcher m = p.matcher(input);
            
            while (m.find()) {
                String tmp = "";
                tmp = input.substring(m.start(), m.end());
                tokens.add(tmp);
            }
        }
    }
    
    /**
     * Creates a <code>RegexSeparatorTokenizer</code> that tokenizes the input according a
     * regular expression that defines what separates "words" or tokens.
     *
     * @param input
     *            a string from which the tokens will be extracted.
     * @param regex
     *            the regular expression.
     * @see java.util.regex.Pattern
     */
    public RegexSeparatorTokenizer(String input, String regex) {
        
        this(input, regex, false);
        
    }
    
    /**
     * Creates a <code>RegexSeparatorTokenizer</code> that tokenizes the input. Default
     * separation regular expression is "\\s+" which defines one or more
     * whitespace characters as the token delimiter.
     *
     * @param input
     *            a string from which the tokens will be extracted.
     */
    public RegexSeparatorTokenizer(String input) {
        
        this(input, "\\s+");
    }
    
}
