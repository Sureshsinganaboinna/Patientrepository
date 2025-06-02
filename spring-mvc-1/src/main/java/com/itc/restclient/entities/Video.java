package com.itc.restclient.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Videos")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="videoId")
	private int id;
	
	private String description;
	private String title;
	private String videoPath;
	private int noOfLikes;
	private int noOfDislikes;
	private String channelPath;

}
