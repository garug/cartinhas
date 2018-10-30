package br.com.cartinhas.repository;

import br.com.cartinhas.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck,Long> {
}
