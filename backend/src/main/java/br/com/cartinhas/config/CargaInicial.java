package br.com.cartinhas.config;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.repository.CardRepository;
import br.com.cartinhas.repository.DeckRepository;
import io.magicthegathering.javasdk.api.CardAPI;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DeckRepository deckRepository;
    
    @Autowired
    private CardRepository cardRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        List<Deck> decks = deckRepository.findAll();
        List<String> filter = Arrays.asList("name=teferi");
        
        List<io.magicthegathering.javasdk.resource.Card> cardsAPI = CardAPI.getAllCards(filter);
        
        cardsAPI.forEach(e -> cardRepository.save(new Card(e.getId(), e.getColors(), e.getManaCost(), e.getRarity(), e.getTypes())));

        if (decks.isEmpty()) {

            createDeck("Deck 1");
            createDeck("Deck 3");
            createDeck("Deck 4");
            createDeck("Deck 2");
        }
    }

    public void createDeck(String name) {

        Deck deck = new Deck(name);
        for(int i=0;i<10;i++){
        	Random rand = new Random();
        	List<Card> allCards = cardRepository.findAll();
        	deck.getCards().add(allCards.get(rand.nextInt(allCards.size())));
        }
        deckRepository.save(deck);
    }

}
