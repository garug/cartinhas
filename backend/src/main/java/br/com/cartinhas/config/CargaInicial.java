package br.com.cartinhas.config;

import br.com.cartinhas.entity.Color;
import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.enuns.EColor;
import br.com.cartinhas.repository.ColorRepository;
import br.com.cartinhas.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Color color = new Color(EColor.AZUL);
        colorRepository.save(color);
        color = new Color(EColor.PRETO);
        colorRepository.save(color);

        List<Deck> decks = deckRepository.findAll();

        if (decks.isEmpty()) {

            createDeck("Deck 1");
            createDeck("Deck 3");
            createDeck("Deck 4");
            createDeck("Deck 2");
        }
    }

    public void createDeck(String name) {

        Deck user = new Deck(name);
        deckRepository.save(user);
    }

}
