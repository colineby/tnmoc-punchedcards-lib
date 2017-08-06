package tnmoc.punchedcards;

import java.awt.Shape;

/** 
 * Describes the card format for a punched card.
 * @author Colin Eby <colin.eby.uk@gmail.com>
 * @since 6 August 2017
 * @version 0.0
 */
public interface CardFormat {
	
	/**
	 * Get the format's name
	 * @return String representation of the card format name
	 */
	public String getName();

	/**
	 * Get the number of potential punch holes in a column
	 * @return int representation of the number of holes in a column.
	 */
	public int getRows();
	
	/**
	 * Get the common description of each hole in the format (e.g. row 3 == digit 0, etc.)
	 * @return char[] containing single character descriptions of each row position.
	 */
	public char[] getColumnFormat();

	/**
	 * Get the number of columns in this format
	 * @return int of the number of columns.
	 */
	public int getColumns() ;
	
	/**
	 * Get the physical card height in mm
	 * @return float of the physical card height in mm
	 */
	public float getHeight() ;

	/**
	 * Get the physical card width in mm
	 * @return float of the physical card width in mm
	 */
	public float getWidth() ;

	/**
	 * Get the padding height of the card to the left of the first column in mm
	 * @return float of the left padding width
	 */
	public float getLeftPad() ;

	/**
	 * Get the padding width of the card to the right of the last column in mm
	 * @return float of the right padding width
	 */
	public float getRightPad() ;

	/**
	 * Get the padding height of the card to above of the first row in mm
	 * @return float of the top padding height
	 */
	public float getTopPad();

	/**
	 * Get the padding height of the card to below of the last row in mm
	 * @return float of the bottom padding height
	 */
	public float getBottomPad() ;

	/**
	 * Get a description of the punched hole form in mm dimensions. Location 
	 * will always return as x=-1, y=-1.
	 * @return Shap of the punched hole
	 */
	public Shape getHoleFormat() ;



}
