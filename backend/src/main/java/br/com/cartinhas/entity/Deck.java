package br.com.cartinhas.entity;

import br.com.cartinhas.enuns.ECor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany()
    @JoinTable(name = "DECK_CARTAS")
    private List<Carta> cartas;

    @Transient
    private List<Cor> cores;

    @Transient
    private Integer countMitica;

    @Transient
    private Integer countRara;

    @Transient
    private Integer countIncomum;

    @Transient
    private Integer countNormal;

    public Deck() {

    }

    public Deck(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Cor> getCores() {
        if(!cartas.isEmpty()){
            cores= new ArrayList<>();
            for (Carta carta:cartas) {
                cores.addAll(carta.getCores());
            }
        }
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }

    public Integer getCountMitica() {
        countMitica=0;
        for (Carta carta:cartas) {
            if(carta.getRaridade().equals("mitica")){
                countMitica++;
            }
        }
        return countMitica;
    }

    public void setCountMitica(Integer countMitica) {
        this.countMitica = countMitica;
    }

    public Integer getCountRara() {
        countRara=0;
        for (Carta carta:cartas) {
            if(carta.getRaridade().equals("rara")){
                countRara++;
            }
        }
        return countRara;
    }

    public void setCountRara(Integer countRara) {
        this.countRara = countRara;
    }

    public Integer getCountIncomum() {
        countIncomum=0;
        for (Carta carta:cartas) {
            if(carta.getRaridade().equals("incomum")){
                countIncomum++;
            }
        }
        return countIncomum;
    }

    public void setCountIncomum(Integer countIncomum) {
        this.countIncomum = countIncomum;
    }

    public Integer getCountNormal() {
        countNormal=0;
        for (Carta carta:cartas) {
            if(carta.getRaridade().equals("normal")){
                countNormal++;
            }
        }
        return countNormal;
    }

    public void setCountNormal(Integer countNormal) {
        this.countNormal = countNormal;
    }
}
