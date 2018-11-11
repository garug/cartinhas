package br.com.cartinhas.entity;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.google.gson.annotations.SerializedName;

import br.com.cartinhas.enuns.EColor;

@Entity
public class Card {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private String rarity;
    

    public Card(){ }
    
    public Card(String idReference, List<CardName> names, List<EColor> colors, List<String> types, String manaCost, String rarity){
    	this.idReference = idReference;
    	this.names = names;
    	this.colors = colors;
    	this.types = types;
    	this.manaCost = manaCost;
    	this.rarity = rarity;
    }
    
    public Card(String idReference, List<EColor> colors, String manaCost, String rarity){
    	this.idReference = idReference;
    	this.colors = colors;
    	this.manaCost = manaCost;
    	this.rarity = rarity;
    }
    
    public Card(String idReference, String[] colors, String manaCost, String rarity, String[] types){
    	this.idReference = idReference;
    	if (colors != null) this.mapColors(colors);
    	this.manaCost = manaCost;
    	this.rarity = rarity;
    	this.types = Arrays.asList(types);
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

    public String getRarity() {
        return rarity;
    }

    public List<EColor> getColors() {
        return colors;
    }
    
    public List<String> getTypes() {
    	return this.types;
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
