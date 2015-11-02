package document;

import java.util.List;

/** 
 * A naive implementation of the Document abstract class. 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document 
{
	/** Create a new BasicDocument object
	 * 
	 * @param text The full text of the Document.
	 */
	public BasicDocument(String text)
	{
		super(text);
	}
	
	
	/**
	 * Get the number of words in the document.
	 * "Words" are defined as contiguous strings of alphabetic characters
	 * i.e. any upper or lower case characters a-z or A-Z
	 * 
	 * @return The number of words in the document.
	 */
	@Override
	public int getNumWords()
	{
		//TODO: Implement this method.  See the Module 1 support videos
	    // if you need help.
		List<String> tokens = getTokens("[a-zA-Z]+");
	    return tokens.size();
	}
	
	/**
	 * Get the number of sentences in the document.
	 * Sentences are defined as contiguous strings of characters ending in an 
	 * end of sentence punctuation (. ! or ?) or the last contiguous set of 
	 * characters in the document, even if they don't end with a punctuation mark.
	 * 
	 * @return The number of sentences in the document.
	 */
	@Override
	public int getNumSentences()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
        // if you need help.
		List<String> tokens = getTokens("[^!?.]+");
		return tokens.size();
	}
	
	/**
	 * Get the number of sentences in the document.
	 * Words are defined as above.  Syllables are defined as:
	 * a contiguous sequence of vowels, except for an "e" at the 
	 * end of a word if the word has another set of contiguous vowels, 
	 * makes up one syllable.   y is considered a vowel.
	 * @return The number of syllables in the document.
	 */
	@Override
	public int getNumSyllables()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
        // if you need help.
		List<String> words = getTokens("[a-zA-Z]+");
		int count = 0;
		for (String word : words){
			count = count + countSyllables(word);
		}
		return count;
	}
	
	
	/* The main method for testing this class. 
	 * You are encouraged to add your own tests.  */
	public static void main(String[] args)
	{
		testCase(new BasicDocument("This is a test.  How many???  "
		        + "Senteeeeeeeeeences double seque probo quinoa are here... there should be 5!  Right?"),
				23, 17, 5);
		testCase(new BasicDocument(""), 0, 0, 0);
		testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
		        + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
		testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
		testCase(new BasicDocument("redouble"), 2, 1, 1);

		testCase(new BasicDocument("the"), 1, 1, 1);

		testCase(new BasicDocument("Prologue"), 3, 1, 1);

		testCase(new BasicDocument("segue"), 2, 1, 1);

		testCase(new BasicDocument("double"), 1, 1, 1);

		testCase(new BasicDocument("dolor"), 2, 1, 1);

		testCase(new BasicDocument("sentence"), 2, 1, 1);

		testCase(new BasicDocument("sentences"), 3, 1, 1);

	}
	
}
