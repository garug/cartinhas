package br.com.cartinhas.repository;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo,Long> {
}
