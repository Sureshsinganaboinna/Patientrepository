package com.itc.restclient.pojo;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class Country {
	
	 @NotNull(message = "Country name cannot be null")
	    private String name;

	    private List<State> states;

	    // Constructor
	    public Country(String name, List<State> states) {
	        this.name = name;
	        this.states = states;
	    }

	    // Getters and Setters
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<State> getStates() {
	        return states;
	    }

	    public void setStates(List<State> states) {
	        this.states = states;
	    }

}
