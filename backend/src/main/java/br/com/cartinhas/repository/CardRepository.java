package br.com.cartinhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartinhas.entity.Card;

public interface CardRepository extends JpaRepository<Card,Long> {

    Card findByIdReference(String id);
}
