package br.com.cartinhas.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany()
    @JoinTable(name = "DECK_CARTAS")
    private List<Card> cards;

    @Transient
    private List<Color> colors;

    @Transient
    private Integer countM;

    @Transient
    private Integer countR;

    @Transient
    private Integer countU;

    @Transient
    private Integer countC;

//    Constructor
    public Deck() {

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
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Color> getColors() {
        if(!cards.isEmpty()){
            cards= new ArrayList<>();
            cards.forEach(c -> colors.addAll(c.getColors()));
        }
        return colors;
    }

    public void setColors(List<Color> cores) {
        this.colors = cores;
    }

    public Integer getCountM() {
        countM=0;
        for (Card card :cards) {
            if(card.getRarity().equals("mitica")){
                countM++;
            }
        }
        return countM;
    }

    public void setCountM(Integer countM) {
        this.countM = countM;
    }

    public Integer getCountR() {
        countR=0;
        for (Card card :cards) {
            if(card.getRarity().equals("rara")){
                countR++;
            }
        }
        return countR;
    }

    public void setCountR(Integer countRara) {
        this.countR = countRara;
    }

    public Long getCountU() {
        return cards.stream().filter(c -> c.getRarity().equals("incomum")).count();
    }

    public void setCountU(Integer countIncomum) {
        this.countU = countIncomum;
    }

    public Integer getCountC() {
        countC=0;
        for (Card card :cards) {
            if(card.getRarity().equals("normal")){
                countC++;
            }
        }
        return countC;
    }

    public void setCountC(Integer countC) {
        this.countC = countC;
    }
}
