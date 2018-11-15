package br.com.cartinhas.entity.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.entity.converter.CardConverter;

public class DeckDTO {
	private Long id;
	private String name;
	private List<CardDTO> cards;
	private Long countM;
	private Long countR;
	private Long countU;
	private Long countC;
	
	private CardConverter cardConverter = new CardConverter();

	public DeckDTO(Deck entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cards = cardConverter.convertToDTO(entity.getCards());
		this.countM = entity.getCountM();
		this.countR = entity.getCountR();
		this.countU = entity.getCountU();
		this.countC = entity.getCountC();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<CardDTO> getCards() {
		return cards;
	}

	public Long getCountM() {
		return countM;
	}

	public Long getCountR() {
		return countR;
	}

	public Long getCountU() {
		return countU;
	}

	public Long getCountC() {
		return countC;
	}

}
