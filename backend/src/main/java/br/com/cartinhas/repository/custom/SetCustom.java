package br.com.cartinhas.repository.custom;

import br.com.cartinhas.entity.Set;

public interface SetCustom {
	Set findByCode(String code);
}
