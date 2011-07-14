package andyr.jtokenizer;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * The BreakIteratorTokenizer class uses a <code>BreakIterator</code> to find each word
 * instance according to a specified locale.
 * <p>
 * The following is one example of the use of the tokenizer. The code:
 * <blockquote><pre>
 *     BreakIteratorTokenizer bit = new BreakIteratorTokenizer("the cat sat on the mat");
 *     while (bit.hasMoreTokens()) {
 *         System.out.println(bit.nextToken());
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


public class BreakIteratorTokenizer extends Tokenizer {
    
    /**
     * Creates a BreakIteratorTokenizer that tokenizes the input according to a given locale.
     *
     * @param input a string from which the tokens will be extracted.
     * @param locale the locale that the BreakIterator will use for finding word instances.
     */
    public BreakIteratorTokenizer(String input, Locale locale) {
        
        super();
        
        BreakIterator wordIterator = BreakIterator.getWordInstance(locale);
        
            wordIterator.setText(input);
        int start = wordIterator.first();
        int end = wordIterator.next();
        
        while (end != BreakIterator.DONE) {
            String word = input.substring(start,end);
            if (Character.isLetterOrDigit(word.charAt(0))) {
                tokens.add(word);
            }
            
            start = end;
            end = wordIterator.next();
            
        }
        
    }
    
    /**
     * Creates a BreakIteratorTokenizer that tokenizes the input. The BreakIterator will use the default locale
     * as returned by <code>Locale.getDefault()</code>.
     *
     * @param input a string from which the tokens will be extracted.
     */
    public BreakIteratorTokenizer(String input) {
        this(input, Locale.getDefault());
    }
    
}
