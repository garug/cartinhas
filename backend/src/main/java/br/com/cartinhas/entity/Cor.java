package br.com.cartinhas.entity;

import br.com.cartinhas.enuns.ECor;
import br.com.cartinhas.enuns.ETipo;

import javax.persistence.*;

@Entity
public class Cor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ECor nome;

    public Cor(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ECor getNome() {
        return nome;
    }

    public void setNome(ECor nome) {
        this.nome = nome;
    }
}
