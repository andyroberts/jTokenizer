package andyr.jtokenizer;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * The <code>SentenceTokenizer</code> class uses a <code>BreakIterator</code> to find each word
 * instance according to a specified locale. The
 * <p>
 * The following is one example of the use of the tokenizer. The code:
 * <blockquote><pre>
 *     SentenceTokenizer st = new SentenceTokenizer("Dr Pearson wasn't a physcian. She has a PhD. instead.");
 *     while (bit.hasMoreTokens()) {
 *         System.out.println(bit.nextToken());
 *     }
 * </pre></blockquote>
 * <p>
 * prints the following output:
 * <blockquote><pre>
 *     Dr Pearson wasn't a physcian.
 *     She has a PhD. instead.
 * </pre></blockquote>
 *
 * Now, the tokenizer isn't perfect as there are cases (albeit relatively rare) that will
 * confuse the algorithms used. For example, if we alter the above example and change "Dr"
 * to "Dr." with the period to signify the abbreviation.
 *
 * <blockquote><pre>
 *     SentenceTokenizer st = new SentenceTokenizer("Dr. Pearson wasn't a physcian. She has a PhD. instead.");
 *     while (bit.hasMoreTokens()) {
 *         System.out.println(bit.nextToken());
 *     }
 * </pre></blockquote>
 * <p>
 * prints the following output:
 * <blockquote><pre>
 *     Dr.
 *     Pearson wasn't a physcian.
 *     She has a PhD. instead.
 * </pre></blockquote>
 *
 * @author Andrew Roberts
 * @version 2.0 (16-Jul-2006)
 */


public class SentenceTokenizer extends Tokenizer {
    
    /**
     * Creates a <code>SentenceTokenizer</code> that tokenizes the input into
     * sentences according to a given locale. The segmentation algorithm is
     * dependent on the language being processed, so it is important to use the
     * correct locale.
     *
     * The "tokens" in this instance are actually the sentences themselves. So, a call
     * to <code>nextToken()</code> will actually return the next sentence, and not the
     * next word.
     *
     * @param input
     *            a string from which the tokens will be extracted.
     * @param locale
     *            the locale that the BreakIterator will use for finding sentence
     *            boundaries.
     */
    public SentenceTokenizer(String input, Locale locale) {
        
        super();
        
        BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(locale);
        
        sentenceIterator.setText(input);
        int start = sentenceIterator.first();
        int end = sentenceIterator.next();
        
        while (end != BreakIterator.DONE) {
            String sentence = input.substring(start, end).trim();
            tokens.add(sentence);
            start = end;
            end = sentenceIterator.next();
            
        }
        
    }
    
    /**
     * Creates a <code>SentenceTokenizer</code> that tokenizes the input into sentences. The tokenizer will use the default locale
     * as returned by <code>Locale.getDefault().</code>.
     *
     * @param input a string from which the tokens will be extracted.
     */
    public SentenceTokenizer(String input) {
        this(input, Locale.getDefault());
    }
    
}
