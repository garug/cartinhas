package br.com.cartinhas.service;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.Color;
import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.enuns.EColor;
import br.com.cartinhas.repository.CardRepository;
import br.com.cartinhas.repository.ColorRepository;
import br.com.cartinhas.repository.DeckRepository;
import io.magicthegathering.javasdk.api.CardAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
//                cardAux.setName(card.substring(card.indexOf(" "), card.indexOf("(")).trim());
//                cardAux.setRarity("mitica");//pegar da api
//                cardAux.setColors(Arrays.asList(colorRepository.findById(1L).get()));//pegar da api
                cardRepository.save(cardAux);
                deck.getCards().add(cardAux);
            }
        }
        return deck;
    }
}
