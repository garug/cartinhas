package br.com.cartinhas.entity.dto;

import java.util.List;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.enuns.EColor;
import br.com.cartinhas.enuns.ERarity;

public class CardDTO {
	private String name;
	private String manaCost;
	private ERarity rarity;
	private String set;
	private String imageUrl;
	private List<EColor> colors;
	private List<String> types;

	public CardDTO(Card entity) {
		this.name = entity.getNames().stream().filter(e -> "English".equals(e.getLanguage())).findAny().get().getName();
		this.manaCost = entity.getManaCost();
		this.rarity = entity.getRarity();
		this.set = entity.getSet();
		this.imageUrl = entity.getNames().stream().filter(e -> "English".equals(e.getLanguage())).findAny().get().getImageUrl();
		this.colors = entity.getColors();
		this.types = entity.getTypes();
	}

	public String getName() {
		return name;
	}

	public String getManaCost() {
		return manaCost;
	}

	public ERarity getRarity() {
		return rarity;
	}

	public String getSet() {
		return set;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}

	public List<EColor> getColors() {
		return colors;
	}

	public List<String> getTypes() {
		return types;
	}
}
