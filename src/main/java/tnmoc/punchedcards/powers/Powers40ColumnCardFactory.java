package tnmoc.punchedcards.powers;


import tnmoc.punchedcards.CardFormat;
import tnmoc.punchedcards.Card;
import tnmoc.punchedcards.CardFactory;

/**
 * Library class providing a factory to product Powers-Samas 40 Column punched card images. 
 * @author Colin Eby <colin.eby.uk@gmail.com>
 * @version 0.0
 * @since 6 August 2017
 */
public class Powers40ColumnCardFactory implements CardFactory {
	

	/**
	 * Returns a Card object describing a physical card, with a punching pattern and format 
	 * specific interpretation of the card content.
	 * @param request 	Input string to image as a punched card
	 * @return Card		tnmoc.punchedcards.Card interface compliant POJO describing the card
	 */
	public Card getCard(String request)
	{

		final short[] cols = new short[40];
		final char[] _chars = new char[40];
		final char[] _s= request.toUpperCase().toCharArray();
		for(int i = 0; i < _chars.length; i++ ){
			if(_s.length>i)
				_chars[i] = _s[i];
			else
				_chars[i] = ' ';
		}


		for( int i = 0; i < _chars.length; i++){
			if(_chars[i]==' '){
				cols[i] = Powers40ColumnCardFormat.getColumnForNumber((short)0);	
			}
			else if(_chars[i]=='I') { 
				_chars[i] = '1';
				cols[i] = (short)( 1 << 2);
			}
			else if(_chars[i]=='S') {
				_chars[i] = '8';
				cols[i] = (short)( 1 << 9);
			}
			else if(_chars[i]=='G'){
				_chars[i] = '6';
				cols[i] = Powers40ColumnCardFormat.getColumnForNumber((short)6);
			}
			else if(_chars[i]=='O'){
				cols[i] = 0;
				_chars[i] = '0';
			}			
			else if(_chars[i]=='Z') {
				cols[i] = Powers40ColumnCardFormat.getColumnForNumber((short)2);;
				_chars[i] = '2';
			}
			else if(_chars[i]=='U') {
				cols[i] = Powers40ColumnCardFormat.getColumnForLetter('V');
				_chars[i] = 'V';
			}
			else if(_chars[i]=='K') {
				cols[i] = Powers40ColumnCardFormat.getColumnForLetter('X');
				_chars[i] = 'X';
			}
			else if(Powers40ColumnCardFormat.isInt(_chars[i])){
				int c = Powers40ColumnCardFormat.getInt(_chars[i]);
				if(c >0)
					cols[i] = (short) (1 << (c+2));
			}
			else{

				cols[i] = Powers40ColumnCardFormat.getColumnForLetter(_chars[i]);
			}

		}

		return new Card(){
			@Override
			public short[] getColumnData() {
				return cols;
			}


			@Override
			public char[] getInterpretation() {
				return _chars;
		
			}

			@Override
			public CardFormat getCardFormat() {
				return Powers40ColumnCardFormat.create();
				
			}

		};
	}
	


	  
}
