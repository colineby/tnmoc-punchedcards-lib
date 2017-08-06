package tnmoc.punchedcards.powers;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import tnmoc.punchedcards.CardFormat;

/**
 * Powers-Samas 40-Column Card Format representation.  This is a singleton and 
 * static content class providing reference data for the Powers 40-column card
 * 
 * @author Colin Eby <colin.eby.uk@gmail.com>
 * @since 6 August 2017
 * @version 0.0
 *
 */
public class Powers40ColumnCardFormat implements CardFormat {
	protected static final char[] chars =  { 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'J', 'L', 'M', 'N', 
			'P', 'Q', 'R', 'T',  'V', 'W', 'X', 'Y'};
	protected static final char[] columnFormat = new char[]{'B','A','0','1','2','3','4','5','6','7','8','9'};
	protected static final int columns = 40;
	protected static final int rows = 12;
	private static Powers40ColumnCardFormat thisFormat = null;
	
	private  Powers40ColumnCardFormat(){
		
	}
	
	/**
	 * Singleton factory method to create a pointer to the card format.
	 * @return Powers40ColumnCardFormat singleton instance
	 */
	public static Powers40ColumnCardFormat create(){
		if(thisFormat!=null)return thisFormat;
		thisFormat = new Powers40ColumnCardFormat();
		return thisFormat;
	}
	
	@Override
	public String getName(){
		return "Powers-Samas 40 Column Punched Card";
	}
	
	@Override
	public float getBottomPad() {
		return 2.6458f;
	}

	
	@Override
	public int getRows() {
		return rows;
	}

	

	@Override
	public int getColumns() {
		return columns;
	}

	

	@Override
	public float getHeight() {
		return 50.8f;
	}

	

	@Override
	public float getWidth() {
		
		return 119.0f;
	}



	@Override
	public float getLeftPad() {

		return 6.1595f;
	}

	

	@Override
	public float getRightPad() {

		return 6.1595f;
	}

	

	@Override
	public float getTopPad() {

		return 2.6458f;
	}



	@Override
	public Shape getHoleFormat() {
		return new Ellipse2D.Float(-1f, -1f, 9.0f, 9.0f);
	}



	@Override
	public char[] getColumnFormat() {		
		return columnFormat;
	}

	
	
    /**
     * Internal method providing bit pattern translation for a digit
     * @param digit short containing values from 0-9
     * @return short representing card's bit pattern format for a column
     */
	protected static short getColumnForNumber(short digit){
		short col = 0;
		if(digit == 0) return col;
		col = (short)(1 << digit+2);

		return col;
	}

	/**
     * Internal method providing bit pattern translation for character. This method
     * will translate to the apporpriate substitution based on for format specification. 
     * @param char containing values from A-Z
     * @return short representing card's bit pattern format for a column
     */
	protected static short getColumnForLetter(char letter){
		if(find(chars,letter) < 9){
			short colNumber = getColumnForNumber((short)(find(chars,letter)+1));
			int i =  colNumber | 1;
			return (short)i;
		} else {
			short colNumber = getColumnForNumber((short)(find(chars,letter)-8));
			int i = ( colNumber) | 2;
			return (short)i;
		}
	}
	
	/**
     * Simple utility method to separate pure chars from numbers
     * @param char containing values from A-Z,0-9
     * @return boolean indicating whether this is a digit
     */
	protected static boolean isInt(char c){
		try{
			Integer.parseInt(Character.toString(c));
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	/**
     * Simple utility method to translate char encoded numbers to integers
     * @param char containing values '0'-'9'
     * @return int digit representation
     */
	protected static int getInt(char c){
		try{
			return Integer.parseInt(Character.toString(c));
		}catch(Exception ex){
			return -1;
		}
	}
	
	/**
     * Utility method to translate char into an offset in the character set
     * @param char containing values 'A-Z'
     * @return int offset in the character set
     */
	private static int find(char[] array, char value) {
		for(int i=0; i<array.length; i++) {
			if(array[i] == value)
				return i;
		}
		return -1;
	}
	
	
}
