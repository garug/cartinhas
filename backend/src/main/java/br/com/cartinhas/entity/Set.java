package br.com.cartinhas.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Set {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String code;
	private LocalDate releaseDate;
	private int totalCards;
	
	public Set(String name, String code, LocalDate releaseDate) {
		this.name = name;
		this.code = code;
		this.releaseDate = releaseDate;
	}

	public Set(String name, String code, LocalDate releaseDate, int totalCards) {
		this.name = name;
		this.code = code;
		this.releaseDate = releaseDate;
		this.totalCards = totalCards;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public int getTotalCards() {
		return totalCards;
	}
	
	public void setTotalCards(int totalCards) {
		if (this.totalCards == 0) {
			this.totalCards = totalCards;
		} else {
			throw new RuntimeException("This SET already have total cards");
		}
	}
}
