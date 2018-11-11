package br.com.cartinhas.entity;

import javax.persistence.Entity;

@Entity
public class CardName {
	private String name;
	private String language;
	private String imageUrl;
	
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
