package br.com.cartinhas.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import br.com.cartinhas.enuns.EColor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

//    Constructor
    public Deck() { }

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
        return cards.stream().filter(c -> c.getRarity().equals("Mythic Rare")).count();
    }

    public Long getCountR() {
        return cards.stream().filter(c -> c.getRarity().equals("Rare")).count();
    }

    public Long getCountU() {
        return cards.stream().filter(c -> c.getRarity().equals("Uncommon")).count();
    }

    public Long getCountC() {
        return cards.stream().filter(c -> c.getRarity().equals("Common")).count();
    }
}
