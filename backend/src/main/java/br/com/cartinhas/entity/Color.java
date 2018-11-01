package br.com.cartinhas.entity;

import br.com.cartinhas.enuns.EColor;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EColor nome;

    public Color(){}

    public Color(EColor nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EColor getNome() {
        return nome;
    }

    public void setNome(EColor nome) {
        this.nome = nome;
    }
}
