package com.example.demo.pojo;

import jakarta.validation.constraints.NotNull;

public class State {
	  @NotNull(message = "State name cannot be null")
	    private String name;

	    // Constructor
	    public State(String name) {
	        this.name = name;
	    }

	    // Getters and Setters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

}
