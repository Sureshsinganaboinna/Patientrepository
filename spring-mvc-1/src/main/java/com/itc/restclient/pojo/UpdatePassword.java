package com.itc.restclient.pojo;

import lombok.Data;

@Data
public class UpdatePassword {
	private int id;
	private String password;
	private String email;


}
