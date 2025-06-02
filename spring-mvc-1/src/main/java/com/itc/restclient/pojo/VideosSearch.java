package com.itc.restclient.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VideosSearch {
	
	@NotNull(message = "search word is missing")
	@NotBlank(message = "search word should notbe blank")
	@Size(message ="Minimum 2 charachteer must be entered")
	private String searchword;

}
