package br.com.cartinhas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.repository.CardRepository;
import br.com.cartinhas.repository.DeckRepository;
import io.magicthegathering.javasdk.api.CardAPI;

@Service
public class DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private CardRepository cardRepository;

    public Deck save(Deck deck) {

//        deck = trataCadsDeck(deck);

       return null;
    }

//    private Deck trataCadsDeck(Deck deck) {
//        String language = "Portuguese (Brazil)";//mudar para message.properties quando for feia a internacionalizacao
//        Scanner scanner = new Scanner(deck.getCardImp());
//        
//        int qtd = 0;        
//        while(scanner.hasNextLine()){
//        	String card = scanner.nextLine();
//        	qtd= Integer.valueOf(card.substring(0, card.indexOf(" ")));
//            for (int i =0; i<qtd;i++){
//                Card cardAux;
//                String name = card.substring(card.indexOf(" "), card.indexOf("(")).trim();
//                String set = card.substring(card.indexOf("(")+1, card.indexOf(")")).trim();
//                if(set.equals("DAR")){
//                    set+="|DOM";
//                }
//
//                List<String> filter = new ArrayList<String>();
//                filter.add("name="+name);
//                filter.add("set="+set);
//                filter.add("language="+language);
//
//                List<io.magicthegathering.javasdk.resource.Card> cardsAPI = pesquisaAPI(filter);
//
//                for(io.magicthegathering.javasdk.resource.Card cardAPI : cardsAPI){
//                    Card findCard = cardRepository.findByIdReference(cardAPI.getId());
//                    if(findCard == null){
////                        cardAux = cardRepository.save(new Card(cardAPI.getId(), cardAPI.getColors(), cardAPI.getManaCost(), cardAPI.getRarity(), cardAPI.getTypes()));
//                    }else{
//                        cardAux = findCard;
//                    }
//                    deck.getCards().add(cardAux);
//                }
//
////                cardRepository.save(cardAux);
//            }
//        }
//        scanner.close();
//        return deck;
//    }

    private List<io.magicthegathering.javasdk.resource.Card> pesquisaAPI(List<String> filter) {
        List<io.magicthegathering.javasdk.resource.Card> cardsAPI = null;

        try{
            cardsAPI = CardAPI.getAllCards(filter);
        } catch (Exception e){
            pesquisaAPI( filter);
        }

        return cardsAPI;

    }
}
