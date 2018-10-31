package br.com.cartinhas.config;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.entity.Tipo;
import br.com.cartinhas.enuns.ETipo;
import br.com.cartinhas.repository.DeckRepository;
import br.com.cartinhas.repository.TipoRepository;
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
    private TipoRepository tipoRepository;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        List<Deck> decks = deckRepository.findAll();

        Tipo tipo1 = new Tipo();
        Tipo tipo2 = new Tipo();
        if (tipoRepository.findAll().isEmpty()){
            tipo1.setNome(ETipo.AZUL);

            tipo2.setNome(ETipo.PRETO);

            tipoRepository.save(tipo1);
            tipoRepository.save(tipo2);
        }

        if (decks.isEmpty()) {



            createDeck("Deck 1", Arrays.asList(tipo1,tipo2));
            createDeck("Deck 2", Arrays.asList(tipo1,tipo2));
            createDeck("Deck 3", Arrays.asList(tipo1,tipo2));
            createDeck("Deck 4", Arrays.asList(tipo1,tipo2));

        }

    }

    public void createDeck(String name, List<Tipo> tipos) {

        Deck user = new Deck(name);
        deckRepository.save(user);
    }

}
