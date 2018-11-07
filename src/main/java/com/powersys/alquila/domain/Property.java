package com.powersys.alquila.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Address adress;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;

	private String description;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Detail> details;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Detail> legals;

	private Integer price;

	@Enumerated(EnumType.STRING)
	private PlaceType type;

	@ElementCollection
	private List<Image> images = new ArrayList<>();
	
	private LocalDateTime publishDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Detail> getDetails() {
		return details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public List<Detail> getLegals() {
		return legals;
	}

	public void setLegals(List<Detail> legals) {
		this.legals = legals;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public PlaceType getType() {
		return type;
	}

	public void setType(PlaceType type) {
		this.type = type;
	}

	public List<Image> getImages() {
		return images;
	}

	public void addImage(Image image) {
		this.images.add(image);
	}
	
	public void addImage(String path, String alt) {
		Image i = new Image();
		i.setFileUri(path);
		i.setDescription(alt);
		this.images.add(i);
	}

	public LocalDateTime getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDateTime publishDate) {
		this.publishDate = publishDate;
	}
}
