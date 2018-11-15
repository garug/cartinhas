package br.com.cartinhas.entity.converter;

import org.springframework.stereotype.Component;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.dto.CardDTO;

@Component
public class CardConverter extends BaseConverter<Card, CardDTO> {

	@Override
	public CardDTO convertToDTO(Card entity) {
		return new CardDTO(entity);
	}

	@Override
	public Card convertToEntity(CardDTO dto) {
		return new Card(dto);
	}

}
