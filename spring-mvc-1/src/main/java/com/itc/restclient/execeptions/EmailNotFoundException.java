package com.itc.restclient.execeptions;

public class EmailNotFoundException extends RuntimeException {

	String accountnumber;
	
	public EmailNotFoundException(String message, String accountnumber)
	{
		super(message);
		this.accountnumber = accountnumber;
	}
	public String getAccountNumber()
	{
		return this.accountnumber;
	}
	
	//404 NOT FOUND means when our exceptions like source account not found, number is not found 
}
