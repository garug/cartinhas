package br.com.cartinhas.entity.converter;

import org.springframework.stereotype.Component;

import br.com.cartinhas.entity.Deck;
import br.com.cartinhas.entity.dto.DeckDTO;

@Component
public class DeckConverter extends BaseConverter<Deck, DeckDTO> {

	@Override
	public DeckDTO convertToDTO(Deck entity) {
		return new DeckDTO(entity);
	}

	@Override
	public Deck convertToEntity(DeckDTO dto) {
		return new Deck(dto);
	}
}
