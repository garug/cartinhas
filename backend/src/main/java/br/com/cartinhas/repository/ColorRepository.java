package br.com.cartinhas.repository;

import br.com.cartinhas.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color,Long> {
}
