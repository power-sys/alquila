package com.powersys.alquila.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fileUri;
	private String description;
	
	public Image() {
		
	}
	
	public String getFileUri() {
		return fileUri;
	}
	
	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
