package br.com.cartinhas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.repository.DeckRepository;
import br.com.cartinhas.service.DeckService;

@RestController
@RequestMapping("deck")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private DeckService deckService;
    
    @GetMapping(value="/{id}")
    public Optional<Deck> getById(@PathVariable("id") Long id) {
    	return deckRepository.findById(id);
    }

    @GetMapping
    public List<Deck> getDeck(){
        return deckRepository.findAll();
    }

    @PostMapping
    public Deck setDeck(@RequestBody Deck deck){
        return deckService.save(deck);
    }

    @PutMapping
    public Deck batata(@RequestBody Deck deck){
        return deckRepository.save(deck);
    }
}
