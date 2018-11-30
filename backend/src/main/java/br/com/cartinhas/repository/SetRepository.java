package br.com.cartinhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cartinhas.entity.Set;
import br.com.cartinhas.repository.custom.SetCustom;

public interface SetRepository extends JpaRepository<Set, Long>, SetCustom {
}
