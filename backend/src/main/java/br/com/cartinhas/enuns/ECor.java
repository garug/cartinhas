package br.com.cartinhas.enuns;

public enum ECor {

    AZUL("Azul"),PRETO("Preto");

    private String descricao;

    private ECor(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
