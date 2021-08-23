package com.cts.pointsmicroservice.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@ToString
public class Offer {
	
	//offer id
	private int id;
	
	//offer name
	private String name;
	
	//description of the offer
	private String description;
	
	//offer category
	private String category;
	
	//offer open date
	private Date openDate;
	
	//offer engaged date
	private Date engagedDate;
	
	//offer closed date
	private Date closedDate;
	
	//no. of likes
	private int likes;
}

