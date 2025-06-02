package com.example.demo.pojo;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;

public class LocationSelection {
	 @NotEmpty(message = "Please select a country")
	    private String selectedCountry;

	    @NotEmpty(message = "Please select a state")
	    private String selectedState;

	    private List<Country> countries;

	    // Getters and Setters
	    public String getSelectedCountry() {
	        return selectedCountry;
	    }

	    public void setSelectedCountry(String selectedCountry) {
	        this.selectedCountry = selectedCountry;
	    }

	    public String getSelectedState() {
	        return selectedState;
	    }

	    public void setSelectedState(String selectedState) {
	        this.selectedState = selectedState;
	    }

	    public List<Country> getCountries() {
	        return countries;
	    }

	    public void setCountries(List<Country> countries) {
	        this.countries = countries;
	    }

}
