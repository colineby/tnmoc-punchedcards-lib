package tnmoc.punchedcards;

import java.awt.Shape;

public interface  Card {
	public short[] getColumnData() ;

	public char[] getInterpretation() ;

	public int getRows();
	
	public char[] getColumnFormat();

	public int getColumns() ;

	public float getHeight() ;

	public float getWidth() ;

	public float getLeftPad() ;

	public float getRightPad() ;

	public float getTopPad();

	public float getBottomPad() ;

	public Shape getHole() ;



}
