package br.com.cartinhas.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.Color;
import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.enuns.EColor;
import br.com.cartinhas.repository.CardRepository;
import br.com.cartinhas.repository.ColorRepository;
import br.com.cartinhas.repository.DeckRepository;
import io.magicthegathering.javasdk.api.CardAPI;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private ColorRepository colorRepository;
    
    @Autowired
    private CardRepository cardRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Color color = new Color(EColor.Blue);
        colorRepository.save(color);
        color = new Color(EColor.Black);
        colorRepository.save(color);

        List<Deck> decks = deckRepository.findAll();
        
        List<String> filter = new ArrayList<String>();
        filter.add("name=teferi");
        
        List<io.magicthegathering.javasdk.resource.Card> cardsAPI = CardAPI.getAllCards(filter);
        
        for(io.magicthegathering.javasdk.resource.Card cardAPI : cardsAPI){
        	cardRepository.save(new Card(cardAPI.getId(), cardAPI.getColors(), cardAPI.getManaCost(), cardAPI.getRarity(), cardAPI.getTypes()));
        }

        if (decks.isEmpty()) {

            createDeck("Deck 1");
            createDeck("Deck 3");
            createDeck("Deck 4");
            createDeck("Deck 2");
        }
    }

    public void createDeck(String name) {

        Deck user = new Deck(name);
        for(int i=0;i<10;i++){
        	Random rand = new Random();
        	List<Card> findAll = cardRepository.findAll();
        	user.getCards().add(findAll.get(rand.nextInt(findAll.size())));
        }
        deckRepository.save(user);
    }

}
