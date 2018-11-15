package br.com.cartinhas.entity.dto;

import java.util.List;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.enuns.EColor;

public class CardDTO {
	private String name;
	private String manaCost;
	private String rarity;
	private String set;
	private List<EColor> colors;
	private List<String> types;

	public CardDTO(Card entity) {
		this.name = entity.getNames().stream().filter(e -> "English".equals(e.getLanguage())).findAny().get().getName();
		this.manaCost = entity.getManaCost();
		this.rarity = entity.getRarity();
		this.set = entity.getSet();
		this.colors = entity.getColors();
		this.types = entity.getTypes();
	}

	public String getName() {
		return name;
	}

	public String getManaCost() {
		return manaCost;
	}

	public String getRarity() {
		return rarity;
	}

	public String getSet() {
		return set;
	}

	public List<EColor> getColors() {
		return colors;
	}

	public List<String> getTypes() {
		return types;
	}
}
