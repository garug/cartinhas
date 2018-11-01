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
    private String cardImp;

    @Transient
    private List<Color> colors;

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

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> cores) {
        this.colors = cores;
    }

    public Long getCountM() {
        return cards.stream().filter(c -> c.getRarity().equals("mitica")).count();
    }

    public Long getCountR() {
        return cards.stream().filter(c -> c.getRarity().equals("rara")).count();
    }

    public Long getCountU() {
        return cards.stream().filter(c -> c.getRarity().equals("incomum")).count();
    }

    public Long getCountC() {
        return cards.stream().filter(c -> c.getRarity().equals("normal")).count();
    }
}
