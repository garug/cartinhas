package br.com.cartinhas.enuns;

public enum EColor {

    AZUL("Azul"),PRETO("Preto");

    private String descricao;

    private EColor(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
