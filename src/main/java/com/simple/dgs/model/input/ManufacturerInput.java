package com.simple.dgs.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ManufacturerInput{
	
	private String name;	
	private String website;
	private String phone; 
	private String street; 
	private String city; 
	private String state; 
	private String country;
	
}