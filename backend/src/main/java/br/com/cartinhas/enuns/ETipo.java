package br.com.cartinhas.enuns;

public enum ETipo {

    AZUL("Azul"),PRETO("Preto");

    private String descricao;

    private ETipo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
