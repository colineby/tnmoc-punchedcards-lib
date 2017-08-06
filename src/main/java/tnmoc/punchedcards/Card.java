package tnmoc.punchedcards;

/**
 * Interface to describe a card image.  Implementing classes will reprent different format 
 * as well as the data in the image.
 * @author Colin Eby <colin.eby.uk@gmail.com>
 * @since 6 August 2017
 * @version 0.0
 *
 */
public interface  Card {
	
	/**
	 * Get a table of the card data. The table is a bit encoded punched pattern. 
	 * Each short in the array represents one column of punches, numbered from top
	 * to bottom.
	 * @return short[] containing the columns of the card
	 */
	public short[] getColumnData() ;

	/**
	 * Get an character representation of the card data.  Some format factories will
	 * alter input data based on representational limitations.
	 * @return char[] of the data actually represented in the card.
	 */
	public char[] getInterpretation() ;

	/**
	 * Get the CardFormat for the card image.  This allows a separate pointer to a 
	 * card format, rather than representing the format information in each card image.
	 * @return CardFormat object
	 */
	public CardFormat getCardFormat();


}
