package tnmoc.punchedcards.powers;


import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import tnmoc.punchedcards.Card;
import tnmoc.punchedcards.CardFactory;

public class Powers implements CardFactory {
	private static char[] chars =  { 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'J', 'L', 'M', 'N', 
			'P', 'Q', 'R', 'T',  'V', 'W', 'X', 'Y'};
	private static char[] columnFormat = new char[]{'B','A','0','1','2','3','4','5','6','7','8','9'};
	private static int columns = 40;
	private  static int rows = 12;

	public Card getCard(String request)
	{

		short[] cols = new short[40];
		char[] _chars = new char[40];
		char[] _s= request.toUpperCase().toCharArray();
		for(int i = 0; i < _chars.length; i++ ){
			if(_s.length>i)
				_chars[i] = _s[i];
			else
				_chars[i] = ' ';
		}


		for( int i = 0; i < _chars.length; i++){
			if(_chars[i]==' '){
				cols[i] = getColumnForNumber((short)0);	
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
				cols[i] = getColumnForNumber((short)6);
			}
			else if(_chars[i]=='O'){
				cols[i] = 0;
				_chars[i] = '0';
			}			
			else if(_chars[i]=='Z') {
				cols[i] = getColumnForNumber((short)2);;
				_chars[i] = '2';
			}
			else if(_chars[i]=='U') {
				cols[i] = getColumnForLetter('V');
				_chars[i] = 'V';
			}
			else if(_chars[i]=='K') {
				cols[i] = getColumnForLetter('X');
				_chars[i] = 'X';
			}
			else if(isInt(_chars[i])){
				int c = getInt(_chars[i]);
				if(c >0)
					cols[i] = (short) (1 << (c+2));
			}
			else{

				cols[i] = getColumnForLetter(_chars[i]);
			}

		}

		return new Card(){
			public float getBottomPad() {
				return 2.6458f;
			}

			
			
			@Override
			public short[] getColumnData() {
				return cols;
			}

			

			@Override
			public char[] getInterpretation() {
				return _chars;
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
			public Shape getHole() {

				return new Ellipse2D.Float(-1f, -1f, 9.0f, 9.0f);
			}



			@Override
			public char[] getColumnFormat() {
				
				return columnFormat;
			}

		};


	}
	
	


	private static short getColumnForNumber(short digit){
		short col = 0;
		if(digit == 0) return col;
		col = (short)(1 << digit+2);

		return col;
	}

	private static short getColumnForLetter(char letter){


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
	private static boolean isInt(char c){
		try{
			Integer.parseInt(Character.toString(c));
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	private static int getInt(char c){
		try{
			return Integer.parseInt(Character.toString(c));
		}catch(Exception ex){
			return -1;
		}
	}
	private static int find(char[] array, char value) {
		for(int i=0; i<array.length; i++) {
			if(array[i] == value)
				return i;
		}
		return -1;
	}
	  
}
