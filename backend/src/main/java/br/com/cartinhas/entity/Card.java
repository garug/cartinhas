package br.com.cartinhas.entity;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import br.com.cartinhas.enuns.ERarity;
import com.google.gson.annotations.SerializedName;

import br.com.cartinhas.entity.dto.CardDTO;
import br.com.cartinhas.enuns.EColor;

@Entity
public class Card {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @SerializedName("id")
    private String idReference;
    
    @ElementCollection
    @SerializedName("foreignNames")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CardName> names;

    @ElementCollection
    private List<EColor> colors;
    
    @ElementCollection
    private List<String> types;
    
    private String manaCost;

    @Enumerated(EnumType.STRING)
    private ERarity rarity;
    private String set;
    

    public Card(){ }
    
    public Card(String idReference, List<CardName> names, List<EColor> colors, List<String> types, String manaCost, ERarity rarity, String set){
    	this.idReference = idReference;
    	this.names = names;
    	this.colors = colors;
    	this.types = types;
    	this.manaCost = manaCost;
    	this.rarity = rarity;
    	this.set = set;
    }
    
    public Card(CardDTO dto) {
    	this.colors = dto.getColors();
    	this.types = dto.getTypes();
    	this.manaCost = dto.getManaCost();
    	this.rarity = dto.getRarity();
    	this.set = dto.getSet();
    }

    public Long getId() {
        return id;
    }
    
    public String getIdReference() {
    	return this.idReference;
    }
    
    public List<CardName> getNames() {
    	return this.names;
    }
    
    public String getManaCost() {
    	return this.manaCost;
    }

    public ERarity getRarity() {
        return rarity;
    }

    public List<EColor> getColors() {
        return colors;
    }
    
    public List<String> getTypes() {
    	return this.types;
    }
    
    public String getSet() {
		return set;
	}
    
	private List<EColor> mapColors(String[] colors) {
    	return Arrays.asList(colors).stream()
				.map(e -> EColor.valueOf(e))
				.collect(Collectors.toList());
    }
    
    @Override
    public String toString() {
    	return this.names.get(0).getName();
    }
}
