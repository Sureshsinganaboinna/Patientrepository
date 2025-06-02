package com.itc.restclient.pojo;

import lombok.Data;

@Data
public class TransferAmount {
	
	private String fromaccount;
	private String toaccount;
	private String transferamount;

}
