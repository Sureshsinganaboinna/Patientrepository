package com.example.demo.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserTransaction {
	@Schema(description = "money will be debited from from account and cretided to To account", example = "445789964566")
	private String fromAccount;
	@Schema(description = "money will be cretided to account from From account", example = "11224656565")
	private String toAccount;
	@Schema(description = "This amount will be debited from From account and will be credited To account", example = "556" )
	private Double amount;

}
