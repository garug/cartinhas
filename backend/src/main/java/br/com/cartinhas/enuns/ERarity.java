package br.com.cartinhas.enuns;

public enum ERarity {

    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    MYTHIC_RARE("Mythic Rare"),
    SPECIAL("Special"),
    BASIC_LAND("Basic Land");

    private String description;

    private ERarity(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ERarity getByDescription(String description){
        if (description == null)
            return null;
        for (ERarity e : ERarity.values()){
            if (e.description.equals(description))
                return e;
        }
        return null;
    }
}
