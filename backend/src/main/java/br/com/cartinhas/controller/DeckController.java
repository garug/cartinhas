package br.com.cartinhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.entity.converter.DeckConverter;
import br.com.cartinhas.entity.dto.DeckDTO;
import br.com.cartinhas.repository.DeckRepository;
import br.com.cartinhas.service.DeckService;

@RestController
@RequestMapping("deck")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private DeckService deckService;
    
    @Autowired
    private DeckConverter deckConverter;
    
    @GetMapping(value="/{id}")
    public DeckDTO getById(@PathVariable("id") Long id) {
    	return deckConverter.convertToDTO(deckRepository.findById(id).orElse(new Deck()));
    }

    @GetMapping
    public List<DeckDTO> getDeck(){
        return deckConverter.convertToDTO(deckRepository.findAll());
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
