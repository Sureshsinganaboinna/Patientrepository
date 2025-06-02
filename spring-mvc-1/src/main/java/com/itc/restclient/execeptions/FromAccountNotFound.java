package com.itc.restclient.execeptions;

public class FromAccountNotFound extends RuntimeException {
	private String Fromaccount;
	
 public FromAccountNotFound(String message, String Fromaccount)
 {
	 super(message);
	this.Fromaccount = Fromaccount;
 }

public String getFromaccount() {
	return Fromaccount;
}


 
 
 
 
}
