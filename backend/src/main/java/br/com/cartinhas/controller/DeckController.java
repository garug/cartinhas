package br.com.cartinhas.controller;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.repository.DeckRepository;
import br.com.cartinhas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("deck")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private DeckService deckService;
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Deck> getById(@PathVariable("id") Long id) {
    	return deckRepository.findById(id);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Deck> getDeck(){
        return deckRepository.findAll();
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public Deck setDeck(@RequestBody Deck deck){
        return deckService.save(deck);
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public Deck batata(@RequestBody Deck deck){
        return deckRepository.save(deck);
    }
}
