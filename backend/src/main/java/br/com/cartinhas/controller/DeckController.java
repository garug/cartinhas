package br.com.cartinhas.controller;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("deck")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Deck> getDeck(){
        return deckRepository.findAll();
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Deck setDeck(@RequestBody Deck deck){
        return deckRepository.save(deck);
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public Deck batata(@RequestBody Deck deck){
        return deckRepository.save(deck);
    }
}
