package com.ncet.spenoues;

public class InvalidException  extends Exception {
	
		int c;
		InvalidException(int s)
		{
			int id =s;
		}
	   public String toString() {
		return "InvalidException [" + c+"]" ;
		
	       }
	}



