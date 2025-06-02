package com.itc.restclient.apiresponse;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	
	public String result;
	public String status;
	public T data;

}
