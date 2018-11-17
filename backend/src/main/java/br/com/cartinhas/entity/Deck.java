package br.com.cartinhas.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import br.com.cartinhas.enuns.ERarity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cartinhas.entity.converter.CardConverter;
import br.com.cartinhas.entity.dto.DeckDTO;
import br.com.cartinhas.enuns.EColor;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OrderBy("idReference")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany()
    @JoinTable(name = "DECK_CARTAS")
    private List<Card> cards;

    @Transient
    private String cardImp;

    @Transient
    private Long countM;

    @Transient
    private Long countR;

    @Transient
    private Long countU;

    @Transient
    private Long countC;
    
    @Autowired
    @Transient
    private CardConverter cardConverter;

//    Constructor
    public Deck() { }
    
    public Deck(DeckDTO dto) {
    	this.id = dto.getId();
		this.name = dto.getName();
		this.cards = cardConverter.convertToEntity(dto.getCards());
		this.countM = dto.getCountM();
		this.countR = dto.getCountR();
		this.countU = dto.getCountU();
		this.countC = dto.getCountC();
    }

    public Deck(String name) {
        this.name = name;
    }

//    Getters and Setters
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

    public List<Card> getCards() {
        if(cards ==null){
            cards = new ArrayList<>();
        }
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getCardImp() {
        return cardImp;
    }

    public void setCardImp(String cardImp) {
        this.cardImp = cardImp;
    }

    public List<EColor> getColors() {
    	
    	List<EColor> colors = new ArrayList<EColor>();
    	cards.forEach(c -> colors.addAll(c.getColors()));
        return colors.stream().distinct().collect(Collectors.toList());
    }

    public Long getCountM() {
        return cards.stream().filter(c -> c.getRarity().equals(ERarity.MYTHIC_RARE)).count();
    }

    public Long getCountR() {
        return cards.stream().filter(c -> c.getRarity().equals(ERarity.RARE)).count();
    }

    public Long getCountU() {
        return cards.stream().filter(c -> c.getRarity().equals(ERarity.UNCOMMON)).count();
    }

    public Long getCountC() {
        return cards.stream().filter(c -> c.getRarity().equals(ERarity.COMMON)).count();
    }
}
