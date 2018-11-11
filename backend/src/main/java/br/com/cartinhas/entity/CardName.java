package br.com.cartinhas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String language;
	private String imageUrl;
	
	public CardName() { }
	
	public CardName(String name, String language, String imageUrl) {
		this.name = name;
		this.language = language;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public String getImageUrl() {
		return imageUrl;
	}
}
