package br.com.cartinhas.entity;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.cartinhas.enuns.EColor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    private String idReference;
    
    @Transient
    private String name;

    @ElementCollection
    private List<EColor> colors;
    
    private String manaCost;    
    private String rarity;
    
    @ElementCollection
    private List<String> types;

    public Card(){ }
    
    public Card(String idReference, List<EColor> colors, String manaCost, String rarity){
    	this.idReference = idReference;
    	this.colors = colors;
    	this.manaCost = manaCost;
    	this.rarity = rarity;
    }
    
    public Card(String idReference, String[] colors, String manaCost, String rarity, String[] types){
    	this.idReference = idReference;
    	if (colors != null) {
   
    		this.colors = Arrays.asList(colors).stream()
    				.map(e -> EColor.valueOf(e))
    				.collect(Collectors.toList());
    	}
    	
    	this.manaCost = manaCost;
    	this.rarity = rarity;
    	this.types = Arrays.asList(types);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public List<EColor> getColors() {
        return colors;
    }

    public void setColors(List<EColor> colors) {
        this.colors = colors;
    }
}
