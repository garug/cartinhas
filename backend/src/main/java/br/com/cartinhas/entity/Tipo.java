package br.com.cartinhas.entity;

import br.com.cartinhas.enuns.ETipo;

import javax.persistence.*;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ETipo nome;

    public Tipo(){}

    public Long getId() {
        return id;
    }

    public ETipo getNome() {
        return nome;
    }

    public void setNome(ETipo nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
