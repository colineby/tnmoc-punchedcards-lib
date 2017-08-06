package tnmoc.punchedcards;

/**
 * Base factory interface all card format factories should implement
 * @author Colin Eby <colin.eby.uk@gmail.com>
 * @since 6 August 2017
 * @version 0.0
 *
 */
public interface CardFactory {
	/**
	 * 
	 * @param request  String describing the content to build a card image from.
	 * @return Card  tnmoc.punchedcards.Card interface compliant card image description.
	 */
	public Card getCard(String request);
	
}