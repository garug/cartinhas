package br.com.cartinhas.repository.implementations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cartinhas.entity.Set;
import br.com.cartinhas.repository.custom.SetCustom;

@Repository
@Transactional
public class SetRepositoryImpl implements SetCustom  {
	
    @PersistenceContext
    EntityManager entityManager;

	@Override
	public Set findByCode(String code) {
        Query query = entityManager.createNativeQuery("SELECT set.* FROM set as set " +
                "WHERE set.code IS ?", Set.class);

        query.setParameter(1, code);

        return (Set) query.getSingleResult();
	}

}
