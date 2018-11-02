package br.com.cartinhas.enuns;

public enum EColor {

	Black("Black"),
    Blue("Blue"),
    Green("Green"),
    Red("Red"),
    White("White");

    private String descricao;

    private EColor(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
