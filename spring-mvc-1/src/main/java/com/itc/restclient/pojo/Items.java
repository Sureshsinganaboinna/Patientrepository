package com.itc.restclient.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Items {
	private String productName;
	private Long quantity;
	private BigDecimal price;


}
