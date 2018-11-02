package br.com.cartinhas.service;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.Color;
import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.enuns.EColor;
import br.com.cartinhas.repository.CardRepository;
import br.com.cartinhas.repository.ColorRepository;
import br.com.cartinhas.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ColorRepository colorRepository;

    public Deck save(Deck deck) {

        deck = trataCadsDeck(deck);

       return deckRepository.save(deck);
    }

    private Deck trataCadsDeck(Deck deck) {

        String[] cards = deck.getCardImp().split(System.getProperty("line.separator"));
        int qtd = 0;
        for (String card: cards) {
            qtd= Integer.valueOf(card.substring(0, card.indexOf(" ")));
            for (int i =0; i<qtd;i++){
                Card cardAux = new Card();
                cardAux.setName(card.substring(card.indexOf(" "), card.indexOf("(")).trim());
                cardAux.setRarity("mitica");//pegar da api
                cardAux.setColors(Arrays.asList(colorRepository.findById(1L).get()));//pegar da api
                cardRepository.save(cardAux);
                deck.getCards().add(cardAux);
            }
        }
        return deck;
    }
    
    private Map<Integer,Card> readLine(String line) {
    	Card c = new Card();
    	Map<Integer, Card> m = new HashMap<Integer, Card>();
    	m.put(2, c);
    	return m;
    }

}
