package com.itc.restclient.execeptions;

public class EmailnotFoundEx extends RuntimeException {
	
	String accountnumber;
	
	public EmailnotFoundEx(String message, String accountnumber)
	{
		super(message);
		this.accountnumber = accountnumber;
	}
	

	public String get()
	{
		return accountnumber;
	}
	
	
}
