package andyr.jtokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <code>Tokenizer</code> is an abstract base class for a variety of <code>Tokenizer</code>s.
 *
 * @author Andrew Roberts
 * @version 2.0 (16-Jul-2006)
 *
 */
public abstract class Tokenizer {
    
    protected List tokens;
    protected int currentTokenPosition = 0;
    
    protected Tokenizer() {
        tokens = new ArrayList();
    }
    
    /**
     * Calculates the number of times that this tokenizer's
     * <code>nextToken</code> method can be called before it generates an
     * exception.
     *
     * @return the number of tokens remaining in the string.
     */
    public int countTokens() {
        return tokens.size() - currentTokenPosition;
    }
    
    /**
     * Returns the total number of tokens that were extracted when tokenizing the input.
     *
     * @return the number of tokens in the string
     */
    public int numberOfTokens() {
        return tokens.size();
    }
    
    /**
     * Tests if there are more tokens available from this tokenizer's string.
     * If this method returns <code>true</code>, then a subsequent call to
     * <code>nextToken</code> will successfully return a token.
     *
     * @return <code>true</code> if and only if there is at least one token in the string
     * after the current position; <code>false</code> otherwise.
     */
    public boolean hasMoreTokens() {
        
        return currentTokenPosition < tokens.size();
    }
    
    /**
     * Returns the next token from this tokenizer.
     *
     * @return the next token from this tokenizer.
     * @throws NoSuchElementException if there are no more tokens in this tokenizer's string.
     */
    public String nextToken() throws NoSuchElementException {
        
        if (hasMoreTokens()) {
            String tempToken = (String)tokens.get(currentTokenPosition);
            currentTokenPosition++;
            
            return tempToken;
        } else {
            throw new NoSuchElementException();
        }
    }
    
    /**
     * Returns a <code>List</code> of string tokens.
     *
     * @return a <code>List</code> of string tokens.
     */
    public List getTokens() {
        
        return tokens;
    }
    
}
