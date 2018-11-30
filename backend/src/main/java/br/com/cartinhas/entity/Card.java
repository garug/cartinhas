package br.com.cartinhas.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.gson.annotations.SerializedName;

import br.com.cartinhas.entity.dto.CardDTO;
import br.com.cartinhas.enuns.EColor;
import br.com.cartinhas.enuns.ERarity;

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
    
    @ManyToOne
    private Set set;
    

    public Card(){ }
    
    public Card(String idReference, List<CardName> names, List<EColor> colors, List<String> types, String manaCost, ERarity rarity, Set set){
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
    
    public Set getSet() {
		return set;
	}
    
    @Override
    public String toString() {
    	return this.names.get(0).getName();
    }
}
