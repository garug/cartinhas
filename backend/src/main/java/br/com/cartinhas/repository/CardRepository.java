package br.com.cartinhas.repository;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {

    Card findByIdReference(String id);
}
