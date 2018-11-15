package br.com.cartinhas.entity.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseConverter<E,D> {
	public abstract D convertToDTO(E entity);
	public abstract E convertToEntity(D dto);
	
	public  List<D> convertToDTO(List<E> entities) {
		List<D> listDTO = new ArrayList<D>();
		if (entities != null) {
			entities.forEach(e -> listDTO.add(convertToDTO(e)));
		}
		return listDTO;
	}
	
	public List<E> convertToEntity(List<D> dtos) {
		List<E> listEntities = new ArrayList<E>();
		if (dtos != null) {
			dtos.forEach(e -> listEntities.add(this.convertToEntity(e)));
		}
		return listEntities;
	}
}
